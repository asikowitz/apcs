import java.util.*;
import java.io.*;

public class Calc {
    Stack n = new Stack();
    Scanner scan = new Scanner(System.in);
    final String op = "+-/*^%";

    public String input(String s) {
	if (op.contains(s)) {
	    double y = n.pop();
	    double x = n.pop();
	    
	    if (s.equals("+"))
		n.push(x+y);
	    else if (s.equals("-"))
		n.push(x-y);
	    else if (s.equals("*"))
		n.push(x*y);
		else if (s.equals("/"))
		n.push(x/y);
		else if (s.equals("^"))
		n.push(Math.pow(x, y));
		else if (s.equals("%"))
		n.push(x%y);
	}
	else {
	    try {
		double x = Double.parseDouble(s);
		n.push(x);
	    }
	    catch (NumberFormatException e) {
		System.out.println(e);
	    }
	}

	try {
	    return trim(Double.toString(n.peek()));
	}
	catch (NullPointerException e) {
	    return ""+e;
	}
    }

    public String trim(String s) {
	if (s.substring(s.length()-2, s.length()).equals(".0"))
	    return s.substring(0, s.length()-2);
	else
	    return s;
    }

    public void clear() {
	n.clear();
    }

    public void run() {
	while(true) {
	    System.out.print("Input: ");
	    String s = scan.nextLine();
	    if (s.equals("clear"))
		clear();
	    else if (s.equals("quit"))
		System.exit(0);
	    else
		System.out.println(input(s) + " (" + n + ")");
	}
    }

    public static void main(String[] args) {
	Calc c = new Calc();
	c.run();
	/*System.out.println(c.input("3"));
	System.out.println(c.input("45"));
	System.out.println(c.input("+"));
	System.out.println(c.input("7"));
	System.out.println(c.input("%"));
	System.out.println(c.input("4"));
	System.out.println(c.input("-"));
	System.out.println(c.input(".5"));
	System.out.println(c.input("3"));
	System.out.println(c.input(".3"));
	System.out.println(c.input("/"));
	System.out.println(c.input("*"));
	System.out.println(c.input("^"));
	//Should be 2^5 = 32*/
    }
}
