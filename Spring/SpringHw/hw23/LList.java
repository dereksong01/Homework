// Derek Song
// APCS2 - pd8
// HW#23 - Give and Take
// 2018 - 3 - 23

/*****************************************************
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 *****************************************************/

public class LList implements List { 

    //instance vars
    private LLNode _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList() {
	_head = null; //at birth, a list has no elements
	_size = 0;
    }


    //--------------v  List interface methods  v--------------
    
    public boolean add( String newVal ) {
	LLNode tmp = new LLNode( newVal, _head );
	_head = tmp;
	_size++;
	return true;
    }

    
    public String get( int index ) {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	String retVal;
	LLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//check target node's cargo hold
	retVal = tmp.getCargo();
	return retVal;
    }


    public String set( int index, String newVal ) {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	LLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//store target node's cargo
	String oldVal = tmp.getCargo();

	//modify target node's cargo
	tmp.setCargo( newVal );

	return oldVal;
    }


    //return number of nodes in list
    public int size() {
	return _size;
    }

    // =================== HW23 =====================
    //insert a node containing newVal at position index
    public void add( int index, String newVal) {
	LLNode insert = new LLNode (newVal, null);
	LLNode alias = _head; // using aliases!

	for (int x = 0; x < index - 1; x++)
	    alias = alias.getNext();

	insert.setNext(alias.getNext());
	alias.setNext(insert);
	_size++; // housekeeping
    }

    //remove node at pos index, return its cargo
    public String remove( int index ) {
	LLNode holder = _head;

	for (int x = 0; x < index - 1; x++)
	    holder = holder.getNext();

	String ret = holder.getNext().getCargo();
	holder.setNext(holder.getNext().getNext());
	_size--; //housekeeping
	return ret;
    }

    // ==============================================
    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString() {
	String retStr = "HEAD->";
	LLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args )
    {
	LList james = new LList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );

	james.set( 1, "got" );
	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
	System.out.println( james );

	System.out.println("========================================\n");
	
	LList test = new LList();

	System.out.println( test );
	System.out.println( "size: " + test.size() );

	test.add("functions");
	test.add("new");
	test.add("the");
	test.add("testing");
	test.add("are");
	test.add("we");

	System.out.println( test );
	System.out.println( "size: " + test.size() );
	
	test.remove(4);
	System.out.println( test );
	System.out.println( "size: " + test.size() );

	test.remove(3);
	System.out.println( test );
	System.out.println( "size: " + test.size() );
	
	test.remove(2);
	System.out.println( test );
	System.out.println( "size: " + test.size() );

	test.remove(1);
	System.out.println( test );
	System.out.println( "size: " + test.size() );

	test.add(0, "CoffeeConvertors");
	System.out.println( test );
	System.out.println( "size: " + test.size() );
    }

}//end class LList


