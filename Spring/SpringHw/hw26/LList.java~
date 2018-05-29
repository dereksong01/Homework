// Derek Song
// APCS2 - pd8
// HW#24b - On the DLL
// 2018 - 3 - 24

/*****************************************************
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 *****************************************************/

public class LList implements List { 

    //instance vars
    private DLLNode _head;
    private DLLNode _tail;
    private int _size;
    private int _holder;

    // constructor -- initializes instance vars
    public LList() {
	_head = null; //at birth, a list has no elements
	_tail = null;
	_size = 0;
	_holder = _size;
    }


    //--------------v  List interface methods  v--------------
    
    public boolean add( String newVal ) {
	DLLNode tmp = new DLLNode(newVal, null, _tail);
	if (_tail != null) {
	    _tail.setNext(newNode);
	    _tail = tmp;
	    _size++;
	    return true;
	}
	_tail = tmp;
	_head = tmp;
	_size++;
	return true;
    }

    
    public String get( int index ) {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	String retVal;
	DLLNode tmp = _head; //create alias to head

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

	DLLNode tmp = _head; //create alias to head

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
    public void add( int index, String newVal ) {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	DLLNode newNode = new DLLNode( newVal, null );
	if (index == 0 ) {
	    newNode.setNext(_head);
	    _head.setPrev(newNode);
	    _head = newNOde;
	    return;
	}
	
	//if index==size, insert node before head node
	if ( index == size() )  
	    add( newVal );

	if (index < size()/2) {
	    
	    DLLNode tmp = _head;
	    
	    for (int i = 0; i < index-1; i++) 
		temp = temp.getNext();
	    
	    newNode.setNext(temp.getNext()); 
	    temp.setNext(newNode);
	    temp.getNext().setPrev(newNode);
	    newNode.setPrev(temp);
	    _size++;
	}
	
	else {
	    DLLNode tmp = _head; //create alias to head

	    //walk to node before desired node
	    for( int i=0; i < size() - index - 1; i++ )
		tmp = tmp.getPrev();

	    //insert new node
	    newNode.setPrev( tmp.getPrev() );
	    tmp.setPrev(newNode);
	    tmp.getPrev().getPrev.setNext(newNode);
	    newNode.setNext( tmp );

	    //increment size attribute
	    _size++;
	}
    }


    //remove node at pos index, return its cargo
    public String remove( int index ) {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	String retVal;
	DLLNode tmp = _head; //create alias to head

	//if index==0, remove head node
	if ( index == 0 ) {
	    //check target node's cargo hold
	    retVal = _head.getCargo();

	    //remove target node
	    _head = _head.getNext();	    
	}
	else {
	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ )
		tmp = tmp.getNext();

	    //check target node's cargo hold
	    retVal = tmp.getNext().getCargo();

	    //remove target node
	    tmp.setNext( tmp.getNext().getNext() );
	}

	//decrement size attribute
	_size--;

	return retVal;
    }


    // ==============================================
    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString() {
	String retStr = "HEAD->";
	DLLNode tmp = _head; //init tr
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


