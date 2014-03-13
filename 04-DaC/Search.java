import java.util.*;
import java.io.*;

public class Search { //Copied from homework 03
    public int[] merge(int[] a, int[] b) {
	int[] s = new int[a.length + b.length];

	int c1 = 0, c2 = 0;
	for (int i = 0; i < s.length; i++) {
	    if (c1 >= a.length) {
		s[i] = b[c2];
		c2++;
	    }
	    else if (c2 >= b.length) {
		s[i] = a[c1];
		c1++;
	    }
	    else if (a[c1] > b[c2]) {
		s[i] = b[c2];
		c2++;
	    }
	    else { //a[c1] <= b[c2]
		s[i] = a[c1];
		c1++;
	    }
	}

	return s;
    }

    public int[] mergesort(int[] L) {
	if (L.length == 1)
	    return L;
	else {
	    int[] L1 = Arrays.copyOfRange(L, 0, L.length / 2);
	    int[] L2 = Arrays.copyOfRange(L, L.length / 2, L.length);
	    return merge(mergesort(L1), mergesort(L2));
	}
    }

    public int search(int[] L, int value) { //Gives index of a instance of value...
	if (L.length == 1 && L[0] != value) {
	    System.out.println("Could not find value");
	    return (int) Math.pow(2, 64) * -1; //Couldn't think of a way to return something nice like -1... so unless there's an array of size 2^64 this will be negative...
	}
	else {
	    if (L[L.length/2] == value)
		return L.length/2;
	    else if (L[L.length/2] > value)
		return search(Arrays.copyOfRange(L, 0, L.length/2), value);
	    else
		return L.length/2 + search(Arrays.copyOfRange(L, L.length/2, L.length), value);
	}
    }

    public int lSearch(int[] L, int value) {
	int i = 0;

	while (i < L.length && L[i] != value)
	    i++;

	if (i == L.length)
	    return -1;
	else
	    return i;
    }

    public static void main(String[] args) {
	Random r = new Random();
	Search m = new Search();
	int[] b = new int[Integer.parseInt(args[0])];
	for (int i=0; i<b.length; i++)
	    b[i] = i;

	long t;

	t = System.currentTimeMillis();
	System.out.println(m.search(b, 100));
	System.out.println("Time: " + (System.currentTimeMillis() - t));

	t = System.currentTimeMillis();
	System.out.println(m.search(b, 5));
	System.out.println("Time: " + (System.currentTimeMillis() - t));

	t = System.currentTimeMillis();
	System.out.println(m.lSearch(b, 100));
	System.out.println("Time: " + (System.currentTimeMillis() - t));

	t = System.currentTimeMillis();
	System.out.println(m.lSearch(b, 5));
	System.out.println("Time: " + (System.currentTimeMillis() - t));
    }
}
