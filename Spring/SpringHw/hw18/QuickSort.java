// Derek Song
// APCS2 - pd8
// HW18 -- So So Quick
// 2018 - 3 - 12
  
/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 *
 * QSort(arr): 
 *    After using partition, we know that the pivot position is at its final resting position. This allows us
 *    to be able to sort the array in a recursive fashion. My QuickSort algo uses its helper method which 
 *    takes the array and the left/right boundaries and separates the array into two. We continue to do so 
 *    until the boundaries do not overlap as in (left < right)
 *
 * 2a. Worst pivot choice and associated runtime: 
 *
 *    The worst pivot choice would be if the highest value would be at the end because due to the fact that
 *    the partition would merely take the array and give back the same array but without that value.
 *    O(n^2)
 *
 * 2b. Best pivot choice and associated runtime:
 *
 *    The best pivot choice would be having the median at the end value because then we can separate the 
 *    array into two halves perfectly. 
 *    Just like mergeSort, it would be O(nlogn)
 *
 * 3. Approach to handling duplicate values in array:
 *    
 *    There is no need of a different approach when handling duplicates because there is no movement of 
 *    these duplicates because during the partition, they would move, potentially together, to a specific 
 *    side.
 *****************************************************/

public class QuickSort
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------

    public static int partition (int[] arr, int left, int right, int pivot) {
	int pivotVal = arr[pivot];
	swap(pivot, right, arr); // I appreciate the method being in the skeleton
	int ret = left;
	
	for (int x = left; x < right; x++) {
	    if (arr[x] <= pivotVal) {
		swap(x, storeVal, arr);
		storeVal++;
	    }
	}
	swap(ret, right, arr);
	
	return ret;
    }//end partition()

    public static void help(int[] arr, int left, int right) {
	if (left < right) {
	    int pivot = partition(arr,left,right,right); 

	    // separate the array into 2!
	    // since we know after partition, the pivot point is at its final position, we can move to the left and right of it
	    help(arr, left, pivot - 1); // left
	    help(arr, pivot + 1, right); // right
	}
    }
    
    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] d )
    { 
	help(d, 0, d.length - 1);
    }

    //you may need a helper method...
    

    //main method for testing
    public static void main( String[] args )
    {
	
	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1 );	
	System.out.println("arr1 after qsort: " );
	printArr(arr1);

	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	    arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

	shuffle(arrN);
	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN );
	System.out.println("arrN after sort: " );
	printArr(arrN);
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 

	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


	
	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
	System.out.println("arr2 after qsort: " );
	printArr(arr2);


	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	    arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

	shuffle(arrMatey);
	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 

	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class QuickSort
