import java.util.*;
import java.io.*;

public class Merge {
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

    public static void main(String[] args) {
	Merge m = new Merge();
	int[] a = {9,6,2,6,4,2,3,5,7,11};
	System.out.println(Arrays.toString(m.mergesort(a)));
    }
}
