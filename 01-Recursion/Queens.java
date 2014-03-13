import java.io.*;
import java.util.*;

public class Queens {
    private char[][] board;
    private int n;
    private boolean solved;

    public Queens(int n) {
	this.n = n;
	solved = false;
	board = new char[n][n];

	for (int i=0; i<n; i++) {
	    for (int j=0; j<n; j++)
		board[i][j] = '-';
	}
	
	decision(0);
    }

    public Queens() {
	this(5);
    }

    public String toString() {
	String s = "[0;0H";

	for (int i=0; i<n; i++) {
	    for (int j=0; j<n; j++) {
		s += board[i][j] + " ";
	    }
	    s += "\n";
	}

	return s;
    }

    private void delay(int n) //Copied from Maze.java
    {
	try {
	    Thread.sleep(n);
	}
	catch (InterruptedException e) {
	    System.exit(0);
	}
    }

    public void decision(int x) {
	if (x < n) {
	    for (int i=0; i<n; i++) {
		if (!solved)
		    solve(x, i);
	    }
	}
    }
    
    public void solve(int x, int y) {
	boolean valid = true;

	for (int i=0; i<n; i++) {
	    for (int j=0; j<n; j++) {
		if (board[i][j] == 'Q') {
		    if (Math.abs(x-i) == Math.abs(y-j) || y == j) //Checks diagonals and horizontals
			valid = false;
		}
	    }
	}
	
	if (valid) {
	    board[x][y] = 'Q';
	    System.out.println(this);
	    delay(25);
	    if (x+1 == n)
		solved = true;
	    else
		decision(x+1);

	    if (!solved) {
		board[x][y] = '-';
		System.out.println(this);
		delay(25);
	    }
	}
    }

    public static void main(String[] args) {
	Queens q = new Queens(5);
	System.out.println("[2J");
	System.out.println(q);
	
	delay(1000);
	
	q = new Queens(15);
	System.out.println("[2J");
	System.out.println(q);
    }	
}
