/********************************
 * class OrderedArrayList
 * wrapper class for ArrayList.
 * Imposes the restriction that stored items 
 * must remain sorted in ascending order
 ********************************/

// Derek Song
// APCS1 - pd1
// HW#49 - Halving the Halves
// 2017 - 12 - 7

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList {
    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;


    // default constructor initializes instance variable _data
    public OrderedArrayList() {
	_data = new ArrayList<Comparable>();    
    }

    
    public String toString() {
	return _data.toString(); 
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


    /***
     * add takes as input any comparable object 
     * (i.e., any object of a class implementing interface Comparable)
     * inserts newVal at the appropriate index
     * maintains ascending order of elements
     * uses a linear search to find appropriate index
     ***/
    
    /*
     In add(), the method would look from left to right and it would go linearly throughout the whole set. add() is of the order of n and this shows that in the worst case scenario with an arraylist of n elements, there would be n passes.
     */
    public void add( Comparable newVal ) { 
	for( int p = 0; p < _data.size(); p++ ) {
	    if ( newVal.compareTo( _data.get(p) ) < 0 ) { 
		//newVal < oal[p]
		_data.add( p, newVal );
		return; //Q:why not break?
	    }
	}
	_data.add( newVal ); //newVal > every item in oal, so add to end 
    }

    /*
      In addBin(), the method would continue halving and would thus, conduct binary search. addBin(0 is of the order of logn and this shows that in the worst case scenario with an arraylist of n elements, there would be logn passes
     */
    // Same outward functionality as add() but binary search
    public void addBin ( Comparable newVal) {
	int _start = 0;
	int _upper = _data.get(size() - 1);
	int _middle = (int) ((_start + _upper) / 2);
	while (_start <= _upper) {
	    _middle = (int) ((_start + _upper) / 2);
	    if (get(_middle).compareTo(newVal) == 0)) {
	    _start = _middle;
	    break;
	}
	else {
	    if (get(_middle).compareTo(newVal) <  0) {
	        _start = _middle + 1;
	    }
	    else {
		_upper = _middle + 1;
	    }
	    _data.add(_start, newVal);
	}
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
