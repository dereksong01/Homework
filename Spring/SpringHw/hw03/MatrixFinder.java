// Team Something - Sean Roudnitsky, Shruthi Venkata, Derek Song
// APCS2 pd8
// HW#03 - I am still searching
// 2018 - 2 - 1

/*
  We would start in the center of the array. First, we would compare the target to the center value. After, we would move down right diagonally if the target is larger than the center value until the target is less than the value we are comparing it to. When we stop at a value that is greater than the target, we would look to the left because now the target is less than the compared value.  
Alternatively, we would move up left diagonally if the target is smaller than the center value until the target is greater than the value we are comparing it to. When we stop at the value that is smaller than the target, we would look to the right because now the target is greater than the compared value.

For the first situation, if the index of the value which we are looking at is equal to array.length and is continuously checking diagonally, then return (-1, -1). Same thing for the second situation, however if the index is 0, then return (-1, -1).
*/

public class MatrixFinder {
  
    public static String finder( int[][] array, int target) {
	int rc = array.length/2;
	boolean up; //if true, target is initially smaller than center element; otherwise, it is smaller
	int row = rc;

	
	if (target > array[rc][rc]) {
	    while (target > array[rc][rc]) { //ultimately, target would be less than array[rc][rc]
		up = false;
		rc++;
		if (rc == array.length) {
		    return "(-1, -1)";
		}
	    }
	    
	    if ((target != array[rc - 1][rc]) && (target != array[rc][rc - 1]))
		return "(-1, -1)";
	    else {
		if (target == array[rc - 1][rc])
		    return "(" + (rc - 1) + "," + rc + ")";
		else {
		    return "(" + rc + "," + (rc - 1) + ")";
		}
	    }
	    /*
	    else {
		while (target < array[rc][rc]) { // looking horizontally
		    rc--;
		    if (rc == 0) // while loop would break if array[rc][rc] == target
			return "(-1, -1)";
		}
	    }
	    */
	}
    

	else if (target < array[rc][rc]) {
	    while (target < array[rc][rc]) { // ultimately target would be greater than array[rc][rc]
		up = true;
		rc--;
		if (rc == 0) { // while loop would break if array[rc][rc] == target
		    return "(-1, -1)";
		}
	    }
	    
	    if ((target != array[rc + 1][rc]) && (target != array[rc][rc + 1]))
		return "(-1, -1)";
	    
	    else {
		if (target == array[rc + 1][rc])
		    return "(" + (rc + 1) + "," + rc + ")";
		else {
		    return "(" + rc + "," + (rc + 1) + ")";
		}
	    }
	    /*
	    while (target > array[rc][rc]) { // looking horizontally
		rc++;
		if (rc == array.length)
		    return "(-1, -1)";
	    }
	    */
	}

	if (target == array[rc][rc])
	    return "(" + rc + ", " + rc + ")";

	return "(" + rc + "," + rc + ")";

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
	System.out.println(finder(arr4, 9)); // Should be 0, 3
    }
}

