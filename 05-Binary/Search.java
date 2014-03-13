import java.util.*;
import java.io.*;

public class Search {

    public int rbsearch(int n, int[] L) { //Uses a helper because copying half the array each time seemed slow
        return rbsearchH(n, L, 0, L.length-1);
    }

    public int rbsearchH(int n, int[] L, int l, int u) {
	if ((u-l) == 1)
	    return -1;
	if (L[(l+u)/2] == n)
	    return (l+u)/2;
	else if (L[(l+u)/2] > n)
	    return rbsearchH(n, L, l, (l+u)/2);
	else
	    return rbsearchH(n, L, (l+u)/2, u);
    }

    public int ibsearch(int n, int[] L) {
	int l = 0;
	int u = L.length-1;
	int ans = (l+u)/2;

	while (L[ans] != n && (u-l) != 1) {
	    if (L[ans] > n)
		u = ans;
	    else
		l = ans;
	    ans = (l+u)/2;
	}
	
	if (L[ans] == n)
	    return ans;
	else
	    return -1;
    }
				
    public int lSearch(int value, int[] L) {
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
	Search s = new Search();
	int x = Integer.parseInt(args[0]);
	int[] b = new int[x];
	for (int i=0, j=0; i<b.length; i++, j++) {	    
	    j = j + r.nextInt(20);
	    b[i] = j;
	}
	long t;

	t = System.currentTimeMillis();
	System.out.println(s.rbsearch(b[50], b));
	System.out.println("Time: " + (System.currentTimeMillis() - t));

	t = System.currentTimeMillis();
	System.out.println(s.rbsearch(b[x/2], b));
	System.out.println("Time: " + (System.currentTimeMillis() - t));

	t = System.currentTimeMillis();
	System.out.println(s.ibsearch(b[50], b));
	System.out.println("Time: " + (System.currentTimeMillis() - t));

	t = System.currentTimeMillis();
	System.out.println(s.ibsearch(b[x/2], b));
	System.out.println("Time: " + (System.currentTimeMillis() - t));

	t = System.currentTimeMillis();
	System.out.println(s.lSearch(b[50], b));
	System.out.println("Time: " + (System.currentTimeMillis() - t));

	t = System.currentTimeMillis();
	System.out.println(s.lSearch(b[x/2], b));
	System.out.println("Time: " + (System.currentTimeMillis() - t));

	//In the last text case (b[x/2]) we can see binary sort being faster
	//When inputting 1000000
    }
}
