import java.util.*;
import java.io.*;

public class Merge {
    public ArrayList<String> merge(ArrayList<String> a, ArrayList<String> b) {
	ArrayList<String> s = new ArrayList<String>();

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
	    for (String i : a)
		s.add(i);
	}
	else {
	    for (String i : b)
		s.add(i);
	}

	return s;
    }

    public ArrayList<String> mergesort(ArrayList<String> L) {
	if (L.size() == 1)
	    return L;
	else {
	    ArrayList<String> L1 = new ArrayList<String>();
	    ArrayList<String> L2 = new ArrayList<String>();
	    for (int i=0; i<L.size()/2; i++)
		L1.add(L.get(i));
	    for (int i=L.size()/2; i<L.size(); i++)
		L2.add(L.get(i));
	    return merge(mergesort(L1), mergesort(L2));
	}
    }

    public static void main(String[] args) {
	Merge m = new Merge();
        ArrayList<String> a = new ArrayList<String>();
	a.add("apple");
	a.add("banana");
	a.add("agave");
	a.add("zebra");
	a.add("Pickle");
	a.add("fish");
	a.add("walrus");
	System.out.println(m.mergesort(a));
    }
}
