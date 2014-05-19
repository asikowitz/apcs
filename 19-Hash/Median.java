import java.util.*;
import java.io.*;

public class Median {
    private class MaxComparator implements Comparator<Integer> {
	public int compare(Integer x, Integer y)
	{
	    return y - x;
	}
    }

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    private double median;

    public Median() {
	maxHeap = new PriorityQueue<Integer>(10, new MaxComparator());
	minHeap = new PriorityQueue<Integer>(10); //Default is min-heap
    }

    public void add(int x) {
	if (x >= findMedian())
	    minHeap.add(x);
	else
	    maxHeap.add(x);

	if (maxHeap.size() - minHeap.size() >= 1)
	    minHeap.add(maxHeap.poll());
	if (minHeap.size() - maxHeap.size() >= 2)
	    maxHeap.add(minHeap.poll());

	System.out.println(minHeap + " : " +  maxHeap);
    }

    public double findMedian() {
	if (minHeap.size() == 0)
	    return 0;
	if (minHeap.size() > maxHeap.size())
	    return minHeap.peek();
	else
	    return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }

    public double removeMedian() {
	if (minHeap.size() > maxHeap.size())
	    return minHeap.poll();
	else
	    return (minHeap.poll() + maxHeap.poll()) / 2.0;
    }

    public String toString() {
	return ""+minHeap + " : " +  maxHeap;
    }

    public static void main(String[] args) {
	Median m = new Median();
	Random r = new Random();

	for (int i=0; i<11; i++)
	    m.add(r.nextInt(50));
	
	System.out.println(m.findMedian());
	System.out.println(m.removeMedian());
	System.out.println(m);
	System.out.println(m.findMedian());
	System.out.println(m.removeMedian());
	System.out.println(m);
	System.out.println(m.findMedian());
    }
}
