import java.util.*;
import java.io.*;

public class Heap { //MaxHeap
    public int[] a;
    int size;

    public Heap() {
	this(10);
    }

    public Heap(int n) {
	a = new int[n];
	size = 0;
    }

    public void grow() {
	int[] temp = new int[a.length*2];
	for (int i=0; i<a.length; i++)
	    temp[i] = a[i];
	a = temp;
    }

    public void insert(int x) {
	size++;
	if (size > a.length)
	    grow();

	a[size]=x;
	int pos = size;
	while (x > a[pos/2] && pos > 1) {
	    a[pos] = a[pos/2];
	    a[pos/2] = x;
	    pos = pos/2;
	}
    }

    public void delete(int r) {
	int i=0;
	while (i < a.length && a[i] != r)
	    i++;
	if (i < a.length) {
	    a[i] = a[size];
	    a[size] = 0;
	    int x = a[i];
	    int pos = i;
	    try { //Allows for getMax(pos*2) to run
		int max = getMax(pos*2);
		while (pos*2 <= size && x < a[max]) {
		    a[pos] = a[max];
		    a[max] = x;
		    pos = max;
		    max = getMax(pos*2);
		}
	    } catch (ArrayIndexOutOfBoundsException e) {}
	    while (x > a[pos/2] && pos > 1) {
		a[pos] = a[pos/2];
		a[pos/2] = x;
		pos = pos/2;
	    }
	    size--;
	}
    }


    public String toString() {
	String s = "";
	for (int i = 1; i<=size; i++)
	    s += a[i] + ", ";
	return s.substring(0,s.length()-2);
    }
	    
    public int getMin(int pos) {
	if (a[pos] < a[pos+1])
	    return pos;
	else
	    return pos + 1;
    }

    public int getMax(int pos) {
	if (a[pos] > a[pos+1])
	    return pos;
	else
	    return pos + 1;
    }

    public static void main(String[] args) {
	Heap h = new Heap();
	h.insert(2);
	h.insert(50);
	h.insert(3);
	h.insert(16);
	h.insert(14);
	h.insert(10);
	System.out.println(h);
	h.delete(16);
	System.out.println(h);
	h.delete(5);
	System.out.println(h);
	h.delete(50);
	System.out.println(h);
	h.insert(23);
	h.insert(5);
	h.delete(2);
	System.out.println(h);
    }
}
