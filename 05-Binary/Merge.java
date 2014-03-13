import java.util.*;
import java.io.*;

public class Merge {
    public ArrayList<Comparable> merge(ArrayList<Comparable> a, ArrayList<Comparable> b) {
	ArrayList<Comparable> s = new ArrayList<Comparable>();

	while (a.size() > 0 && b.size() > 0) { //Purposefully slow
	    if (a.get(0).compareTo(b.get(0)) < 0) {
		s.add(a.get(0));
		a.remove(0);
	    }
	    else {
		s.add(b.get(0));
		b.remove(0);
	    }
	}

	if (a.size() > 0) {
	    for (Comparable i : a)
		s.add(i);
	}
	else {
	    for (Comparable i : b)
		s.add(i);
	}

	return s;
    }

    public ArrayList<Comparable> mergesort(ArrayList<Comparable> L) {
	if (L.size() == 1)
	    return L;
	else {
	    ArrayList<Comparable> L1 = new ArrayList<Comparable>();
	    ArrayList<Comparable> L2 = new ArrayList<Comparable>();
	    for (int i=0; i<L.size()/2; i++)
		L1.add(L.get(i));
	    for (int i=L.size()/2; i<L.size(); i++)
		L2.add(L.get(i));
	    return merge(mergesort(L1), mergesort(L2));
	}
    }

    public static void main(String[] args) {
	Merge m = new Merge();
        ArrayList<Comparable> a = new ArrayList<Comparable>();
	a.add("apple");
	a.add("banana");
	a.add("agave");
	a.add("zebra");
	a.add("Pickle");
	a.add("fish");
	a.add("walrus");

        ArrayList<Comparable> b = new ArrayList<Comparable>();
	b.add(1);
	b.add(5);
	b.add(7);
	b.add(3);
	b.add(-10);
	b.add(500);
	b.add(0);

	ArrayList<Comparable> p = new ArrayList<Comparable>();
	p.add(new Person("Joe", 10));
	p.add(new Person("Bob", 15));
	p.add(new Person("Guy", 13));
	p.add(new Person("Jim", 100));
	p.add(new Person("Andrew", -10));
	p.add(new Person("Pickle", 323));
	p.add(new Person("Zebra", 0));
	System.out.println(m.mergesort(a));
	System.out.println(m.mergesort(b));
	System.out.println(m.mergesort(p));
    }
}
