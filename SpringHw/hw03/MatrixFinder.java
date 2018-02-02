public class MatrixFinder
{
  
  public String finder( int[][] array, int target) {
	  int rc = array.length/2;
	  boolean up; //if true, target is initially smaller than center element; otherwise, it is smaller
	  
	  if (target > array[rc][rc]) {
		  while (target > x) {
			up = false;
			rc++;
			if (rc == array.length) {
				return "(-1, -1)";
			}
		  }
	  }
	  
	  else if (target > array[rc][rc]) {
		while (target > x) {
			up = true;
			rc--;
			if (rc == array.length) {
				return "(-1, -1)";
			}
		  }
	  }
	  
	  if (target == array[rc][rc])
		  return "(" + rc + ", " + rc + ")";
	  
	  
	  /* public static void main ( String[][] args ) {
		System.out.println(finder());
	  
	  } */
  }