// Team Something - Sean Roudnitsky, Derek Song, Shruthi Venkata
// APCS2 pd8
// HW#05 - But What Does the Data Say?
// 2018-02-07

public class MatrixFinder {

    public static void populate(int[][] arr) {
	arr[0][0] = (int) Math.random() * 10; // populates top right corner
	
	for (int colindex = 1; colindex < arr.length; colindex++) // populates first row
	    arr[0][colindex] = arr[0][colindex - 1] + (int) Math.random() * 10;

	for (int rowindex = 1; rowindex < arr[0].length; rowindex++) // populates first column
	    arr[rowindex][0] = arr[rowindex - 1][0] + (int) Math.random() * 10;
	
	for (int row = 1; row < arr.length; row++) { // populates everything else
	    for (int col = 1; col < arr[0].length; col++) {
		arr[row][col] = arr[row - 1][col] + arr[row][col -1] + (int) Math.random() * 10;
	    }
	}
    }
    
    public static String finder( int[][] array, int target) {
	int row = array.length-1;
	int col = 0;
	while (col < array[0].length && row >= 0) {
	    if (target == array[row][col])
		return "(" + row + ", " + col + ")";
	    else if (target < array[row][col]) 
		row-=1;
	    else
		col+=1;
	}
	return "(-1, -1)";
    }
    
    public static void printArray( int[][] a ) {
	//System.out.print("[");
	for( int i[] : a )
	    for (int x : i )
		System.out.print(x);
	//stem.out.println("]");
    }
    
    public static void main ( String[] args ) {
	
	int[][] arr1 =
	    {
		{1, 2, 3, 4},
		{2, 3, 4, 5},
		{3, 4, 5, 6},
		{7, 8, 9, 10}
	    };
	
	System.out.println(finder(arr1, 9)); // Should be 3,2
	
	int[][] arr2 =
	    {
		{1, 3, 5},
		{3, 7, 8},
		{5, 12, 15}
	    };
	
	System.out.println(finder(arr2, 12)); // Should be 2,1
	
	int[][] arr3 =
	    {
		{1, 2, 6},
		{2, 3, 7},
		{3, 4, 8}
	    };
	
	System.out.println(finder(arr3, 999)); // Should be -1,-1
	
	int[][] arr4 =
	    {
		{3,4,7,12,21},
		{4,6,12,40,53},
		{9,10,21,41,64},
		{12,14,34,42,80},
		{17,20,35,43,90}
	    };
	
	System.out.println(finder(arr4, 4)); // Should be 1, 0
	System.out.println(finder(arr4, 9)); // Should be 2, 0

	int[][] arr5 = new int[1000][1000];
	populate(arr5);
	printArray(arr5);
    }
}
