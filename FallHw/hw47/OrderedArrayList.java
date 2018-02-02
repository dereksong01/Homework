/********************************
 * class OrderedArrayList
 * wrapper class for ArrayList.
 * Imposes the restriction that stored items 
 * must remain sorted in ascending order
 ********************************/

// Derek Song
// APCS1 - pd1
// HW#47 - Ascending
// 2017 - 12 - 5

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList {
    
    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private static ArrayList<Comparable> _data;


    // default constructor initializes instance variable _data
    public OrderedArrayList() {
	_data = new ArrayList<Comparable>();
    }

    public static void populate() {
	_data.add((int) (Math.random() * 10)); // range 0-9
	for (int pos = 1; pos < 23; pos++) {
	    _data.add(((int) (Math.random() * 10)) + 10);
	}
    }

    public String toString() {
	String ret = "[";
        for (int place = 0; place < _data.size() - 1; place++) {
	    ret += _data.get(place) + ",";
	}
	ret += _data.get(_data.size() - 1) + "]";
	return ret;
    }


    public Comparable remove( int index ) {	
	return _data.remove(index);
    }


    public int size() { 
	return _data.size();
    }

    
    public Comparable get( int index ) { 
        return _data.get(index);
    }


    public void add(Comparable newVal) { 
	_data.add(newVal);
    }

    // main method solely for testing purposes
    public static void main( String[] args ) {
	OrderedArrayList Franz = new OrderedArrayList();

	// testing linear search
	for( int i = 0; i < 15; i++ )
	    Franz.add( (int)( 50 * Math.random() ) );
	System.out.println( Franz );

	//check for sorted-ness
	//if msg does not appear, list was sorted
	for( int i=0; i<Franz.size()-1; i++ ) {
	    System.out.println("at i: " + Franz.get(i) );
	    if ( Franz.get(i).compareTo(Franz.get(i+1)) > 0 ) {
		System.out.println( " *** NOT sorted *** " );
		break;
	    }
	}
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class OrderedArrayList
