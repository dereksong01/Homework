/*****************************************************
 * interface Deque
 * Includes only methods we deemed necessary from Java 8 API
 * (Local version, to override built-in Java implementation.)
 ******************************************************/

public interface Deque<T>{

  //means of adding an element to the front of collection:
  public void addFirst( T x );

  //means of adding an element to the back of collection:
  public void addLast( T x );

  //means of removing an element from front of collection:
  public T removeFirst();

  //means of removing an element from back of collection:
  public T removeLast();

  //Returns true if this deque is empty, otherwise returns false.
  public boolean isEmpty();

  //Returns the first element of the deque without removing it.
  public T peekFirst();

  //Returns the last element of the deque without removing it.
  public T peekLast();


}
