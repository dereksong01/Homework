// Larry Wong, John Li, Derek Song -- TEAM kabbage
// APCS2 pd8
// L02 -- All Hands on Deque!
// 2018-04-19

/*****************************************************
* class QQKachoo
* A double linked-list-based, dequq
*
*       -------------------------------
*   end |  --->   Q U E U E   --->    | front
*       -------------------------------
*
*  linkages point in both direction for O(1) en/dequeuing
*    null <- N <-> N <-> ... <-> N <-> N -> null
*      _end -^                         ^- _front
*
******************************************************/
import java.util.*;

public class QQKachoo<T> implements Deque<T>
{
  //instance variables
  private DLLNode<T> _front, _end;
  private int _size;

  // default constructor creates an empty deque
  public QQKachoo()
  {
    _front = _end = null;
    _size = 0;
  } //end constructor


  /*****************************************************
  //means of adding an element to the front of collection:
  // @param addVal: value to be queued to the front
  // O(1): independent of deque size
  *****************************************************/
  public void addFirst( T addVal )
  {
    if (addVal == null) throw new NullPointerException();

    //create new node with the old front as the previous node
    DLLNode<T> tmp = new DLLNode<T>( addVal , _front , null );

    //both pointers point at same node if there is only one node
    if(isEmpty()){
      _end = _front = tmp;
    }
    else
    {
      //moving the _front pointer up
      _front.setNext(tmp);
      _front = tmp;
    }
    _size++;
  } //end addFirst()


  /*****************************************************
  //means of adding an element from back of collection:
  // @param addVal: value to be queued to the end
  // O(1): independent of deque size
  *****************************************************/
  public void addLast( T addVal )
  {
    if (addVal == null) throw new NullPointerException();

    //create new node with the old end as the next node
    DLLNode<T> tmp = new DLLNode<T>( addVal , null , _end );

    //both pointers point at same node if there is only one node
    if(isEmpty()){
      _end = _front = tmp;
    }
    else
    {
      //moving the _end pointer back
      _end.setPrev(tmp);
      _end = tmp;
    }
    _size++;
  } //end addLAst()


  /*****************************************************
  //means of removing an element from front of collection:
  // O(1): no need to traverse through deque
  *****************************************************/
  public T removeFirst()
  {
    //can't remove nothing
    if(isEmpty())
    {
      throw new NoSuchElementException();
    }

    //retain the cargo before moving the pointer
    T retVal = _front.getCargo();

    //Case 1: more than 1 node, move _front pointer back a node and set the next node to null
    if ( _size > 1)
    {
      _front = _front.getPrev();
      _front.setNext(null);
    }
    //Case 2: only 1 node, nothing remains
    if( _size == 1){
      _end = _front = null;
    }

    _size--;
    return retVal;
  } //end removeFirst()


  /*****************************************************
  //means of removing an element from back of collection:
  // O(1): no need to traverse through deque
  *****************************************************/
  public T removeLast()
  {
    //can't remove nothing
    if(isEmpty()){
      throw new NoSuchElementException();
    }

    //retain the cargo before moving the pointer
    T retVal=_end.getCargo();

    //Case 1: more than 1 node, move _end pointer up a node and set the prev node to null
    if ( _size > 1)
    {
      _end = _end.getNext();
      _end.setPrev(null);
    }
    //Case 2: only 1 node, nothing remains
    if( _size == 1){
      _end = _front = null;
    }

    _size--;
    return retVal;
  } //end removeLast()


  /*****************************************************
  //Returns true if this deque is empty, otherwise returns false.
  // O(1): no need to traverse through deque
  *****************************************************/
  public boolean isEmpty()
  {
    return _size == 0;
  } //end isEmpty()

  //Returns the first element of the deque without removing it.
  // O(1): independent of deque size
  public T peekFirst()
  {
    return _front.getCargo();
  } //end peekFirst()

  /*****************************************************
  //Returns the last element of the deque without removing it.
  // O(1): independent of deque size
  *****************************************************/
  public T peekLast()
  {
    return _end.getCargo();
  } //end peekLast()

  /*****************************************************
  // print each node, separated by spaces
  // O(n): needs to traverse through deque
  *****************************************************/
  public String toString()
  {
    String retVal = "END: "; // string to return
    DLLNode<T> temp = _end; // indexer

    if (_size < 1) return null; // return just null if size is less than 1

    // iterate through starting at the end
    while (temp != null){
      retVal += temp.getCargo() + " ";
      temp = temp.getNext();
    }
    return retVal + ":FRONT";
  }//end toString()

  public static void main(String[] args)
  {
    //Check out the driver class (DequeDriver.java) courtesy of StillCold (Fiona Cai, Kevin Feng, Alexia Leong)
  }

}
