public class DoubleLL<E> {
    private class Node<E> {
	E data;
	Node<E> next, prev;

	public Node(E d) {
	    this.data = d;
	}

	public String toString() {
	    return "" + data;
	}

	public void setData(E d) {
	    data = d;
	}

	public E getData() {
	    return data;
	}

	public void setNext(Node<E> n) {
	    next = n;
	}

	public Node<E> getNext() {
	    return next;
	}

	public void setPrev(Node<E> p) {
	    prev = p;
	}

	public Node<E> getPrev() {
	    return prev;
	}
    }

    private Node<E> current;

    public void insert(E d) {
	Node<E> n = new Node<E>(d);
	if (current == null) {
	    current = n;
	}
	else if (current.getPrev() == null) {
	    n.setNext(current);
	    n.setPrev(current);
	    current.setNext(n);
	    current.setPrev(n);
	    current = n;
	}
	else {
	    n.setNext(current);
	    n.setPrev(current.getPrev());
	    current.getPrev().setNext(n);
	    current.setPrev(n);
	    current = n;
	}
    }

    public boolean delete(E d) {
	Node<E> tmp = current;
      	
	while (tmp.getNext() != current) {
	    if (tmp.getData() == d) {
		tmp.getPrev().setNext(tmp.getNext());
		tmp.getNext().setPrev(tmp.getPrev());
		return true;
	    }
	    tmp = tmp.getNext();
	}
	return false;
    }

    public int find(E d) {
	Node<E> tmp = current;
	int c = 0;

	while (tmp.getNext() != current) {
	    if (tmp.getData() == d)
		return c;
	    tmp = tmp.getNext();
	    c++;
	}

	return -1;
    }	

    public E getCurrent() {
	return current.getData();
    }

    public void forward() {
	if (current.getNext() != null)
	    current = current.getNext();
    }

    public void back() {
	if (current.getPrev() != null)
	    current = current.getPrev();
    }

    /*public String toString() {
	if (current == null)
	    return "";

	Node<E> tmp = current;

	while (tmp.getPrev() != null)
	    tmp = tmp.getPrev();

	String s = "";
	while (tmp != null) {
	    s = s + tmp.getData() + " ";
	    tmp = tmp.getNext();
	}

	return s;
	}*/

    public String toString() {
	String s = "";

	if (current == null)
	    return "";
	else if (current.getNext() == null)
	    return ""+current.getData();

	Node<E> tmp = current;

	while (tmp.getNext() != current) {
	    s = s + tmp.getData() + " ";
	    tmp = tmp.getNext();
	}

	s = s + tmp.getData() + " ";

	return s;
    }

    public static void main(String[] args) {
	DoubleLL<String> L = new DoubleLL<String>();
	System.out.println(L);
	L.insert("hello");
	System.out.println(L);
	L.insert("world");
	System.out.println(L);
	L.insert("three");
	System.out.println(L);
	L.insert("break");
	System.out.println(L);

	System.out.println(L.getCurrent());
	L.forward();
	System.out.println(L.getCurrent());
	L.insert("inserted");
	System.out.println(L);
	L.delete("three");
	System.out.println(L);
	L.forward();
	L.forward();
	System.out.println(L.getCurrent());
	L.insert("pizza");
	L.insert("cheese");
	L.insert("break");
	L.back();
	System.out.println(L);
	System.out.println(L.delete("break"));
	System.out.println(L);
	System.out.println(L.delete("break"));
	System.out.println(L);
	System.out.println(L.delete("break"));
	System.out.println(L);
	System.out.println(L.find("pizza"));
	System.out.println(L.find("no"));
    }
}