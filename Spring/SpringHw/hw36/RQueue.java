// Team Real_Ferry's (Clara Mohri and Derek Song)
// APCS2 - pd8
// HW#36 - Now Let’s Consider You Lot at Fake Terry’s
// 2018 - 4 - 17

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 ******************************************************/

public class RQueue<T> implements Queue<T>
{
    //instance variables
    private LLNode<T> _front, _end;
    private int _size;


    // default constructor creates an empty queue
    public RQueue() 
    {
	_front = null;
	_end = null;
	_size = 0;
    }//end default constructor


    public void enqueue( T enQVal ) 
    {
	LLNode<T> temp = new LLNode<T>(enQVal, null);
	
	if (_size == 0) {
	    _front = temp;
	    _end = temp;
	}
	
	_end.setNext(temp); 
	_end = _end.getNext(); // move pointer
	_size++;
    }//end enqueue()


    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue() 
    {
	T retVal = _front.getValue();
	_front = _front.getNext();
	_size--;
	sample();
	return retVal;
    }//end dequeue()


    public T peekFront() 
    {
	return _front.getValue();
    }


    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * Algo:
     * Take a random number of elements from the front and place them in the back.
     ******************************************/
    public void sample () 
    {
	int loops = (int) (Math.random() * _size);
	
	for (int x = 0; x < loops; x++) {
	    T holder = _front.getValue();
	    _front = _front.getNext();
	    enqueue(holder);
	    _size--; // without this line, we get a NullPointException error
	}
    }//end sample()


    public boolean isEmpty() 
    {
	return _size == 0;
    } //O(?)


    // print each node, separated by spaces
    public String toString() 
    {
	LLNode<T> temp = _front;
	String retStr = "";
	while (temp.getNext() != null) {
	    retStr += (String) temp.getValue() + " ";
	    temp = temp.getNext();
	}
	retStr += null;
	return retStr;
    }//end toString()



    //main method for testing
    public static void main( String[] args )
    {
	
	Queue<String> PirateQueue = new RQueue<String>();

	System.out.println("\nnow enqueuing..."); 
	PirateQueue.enqueue("Dread");
	PirateQueue.enqueue("Pirate");
	PirateQueue.enqueue("Robert");
	PirateQueue.enqueue("Blackbeard");
	PirateQueue.enqueue("Peter");
	PirateQueue.enqueue("Stuyvesant");

	System.out.println("\nnow testing toString()..."); 
	System.out.println( PirateQueue ); //for testing toString()...

	System.out.println("\nnow dequeuing..."); 
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );

	System.out.println("\nnow dequeuing fr empty queue..."); 
	System.out.println( PirateQueue.dequeue() );
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

    }//end main

}//end class RQueue
