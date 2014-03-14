import java.util.*;
import java.io.*;

public class Quicksort {
    Random r = new Random();

    public int[] qsort(int[] a, int low, int high) { //inclusive
	if (high-low <= 0)
	    return a;

	int store;
	int wall = low;
	int pivot = r.nextInt(high-low)+low; //pick pivot
	boolean valid = true;
	int c;

	store = a[pivot]; //Moves pivot to last place
	a[pivot] = a[high];
	a[high] = store;
	pivot = high;

	for (int i=low; i<high && valid; i++) {
	    c = wall+1;
	    if (i != pivot) {
		if (a[i] <= a[pivot])
		    wall++;
		else {
		    while (c < high && a[c] > a[pivot])
			c++;
		    if (c < high) {
			store = a[c];
			a[c] = a[i];
			a[i] = store;
			wall++;
		    }
		}
	    }
	}

	store = a[pivot]; //Moves pivot to wall
	a[pivot] = a[wall];
	a[wall] = store;
	pivot = wall;

	int[] R1 = qsort(a, low, pivot-1);
	int[] R2 = qsort(a, pivot+1, high);
	int[] ans = new int[a.length];

	for (int i=low; i<=pivot-1; i++)
	    ans[i]=R1[i];
	ans[pivot] = a[pivot];
	for (int i=pivot+1; i<=high; i++)
	    ans[i]=R2[i];

	return ans;
    }

    public static void main(String[] args) {
	Random r = new Random();
	final int n = 100;
	int[] a = new int[n];
	for (int i=0; i<n; i++)
	    a[i] = r.nextInt(100);

	Quicksort q = new Quicksort();
	System.out.println(Arrays.toString(a));
	System.out.println(Arrays.toString(q.qsort(a,0,n-1)));
    }
}
