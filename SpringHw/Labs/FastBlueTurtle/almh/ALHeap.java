//John Liu, Derek Song, Alan Wang, Alvin Ye
//APCS2 pd8
//HW #49: Sink || Swim
//2018-05-16
/*****************************************************
 * class ALHeap
 * SKELETON
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeap
{

    //instance vars
    private ArrayList<Integer> _heap; 

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeap() 
    {
	_heap=new ArrayList<Integer>();
	_heap.add(null);
    }



    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either 
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (more complicated, more fun)
     *****************************************************/
    public String toString() 
    {
	String str="[";
	for(int i=1; i<_heap.size(); i++){
	    str+=""+_heap.get(i)+" ";
	}
	str+="]";
	return str;
    }//O(n)


    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty()
    {
	return _heap.size()-1==0;
    }//O(1)


    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMin()
    {
	if(isEmpty()){
	    return null;
	}
	return _heap.get(1);
    }//O(1)


    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree exhibits heap property.
     *****************************************************/
    public void add( Integer addVal )
    {
	_heap.add(addVal);
	int i=_heap.size()-1;
	while(i>1){
	    if(_heap.get(i)<_heap.get(i/2)){ //get(i/2) finds parent index 
	        swap(i,i/2);
		i/=2;
	    }
	    else{
		return;
	    }
	}
    }//O(logn)


    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public Integer removeMin()
    {
	if(isEmpty()){
	    return null;
	}
	else if(_heap.size()==2){
	    return _heap.remove(1);
	}
	else{
	    Integer val=_heap.set(1, _heap.remove(_heap.size()-1));
	    int i=1;
	    while(minChildPos(i)!=-1){
		int j=minChildPos(i);
		if(_heap.get(i)>_heap.get(j)){
		    swap(i,j);
		    i=j;
		}
		else{
		    return val;
		}
	    }
	    return val;
	}
    }//O(?)


    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int minChildPos( int pos )
    {
	if(_heap.size()-1<2*pos){
	    return -1;
	}
	else if(_heap.size()-1<2*pos+1){
	    return 2*pos;
	}
	else{
	    if(minOf(_heap.get(2*pos),_heap.get(2*pos+1))==_heap.get(2*pos)){
		return 2*pos;
	    }
	    else{
		return 2*pos+1;
	    }
	}
    }//O(?)
  

    //************ aux helper fxns ***************
    private Integer minOf( Integer a, Integer b )
    {
	if ( a.compareTo(b) < 0 )
	    return a;
	else
	    return b;
    }

    //swap for an ArrayList
    private void swap( int pos1, int pos2 )
    {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
    }
    //********************************************



    //main method for testing
    public static void main( String[] args )
    {
	  ALHeap pile = new ALHeap();
	  pile.add(2);
	  System.out.println(pile);
	  pile.add(4);
	  System.out.println(pile);
	  pile.add(6);
	  System.out.println(pile);
	  pile.add(8);
	  System.out.println(pile);
	  pile.add(10);
	  System.out.println(pile);
	  pile.add(1);
	  System.out.println(pile);
	  pile.add(3);
	  System.out.println(pile);
	  pile.add(5);
	  System.out.println(pile);
	  pile.add(7);
	  System.out.println(pile);
	  pile.add(9);
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class ALHeap
