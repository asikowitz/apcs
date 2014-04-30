public class BST {
    private Node root;

    public BST() {
	root = null;
    }

    public Node search(int x) {
	Node temp = root;
	while (temp.getData() != x && temp != null) {
	    if (temp.getData() < x)
		temp = temp.getRight();
	    else
		temp = temp.getLeft();
	}

	return temp;
    }

    public Node search2(Node c, int x) {
	if (c == null || c.getData() == x)
	    return c;
	else if (c.getData() < x)
	    return search2(c.getRight(), x);
	else
	    return search2(c.getLeft(), x);
    }

    public void delete(int x) {
	Node temp, second, temp2, next;
	int store;
	boolean isLeft;

	if (root.getData() == x) { //No dummy node
	    
	}
	else {
	    temp = root;
	    second = root;

	    while (temp.getData() != x && temp != null) {
		if (temp.getData() < x) {
		    second = temp;
		    temp = temp.getRight();
		}
		else {
		    second = temp;
		    temp = temp.getLeft();
		}
	    }

	    if (second.getData() < x)
	        isLeft = false;
	    else
		isLeft = true;

	    if (temp.getRight() == null)
	        setChild(second, temp.getLeft(), isLeft);
	    else if (temp.getLeft() == null)
	        setChild(second, temp.getRight(), isLeft);
	    else {
		temp2 = temp.getLeft();
		while (temp2.getRight() != null)
		    temp2 = temp2.getRight();
		store = temp2.getData();
		delete(temp2.getData());
		temp.setData(store);		
	    }
	}
    }

    public void setChild(Node n1, Node n2, boolean isLeft) {
	if (isLeft)
	    n1.setLeft(n2);
	else
	    n1.setRight(n2);
    }

    public void insert(int x) {
	Node second = root;
	Node temp = root;

	if (root == null) {
	    root = new Node(x);
	    return;
	}

	while (temp != null) {
	    if (root.getData() < x) {
		second = temp;
		temp = temp.getRight();
	    }
	    else {
		second = temp;
		temp = temp.getLeft();
	    }
	}
	
	if (second.getData() < x)
	    second.setRight(new Node(x));
	else
	    second.setLeft(new Node(x));
    }
}
