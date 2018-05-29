// Derek Song
// APCS2 pd8
// HW#05 - Step 1: Split, Step 2: ?, Step 3: Sorted!
// 2018 - 2 - 6

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
  merge() first checks if a is shorter or b is shorter in terms of elements. Then, it compares the values in the front and adds the smaller value into a new array. The array that the element was added from moves one element down. We do this until we reach the end of the shorter array. Now a_smaller determines whether array a has more elements to put in or if b has more elements. Whichever one needs to, the remaining portion of the array copies itself into the ret array.
  sort() works recursively and if the input array has length == 1, then it immediately returns that array. It starts from a original array and it breaks it down into halves until there is only one element. then, they merge altogether.
  ======================================*/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {
      int[] ret = new int[a.length + b.length];
      int looplimit;
      boolean a_smaller;
      boolean remain = true;
      
      // used to compare values in the two arrays
      int index_a = 0;
      int index_b = 0;
      int add = 0; // gives index at which we are adding the int value in ret
      
      if (a.length > b.length) {
	  a_smaller = false;
      }
      else {
	  if (a.length < b.length) {
	      a_smaller = true;
	  }
	  else { // if both are the same length
	      if (a[a.length - 1] > b[b.length - 1]) // if value at the end of a is bigger, then that value would need to be inserted at the end
		  a_smaller = false;
	      a_smaller = true;
	  }
      }

      while (remain) {

	  if (index_b == b.length - 1|| index_a == a.length - 1) // check
	      remain = false;
	  
	  if (a[index_a] < b[index_b]) {
	      ret[add] = a[index_a];
	      index_a++; // move on to next element
	  }
	  else {
	      ret[add] = b[index_b];
	      index_b++; // move on to next element
	  }
	  
	  add++; // move to next memory allocation for ret
	  
	  
      } // end while loop
      
      if (a_smaller) { // if true then b still has int values to be entered
	  while (index_b < b.length) {
	      ret[add] = b[index_b];
	      index_b++;
	      add++;
	  }
      }
      else { // a still has int values to be entered
	  while (index_a < a.length) {
	      ret[add] = a[index_a];
	      index_a++;
	      add++;
	  }
      }
      
      return ret;
      
  }//end merge()


  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
    public static int[] sort( int[] arr )
    {
	if (arr.length == 1) // like the card demo in class, if only one element exists in the array then return that array 
	    return arr;

	int midpt = (int) arr.length/2; // midpoint!

	int[] half1 = new int[midpt];
	int[] half2 = new int[arr.length - midpt];

	// for loops separate the input array into two arrays
	for (int index = 0; index < midpt; index++)
	    half1[index] = arr[index];

	for (int index = 0; index < half2.length; index++)
	    half2[index] = arr[index + midpt];

	return merge( sort(half1), sort(half2) ); //recursion!
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {


	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {0,9,17,23,42,63,512};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );

	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
	/*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class MergeSort
