import java.util.*;
import java.io.*;

public class Quicksort {
    Random r = new Random();

    public int[] qsort(int[] a, int low, int high) { //inclusive
	if (high-low <= 0)
	    return a;
	    
	//Copied from homework 06

	int[] b = new int[a.length];
	int h = high, l = low;
	int pivot = r.nextInt(high-low)+low; //pick pivot
	for (int i=low; i<=high; i++) { //partitioning
	    if (a[i] > a[pivot]) {
		b[h] = a[i];
		h--;
	    }
	    else if (a[i] < a[pivot]){
		b[l] = a[i];
		l++;
	    }
	}
	while (l <= h) { //deals with duplicates
	    b[l] = a[pivot];
	    l++;
	}
	pivot = h;

	for (int i=low; i<=high; i++) //Copy back
	    a[i] = b[i];

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
	System.out.println(Arrays.toString(q.qsort(a,0,n-1)));
    }
}
