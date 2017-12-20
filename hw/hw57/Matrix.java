/***
 * class Matrix -- models a square matrix
 *
 * BACKGROUND:
 * A matrix is a rectangular array.
 * Its dimensions are numRows x numColumns.
 * Each element is indexed as (row,column): 
 *  eg,
 *   for 2 x 3 matrix M:
 *        -       -
 *   M =  | a b c |
 *        | d e f |
 *        -       -
 *   ... d is at position (2,1) or M[2,1] 
 *
 * TASK:
 * Implement methods below, categorize runtime of each. 
 * Test in main method.
 ***/

// Derek Song
// APCS1 - pd1
// HW#57 - How Deep Does the Rabbit Hole Go?
// 2017 - 12 - 19

public class Matrix {
    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;

    private Object[][] matrix;

    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix() {
	matrix = new Object [DEFAULT_SIZE][DEFAULT_SIZE];
    }


    //constructor intializes an a*a matrix
    public Matrix( int a ) {
	matrix = new Object [a][a];
    }


    //return size of this matrix, where size is 1 dimension
    private int size() {
	return matrix.length;
    }


    //return the item at the specified row & column   
    private Object get( int r, int c ) {
	return matrix[r - 1][c - 1]; // index starts at 0!
    }


    //return true if this matrix is empty, false otherwise
    private boolean isEmpty() {
	for (int row = 0; row < matrix.length; row++) {
	    for (int column = 0; column < matrix[row].length; column++) {
		if (matrix[row][column] == null) {
		    return false;
		}
	    }
	}
	return true;
    }


    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) {
	Object prev = matrix[r - 1][c - 1];
	matrix[r - 1][c - 1] = newVal;
	return prev;
    }


    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() {
	String matrixx = "M =";
	for (int row = 0; row < matrix.length; row++) {
	    matrixx += "\n| ";
	    for (int column = 0; column < matrix[row].length; column++) {
		matrixx += " " + matrix[row];
	    }
	    matrixx += " |";
	}
	return matrixx;
    }


    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Object rightSide ) {
	if (this.size() != ((Matrix) rightSide).size()) {
	    return false;
	}
	Matrix x = (Matrix) rightSide;
	for (int row = 1; row <= size(); row++) { 
	    for (int col = 1; col <= size(); col++) {
		if (! (this.get(row, col).equals(right.get(row, col)) ) ) {
		    return false;
		}
	    }
	}
	return true; // returns true if it did not trigger anything that would make it return false
    }


    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) {
	Object[] holder = new Object[size()];
	int x = 0;
	for (int row = 0; row < matrix.length; row ++) {
	    holder[x] = matrix[c1 - 1];
	    x++;
	}
	for (int y = 0; y < size(); y++) {
	    matrix[y][c1 - 1] = matrix[i][c2 - 1];
	}
	for (int z = 0; z < size(); z++) {
	    matrix[z][c2 - 1] = temp[z];
	}
    }


    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) {
	Object[] holdaa = matrix[r1 - 1]; 
	matrix[r1 - 1] = matrix[r2 - 1];
	matrix[r2 - 1] = holdaa;
    }


    //main method for testing
    public static void main( String[] args ) {
	//Object test = new Matrix();
	//System.out.println("Is the matrix empty?: " + test.isEmpty());

	Object test = new Matrix(3);
	System.out.println("=======CREATE 3X3 MATRIX=======");
	test.set(1,1, 1);
	test.set(1,2, 2);
	test.set(1,3, 3);
	test.set(2,1, 4);
	test.set(2,2, 5);
	test.set(2,3, 6);
	test.set(3,1, 7);
	test.set(3,2, 8);
	test.set(3,3, 9);
	System.out.println(test);
	System.out.println("Is the matrix empty?: " + test.isEmpty());
	test.swapColumns(1,2);
	System.out.println("test after column swap: \n" + test);
	test.swapRows(1,2);
	System.out.println("test after row swap: \n" + test);
    }

}//end class Matrix
