public class Stack {
    private String[] n;
    private int top;

    public Stack() {
	n = new String[10];
	top = -1;
    }

    public boolean isEmpty() {
	return top == -1;
    }

    public void push(String s) {
	if (top == n.length-1) {
	    String[] tmp = new String[n.length*10];
	    for (int i=0; i<n.length; i++)
		tmp[i] = n[i];
	    n = tmp;
	}

	top = top + 1;
	n[top] = s;
    }

    public String pop() {
	String s = null;

	if (!isEmpty()) {
	    s = n[top];
	    n[top] = null;
	    top = top - 1;
	}

	return s;
    }

    public String peek() {
	if (!isEmpty())
	    return n[top];
	return null;
    }

    public String toString() {
	String s = "";
	for (int i=top; i>=0; i--)
	    s = s + n[i] + " ";
	return s.substring(0,s.length()-1);
    }

    public static void main(String[] args) {
	Stack s = new Stack();
	System.out.println(s.isEmpty());
	System.out.println(s.peek());
	System.out.println(s.pop());
	s.push("a");
	s.push("b");
	s.push("c");
	System.out.println(s);
	System.out.println(s.isEmpty());
	System.out.println(s.pop());
	System.out.println(s.peek());
	for (int i=0; i<10; i++)
	    s.push(Integer.toString(i));
	System.out.println(s);
    }
}
