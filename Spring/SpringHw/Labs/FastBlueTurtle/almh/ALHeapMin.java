//FastBlueTurtles, John Liu, Derek Song, Alan Wang, Alvin Ye
//APCS2 pd8
//HW #50: Run Run Run
//2018-05-18

import java.util.ArrayList;

public class ALHeapMin
{

    //instance vars
    private ArrayList<Integer> _heap; 

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeapMin() 
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
    }


    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty()
    {
	return _heap.size()-1==0;
    }

    public int size()
    {
	return _heap.size();
    }

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
    }


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
	    if(_heap.get(i).compareTo(_heap.get(i/2))<0){ //if child is less than parent
	        swap(i,i/2); //swap child and parent
		i/=2;
	    }
	    else{
		return;
	    }
	}
    }


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

	//size 2 heap is the smallest minheap (index 0 is null)
	else if(_heap.size()==2){
	    return _heap.remove(1);
	}
	else{
		//removes the last node and sets it to the root
	    Integer val=_heap.set(1, _heap.remove(_heap.size()-1));

	    //while the root has a lesser child (not a leaf), swap the root with the child
	    //keep going down the heap until you reach a leaf 
	    int i=1;
	    while(minChildPos(i)!=-1){
		int j=minChildPos(i);
		if(_heap.get(i).compareTo(_heap.get(j))>0){
		    swap(i,j);
		    i=j;
		}
		else{
		    return val;
		}
	    }
	    return val;
	}
    }


    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int minChildPos( int pos )
    {

    //if the parent has no child (if the heap size is less than the left child's position (2n))
	if(_heap.size()-1 < 2*pos){
	    return -1;
	}
	//if the parent has a left child but not a right child, return the index of left child
	else if(_heap.size()-1 < 2*pos+1){
	    return 2*pos;
	}
	//if the parent has two children, return the position of the smaller child
	else{
	    if(_heap.get(2*pos).compareTo(_heap.get(2*pos+1))<0){
		return 2*pos;
	    }
	    else{
		return 2*pos+1;
	    }
	}
    }
  

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
	ALHeapMin pile = new ALHeapMin();
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

}//end class ALHeapMin
