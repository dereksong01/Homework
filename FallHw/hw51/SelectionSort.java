/***************************************
 * class SelectionSort -- implements SelectionSort algorithm
 ***************************************/

// Derek Song
// APCS1 - pd1
// HW#51 - Selection
// 2017 - 12 - 12

import java.util.ArrayList;

public class SelectionSort {
    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
	for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
	    randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
	    al.set( i, al.set( randomIndex, al.get(i) ) );
	}
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public static int minimum( ArrayList<Comparable> data, int yes) {
	int index = yes;
	for (int x = 0; x < data.size(); x++) {
	    for (int pos = index; pos < data.size(); pos++) {
		if (data.get(pos).compareTo(data.get(index)) < 0) {
		    index = pos;
		}
	    }
	}
	return index;
    } //returns index of the minimum

    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) {
        for (int pass = 0; pass < data.size(); pass++) { //number of passes must be data.size()-1 in order to guarantee sorted-ness
	    data.set(minimum(data, pass), data.set(pass, data.get(minimum(data, pass))));
	}
    }//end selectionSortV


    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.

    public static ArrayList<Comparable>
	selectionSort( ArrayList<Comparable> input ) {
	ArrayList ans = new ArrayList<Comparable>();
	for (Comparable yes: input) {
	    ans.add(yes);
	}
	selectionSortV(ans);
	return ans;
    }//end selectionSort 

   
    public static void main( String [] args ) 
    {
	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	selectionSortV(glen);
	System.out.println( "ArrayList glen after sorting:\n" + glen );


	  ArrayList coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  selectionSortV(coco);
	  System.out.println( "ArrayList coco after sorting:\n" + coco );
	  /*===============for VOID methods=============
	    ============================================*/

	  //ArrayList
	  glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen );
	  ArrayList glenSorted = selectionSort( glen );
	  System.out.println( "sorted version of ArrayList glen:\n" 
	  + glenSorted );
	  System.out.println( "ArrayList glen after sorting:\n" + glen );

	  //ArrayList
	  coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  ArrayList cocoSorted = selectionSort( coco );
	  System.out.println( "sorted version of ArrayList coco:\n" 
			      + cocoSorted );
	  System.out.println( "ArrayList coco after sorting:\n" + coco );
	  System.out.println( coco );
	  /*==========for AL-returning methods==========

	    ============================================*/

    }//end main

}//end class SelectionSort