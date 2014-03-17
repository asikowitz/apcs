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
	int c = wall+1;

	store = a[pivot]; //Moves pivot to last place
	a[pivot] = a[high];
	a[high] = store;
	pivot = high;

	for (int i=low; i<high; i++) {
	    if (a[i] < a[pivot]) {
		c++;
		wall++;
	    }
	    else {
		while (c < high && a[c] >= a[pivot])
		    c++;
		if (c < high) {
		    store = a[c];
		    a[c] = a[i];
		    a[i] = store;
		    wall++;
		}
	    }
	}

	int rwall = wall;
	
	for (int j=wall; j < high; j++) {
	    if (a[j] == a[pivot]) {
		store = a[j];
		a[j] = a[rwall];
		a[rwall] = store;
		rwall++;
	    }
	}

	System.out.println((rwall + wall)/2); //Not sure what the purpose of this is

	store = a[pivot]; //Moves pivot to rwall
	a[pivot] = a[rwall];
	a[rwall] = store;

	int[] R1 = qsort(a, low, wall-1);
	int[] R2 = qsort(a, rwall+1, high);
	int[] ans = new int[a.length];

	for (int i=low; i<wall; i++)
	    ans[i]=R1[i];
	for (int i=wall; i<=rwall; i++)
	    ans[i] = a[wall];
	for (int i=rwall+1; i<=high; i++)
	    ans[i]=R2[i];

	return ans;
    }

    public static void main(String[] args) {
	Random r = new Random();
	final int n = 100;
	int[] a = new int[n];
	for (int i=0; i<n; i++)
	    a[i] = r.nextInt(15);

	Quicksort q = new Quicksort();
	System.out.println(Arrays.toString(a));
	System.out.println(Arrays.toString(q.qsort(a,0,n-1)));
    }
}
