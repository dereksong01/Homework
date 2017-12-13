// Derek Song
// APCS1 - pd1
// HW#53 -
// 2017 - 12 - 13

public class MySorts {

    
    
    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) 
    {
	//note: this version places greatest value at rightmost end,

	//maxPos will point to position of SELECTION (greatest value)
	int maxPos;

	for( int pass = data.size()-1; pass > 0; pass-- ) {
	    System.out.println( "\nbegin pass " + (data.size()-pass) );//diag
	    maxPos = 0;
	    for( int i = 1; i <= pass; i++ ) {
		System.out.println( "maxPos: " + maxPos );//diag
		System.out.println( data );//diag
		if ( data.get(i).compareTo( data.get(maxPos) ) > 0 )
		    maxPos = i;
	    }
	    data.set( maxPos, ( data.set( pass, data.get(maxPos) ) ) );
	    System.out.println( "after swap: " +  data );//diag
	}
    }//end selectionSortV


    
    // VOID version of InsertionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void insertionSortV( ArrayList<Comparable> data ) {
	for (int pass = 1; pass < data.size(); pass++) { //none are sorted until n-1 passes
	    for (int x = 0; x < data.size(); x++) { //needs to do multiple times when the distance is greater than one. In order to guarantee, do it n-1 times.
		for (int start = 0; start < pass; start++) { //traverse
		    if ((data.get(start)).compareTo(data.get(start + 1)) > 0) {
			Comparable holder = data.get(start);
			data.set(start, data.get(start + 1));
			data.set(start + 1, holder);
		    }
		}
	    }
	    System.out.println("Pass " + pass + ":" + data);
	}
    }//end insertionSortV

}
