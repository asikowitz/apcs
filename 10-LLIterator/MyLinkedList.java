import java.util.*;
import java.io.*;

public class MyLinkedList<E> implements Iterable<E> {

    private class MyLLIterator<E> implements Iterator<E> {
	private Node<E> n;

	public MyLLIterator(Node<E> n) {
	    this.n = n;
	}

	public boolean hasNext() {
	    return n.getNext() != null;
	}

	public E next() {
	    n = n.getNext();
	    return n.getData();
	}

	public void remove() {}
    }

    private Node<E> head;
    private Node<E> tail;

    public MyLinkedList() {
	head = new Node<E>(null);
	tail = head;
    }

    public MyLLIterator<E> iterator() {
	MyLLIterator<E> li = new MyLLIterator<E>(head);
	return li;
    }
    
    /*public void add(String d) {
	Node<E> tmp = new Node<E>(d);
	tmp.setNext(head.getNext());
	head.setNext(tmp);
	}*/

    public void add(E d) {
	Node<E> n = new Node<E>(d);
	tail.setNext(n);
	tail = n;
    }

    public void add(int i, E d) {
	Node<E> n = head;
	Node<E> tmp = new Node<E>(d);
	
	for (int x=0; x<i; x++)
	    n = n.getNext();
	tmp.setNext(n.getNext());
	n.setNext(tmp);

	if (tmp.getNext() == null)
	    tail = tmp;
    }

    public E get(int i) {
	Node<E> n = head.getNext();
	for (int x=0; x<i; x++)
	    n = n.getNext();
	return n.getData();
    }

    public E set(int i, E s) {
	Node<E> n = head.getNext();

	for (int x=0; x<i; x++)
	    n = n.getNext();

	E old = n.getData();
	n.setData(s);
	return old;
    }

    public E remove(int i) {
	Node<E> n = head;

	for (int x=0; x<i; x++)
	    n = n.getNext();

	Node<E> m = n.getNext();
	E old = m.getData();
	n.setNext(m.getNext());
	m.setNext(null);
	return old;
    }

    public int find(E s) {
	Node<E> n = head.getNext();
	int c = 0;

	while (true) { //Will continue until return or error
	    if (n.getData().equals(s))
		return c;
	    c++;
	    n = n.getNext();
	}
    }

    public int length() {
	Node<E> n = head.getNext();
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

    /*public String toString() {
	String s= "";
	Node<E> n = head.getNext();
	while(n.getNext() != null) {
	    s += n.getData();
	    if (n.getNext().getNext() != null)
		s += "->";
	    n = n.getNext();
	}
	return s;
	}*/

    public String toString() { //New toString method uses iterator
	String s = "";
	for (E x : this)
	    s = s + x + " ";

	return s;
    }

    public static void main(String[] args) {
	MyLinkedList<String> L = new MyLinkedList<String>();
	for (int i=0; i<10; i++)
	    L.add(Integer.toString(i));

	System.out.println(L);
	L.add(1, "Pizza");
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
