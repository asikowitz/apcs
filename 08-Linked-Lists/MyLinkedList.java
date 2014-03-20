public class MyLinkedList {

    private Node head;

    public MyLinkedList() {
	head = null;
    }
    
    public void add(String d) {
	Node tmp = new Node(d);
	tmp.setNext(head);
	head=tmp;
    }

    public void add(int i, String d) {
	Node n = head;
	Node tmp = new Node(d);

	if (i == 0)
	    add(d);
	else {
	    for (int x=0; x<i-1; x++)
		n = n.getNext();
	    Node m = n.getNext();
	    n.setNext(tmp);
	    tmp.setNext(m);
	}
    }

    public String get(int i) {
	Node n = head;
	for (int x=0; x<i; x++)
	    n = n.getNext();
	return n.getData();
    }

    public String set(int i, String s) {
	Node n = head;

	for (int x=0; x<i; x++)
	    n = n.getNext();

	String old = n.getData();
	n.setData(s);
	return old;
    }

    public String remove(int i) {
	Node n = head;

	for (int x=0; x<i-1; x++)
	    n = n.getNext();

	Node m = n.getNext();
	String old = m.getData();
	n.setNext(m.getNext());
	m.setNext(null);
	return old;
    }

    public int find(String s) {
	Node n = head;
	int c = 0;

	while (true) { //Will continue until return or error
	    if (n.getData() == s)
		return c;
	    c++;
	    n = n.getNext();
	}
    }

    public int length() {
	Node n = head;
	int c;
	
	if (head == null)
	    return 0;
	else
	    c = 1;
	
	while (n.getNext() != null) {
	    c++;
	    n = n.getNext();
	}
	return c;
    }

    public String toString() {
	String s= "";
	Node n = head;
	while(n.getNext() != null) {
	    s += n.getData();
	    if (n.getNext().getNext() != null)
		s += "->";
	    n = n.getNext();
	}
	return s;
    }

    public static void main(String[] args) {
	MyLinkedList L = new MyLinkedList();
	for (int i=0; i<10; i++)
	    L.add(Integer.toString(i));

	System.out.println(L);
	L.add(3, "Pizza");
	System.out.println(L);
	System.out.println(L.get(7));
	System.out.println(L.remove(5));
	System.out.println(L.set(7, "Chicken"));
	System.out.println(L);
	System.out.println(L.length());
	System.out.println(L.find("Pizza"));
	//System.out.println(L.find("SDFSDF"));
	//L.add(11, "error");
	//L.set(11, "error");
	//L.get(11);
	//L.remove(11);
    }
}
