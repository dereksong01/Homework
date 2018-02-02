/******************************
 * class TwoDimArray
 * (skeleton)
 * practice working with 2D arrays
 ******************************/

// Derek Song
// APCS1 -- pd1
// HW34 -- 2D arrays
// 2017 - 11 - 17

public class TwoDimArray {
    
    //postcond: prints each row of 2D int array a on its own line
    //          uses a FOR loop
    public static void print1( int[][] a )
    {
	for (int row = 0; row < a.length; row++) {//goes through rows
	    for (int col = 0; col < a[row].length; col++) {//goes through columns
		System.out.print (a[row][col]); //prints each column of in the same line 
	    }
	    System.out.println();
	}
    }
   


    //postcond: prints each row of 2D int array a on its own line
    //          uses a FOREACH loop
    public static void print2( int[][] a ) {
	for (int[] row: a) { //accounts for each row
	    for (int col: row) { //accounts for each column
		System.out.print (col);
	    }
	    System.out.println();
	}
    }
   


    //postcond: returns sum of all items in 2D int array a
    public static int sum1( int[][] a )
    {
	int sum = 0;
	for (int row = 0; row < a.length; row++) {
	    for (int col = 0; col < a[row].length; col++) {
		sum += a[row][col]; // adds each column of each row into sum
	    }
	}
	return sum;
    }


    //postcond: returns sum of all items in 2D int array a
    //          * uses helper fxn sumRow
    public static int sum2( int [][] m )
    {
	int ans = 0;
	for (int row = 0; row < m.length; row++) {
	    ans += sumRow (row, m); //sumRow takes in each row of m and gives back the sum of each row. sum2 then adds it to ans
	}
	return ans;
    }


    //postcond: returns sum of all items on row r of 2D int array a
    //          uses a FOR loop
    public static int sumRow( int r, int[][] a )
    {
	int sum = 0;
	for (int x = 0; x < a[r].length; x++) {
	    sum += a[r][x]; // a[r][x] is a section of the row and each section is added to sum
	}
	return sum; //sum of the row
    }


    //postcond: returns sum of all items on row r of 2D int array a
    //          uses a FOREACH loop
    public static int sumRow2(int r, int[][] m)
    {
	int sum = 0;
	for (int col: m[r]) {//for each section in row r in array m
	    sum += col; // add col to sum
	}
	return sum;
    }


    public static void main( String [] args )
    {
	int [][] m1 = new int[4][2];
	int [][] m2 = { {2,4,6}, {3,5,7} };
	int [][] m3 = { {2}, {4,6}, {1,3,5} };
	print1(m1);
	print1(m2);
	print1(m3);
	System.out.println();
	print2(m1);
	print2(m2);
	print2(m3);
	System.out.println();
	System.out.print("testing sum1...\n");
	System.out.println("sum m1 : " + sum1(m1));
	System.out.println("sum m2 : " + sum1(m2));
	System.out.println("sum m3 : " + sum1(m3));
	System.out.println();
	System.out.print("testing sum2...\n");
	System.out.println("sum m1 : " + sum2(m1));
	System.out.println("sum m2 : " + sum2(m2));
	System.out.println("sum m3 : " + sum2(m3));
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class TwoDimArray
