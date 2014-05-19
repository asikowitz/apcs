import java.util.*;
import java.io.*;

public class Tests {
    public static void main(String[] args) {
	HashMap<String, Integer> hm = new HashMap<String, Integer>();
	TreeMap<String, Integer> tm = new TreeMap<String, Integer>();

	long t = System.nanoTime();
	for (int i=0; i < 100000; i++)
	    hm.put(Integer.toString(i), i);
	System.out.println("Hashmap Add: " + (System.nanoTime() - t));

	t = System.nanoTime();
	for (int i=0; i < 100000; i++)
	    tm.put(Integer.toString(i), i);
	System.out.println("Treemap Add: " + (System.nanoTime() - t));

	t = System.nanoTime();	
	for (int i=0; i<100000; i++)
	    hm.get(Integer.toString(i));
	System.out.println("Hashmap Get: " + (System.nanoTime() - t));

	t = System.nanoTime();
	for (int i=0; i<100000; i++)
	    tm.get(Integer.toString(i));
	System.out.println("Treemap Get: " + (System.nanoTime() - t));

	t = System.nanoTime();
	for (int i=50000; i > 0; i--) {
	    hm.remove(Integer.toString(i-1));
	    hm.remove(Integer.toString(100000-i));
	}
	System.out.println("Hashmap Remove: " + (System.nanoTime() - t));

	t = System.nanoTime();
	for (int i=50000; i > 0; i--) {
	    tm.remove(Integer.toString(i-1));
	    tm.remove(Integer.toString(100000-i));
	}
	System.out.println("Treemap Remove: " + (System.nanoTime() - t));
    }
}
