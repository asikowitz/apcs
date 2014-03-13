import java.io.*;
import java.util.*;

public class Knights {
    private int[][] board;
    private Random r;
    private int counter;
    private int n;
    
    //Constructors
    //Default n=5, random starting point
    //All spots set to 0 except for starting position, which is 1

    public Knights(int n, int right, int down) {
	this.n = n;
	counter = 1;
	board = new int[n][n];

	for (int i=0; i<n; i++) {
	    for (int j=0; j<n; j++)
		board[i][j] = 0;
	}

	board[right][down] = 1;
	System.out.println(this);
	decision(right, down);
    }

    public Knights(int right, int down) {
	this(5, right, down);
    }

    public Knights() {
	this(5, (int) Math.random() * 5, (int) Math.random() * 5);
    }

    public String toString() {
	String s = ""; //"[0;0H";

	for (int i=0; i<n; i++) {
	    for (int j=0; j<n; j++) {
		if (Integer.toString(board[i][j]).length() == 1)
		    s += board[i][j] + "  ";
		else
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

    public void decision(int x, int y) {
	solve(x+1, y+2);
	solve(x+2, y+1);
	solve(x-1, y+2);
	solve(x-2, y+1);
	solve(x+1, y-2);
	solve(x+2, y-1);
	solve(x-1, y-2);
	solve(x-2, y-1);
    }
	    

    public void solve(int x, int y) {
	if (counter < n*n && x >= 0 && x < n && y >= 0 && y < n) {  //Does not work if puzzle solved, (x, y) not in bounds, or (x, y) already filled
	    if (board[x][y] == 0) {
		counter++;
		board[x][y] = counter;
		//delay(75);
		//System.out.println(this);
		decision(x, y);

		if (counter < n*n) { //If not solved, go back.
		    counter--;
		    board[x][y]=0;
		    //delay(75);
		    //System.out.println(this);
		}
	    }
	}
    }

    public static void main(String[] args) {
	Knights k;
	for (int i=0; i<5; i++) {
	    for (int j=0; j<5; j++) {
		k = new Knights(5, i, j);
		System.out.println(k);
	    }
	}

	k = new Knights(10, 0, 0);
	System.out.println(k);
    }
		
}
