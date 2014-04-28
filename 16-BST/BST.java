public class BST {
    private Node root;

    public BST() {
	root = null;
    }

    public Node search(int x) {
	Node temp = root;
	while (temp != null) {
	    if (temp.getData() == x)
		return temp;
	    else if (temp.getData() < x)
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
