import java.io.*;
import java.util.*;

public class Quick {
    Random r = new Random();

    public int quickselect(int[] a, int k, int low, int high) {
	if (low >= high)
	    return low;

	int pivot = r.nextInt(high-low)+low; //pick pivot
	int c = pivot + 1;
	int store;

	for (int i=low; i<high; i++) { //partitioning
	    if (a[i]>a[pivot]) {
		store = a[i];
		while (a[c]>a[pivot]) { //swaps until no swaps left
		    c++;
		    if (c > high) {
			int x=low;
			store = a[pivot];
			while (a[x] < a[pivot]) //moves pivot
			    x++;
			a[pivot] = a[x];
			a[x] = store;
			pivot = x;
			c = x-1;
		    }
		}
		a[i]=a[c];
		a[c]=store;
	    }
	}

	if (pivot == k)
	    return a[pivot];
	else if (pivot < k)
	    return quickselect(a, k, pivot+1, high);
	else
	    return quickselect(a, k, low, pivot-1);
    }

    public static void main(String[] args) {
	int x = Integer.parseInt(args[0]);
	int[] a = new int[x];
	for (int i=0; i<x; i++)
	    a[i] = i;

	Quick q = new Quick();
	System.out.println(q.quickselect(a, x/2, 0, x-1));
    }
}
