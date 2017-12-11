/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 ******************************/

// Derek Song
// APCS1 - pd1
// HW#50 - Dat Bubbly Tho
// 2017 - 12 - 9

import java.util.ArrayList;

public class BubbleSort {

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
	//setup for traversal fr right to left
	for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
	    randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
	    al.set( i, al.set( randomIndex, al.get(i) ) );
	}
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( ArrayList<Comparable> data ) {
	for (int pos = 0; pos < data.size(); pos++) { //for every run, there should be one sorted number. Thus, we have to go until data.size - 1
	    for (int start = 0; start < data.size() - 1; start++) {//goes through whole list
		if ((data.get(start)).compareTo(data.get(start + 1)) > 0) {
		    int temp = (int) data.get(start);
		    data.set(start, data.get(start + 1));
		    data.set((start + 1), temp);
		}
	    }
	}
    }
    


    // ArrayList-returning bubbleSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input ) {
	ArrayList ans = new ArrayList<Comparable>();
	int insert = 0;
	for (int pos = 0; pos < input.size(); pos++) { //for every run, there should be one sorted number. Thus, we have to go until data.size() - 1
	    for (int start = input.size() - 1; start > 0; start--) { // go backwards to append to the new arraylist from left to right. (smallest to largest)
		if ((input.get(start)).compareTo(input.get(start - 1)) < 0) {
		    insert = (int)input.get(start);
		    input.set(start, input.get(start - 1));
		    input.set(start - 1, insert);
		}
	    }
	    ans.add(pos, insert);
	}
	return ans;
    }


    public static void main( String [] args ) {
	

	  ArrayList glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen );
	  bubbleSortV(glen);
	  System.out.println( "ArrayList glen after sorting:\n" + glen );

	  ArrayList coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  bubbleSortV(coco);
	  System.out.println( "ArrayList coco after sorting:\n" + coco );
	  /*===============for VOID methods=============
	  ============================================*/


	  //ArrayList <- took out because produces errors
	  glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen );
	  ArrayList glenSorted = bubbleSort( glen );
	  System.out.println( "sorted version of ArrayList glen:\n" 
	  + glenSorted );
	  System.out.println( "ArrayList glen after sorting:\n" + glen );

	  //ArrayList <- took out because produces errors
	  coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  ArrayList cocoSorted = bubbleSort( coco );
	  System.out.println( "sorted version of ArrayList coco:\n" 
	  + cocoSorted );
	  System.out.println( "ArrayList coco after sorting:\n" + coco );
	  System.out.println( coco ); //<- found this unnecessary
	  	/*==========for AL-returning methods==========
	  ============================================*/

    }//end main

}//end class BubbleSort
