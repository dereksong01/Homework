// Team Brown_Bear (John Liu and Derek Song)
// APCS2 - pd8
// HW#35 -
// 2018 - 4 - 16

import java.util.ArrayList;

public class ALQueue<Quasar> implements Queue<Quasar> {

    private ArrayList<Quasar> queue;

    public ALQueue() {
	queue = new ArrayList<Quasar>();
    }

    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    public Quasar dequeue() {
	Quasar retVal = null;
	
	if (isEmpty())
	    return null;

	retVal = queue.remove(0);
	return retVal;
    }

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue( Quasar x ) {
	queue.add(x);
    }

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty() {
	return queue.size() == 0;
    }

    //Returns the first element of the queue without dequeuing it.
    public Quasar peekFront() {
	return queue.get(0);
    }
    
}
