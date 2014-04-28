public class Stack {
    private double[] n;
    private int top;

    public Stack() {
	n = new double[10];
	top = -1;
    }

    public boolean isEmpty() {
	return top == -1;
    }

    public void push(double s) {
	if (top == n.length-1) {
	    double[] tmp = new double[n.length*10];
	    for (int i=0; i<n.length; i++)
		tmp[i] = n[i];
	    n = tmp;
	}

	top = top + 1;
	n[top] = s;
    }

    public double pop() {
	double s = 0;

	if (!isEmpty()) {
	    s = n[top];
	    //n[top] = null;
	    top = top - 1;
	}

	return s;
    }

    public double peek() {
	if (!isEmpty())
	    return n[top];
	return 0;
    }

    public String toString() {
	String s = "";
	for (int i=top; i>=0; i--)
	    s = s + n[i] + ", ";
	return s.substring(0,s.length()-2);
    }

    public void clear() {
	n = new
}
