// Derek Song
// APCS2 - pd8
// HW#30 -
// 2018 - 4 - 9

/*****************************************************
 * skeleton for class Latkes
 * Implements a stack of Strings using an encapsulated array
 *****************************************************/

public class Latkes
{
    
    private String [] _stack;
    private int _stackSize;

    //constructor
    public Latkes( int size )
    {
	_stackSize = 0;
	_stack = new String[size];
    }

    //means of insertion
    public void push( String s )
    {
	if (! isFull() ) {
	    String[] holder = new String[_stack.length];
	    holder[0] = s;
	    for (int x = 1; x < _stackSize; x++ )
		holder[x] = _stack[x - 1]; // you want to start at the start of the previous array
	    _stackSize++; // housekeeping
	    _stack = holder;
	}
	else {
	    System.out.println ( "You have reached maximum capacity" );
	}
    }

    //means of removal
    public String pop( )
    {
	if (! isEmpty()) {
	    for (int x = 1; x < _stackSize; x++ ) 
		_stack[x - 1] = _stack[1];
	    _stackSize--;
	    return _stack[0];
	}
	else {
	    System.out.println ( "You do not haveth plates to removeth" );
	    return null;
	}
    }

    //chk for emptiness
    public boolean isEmpty()
    {
	return _stackSize == 0;
    }

    //chk for fullness
    public boolean isFull()
    {
	return _stackSize == _stack.length;
    }


    //main method for testing
    public static void main( String[] args )
    {
	Latkes tastyStack = new Latkes(10);

	tastyStack.push("aoo");
	tastyStack.push("boo");
	tastyStack.push("coo");
	tastyStack.push("doo");
	tastyStack.push("eoo");
	tastyStack.push("foo");
	tastyStack.push("goo");
	tastyStack.push("hoo");
	tastyStack.push("ioo");
	tastyStack.push("joo");
	tastyStack.push("coocoo");
	tastyStack.push("cachoo");

	//cachoo
	System.out.println( tastyStack.pop() );
	//coocoo
	System.out.println( tastyStack.pop() );
	//joo
	System.out.println( tastyStack.pop() );
	//ioo
	System.out.println( tastyStack.pop() );
	//hoo
	System.out.println( tastyStack.pop() );
	//goo
	System.out.println( tastyStack.pop() );
	//foo
	System.out.println( tastyStack.pop() );
	//eoo
	System.out.println( tastyStack.pop() );
	//doo
	System.out.println( tastyStack.pop() );
	//coo
	System.out.println( tastyStack.pop() );
	//boo
	System.out.println( tastyStack.pop() );
	//aoo
	System.out.println( tastyStack.pop() );

	//stack empty by now; SOP(null)
	System.out.println( tastyStack.pop() );
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

    }//end main()

}//end class Latkes
