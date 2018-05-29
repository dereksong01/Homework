// Derek Song
// APCS2 - pd8
// HW#21b - We Got a Little Ol' Convoy
// 2018 - 3 - 19

/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class LLNode
{
    //instance vars
    public String car;
    public String cdr;
    
    // constructor 
    public LLNode(String x, String y) {
	car = x;
	cdr = y;
    }

    //--------------v  ACCESSORS  v--------------
    public String getCargo()
    {
	return car;
    }

    public LLNode getNext()
    {
	return new LLNode(cdr, null);
    }
    
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo(String x)
    {
	String holder = car;
	car = x;
	return holder;
    }

    public LLNode setNext(LLNode y)
    {
	return new LLNode(y.getCargo(), null);
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString()
    {
	String ans = "";
	ans = car + cdr;
	return ans;
    }

   
    //main method for testing
    public static void main( String[] args )
    {
	//PROTIP: try creating a few nodes: traversible, connected...
	//note anything notable as you develop and test...
	LList test = new LList();

	System.out.println(test);

	test.add("hello");
	System.out.println(test);

	test.add("bye");
	System.out.println(test);

	test.add("something");
	System.out.println(test);

	test.add("this will change");
	System.out.println(test);

	test.add("BOOM");
	System.out.println(test);

	test.set(3,"woah, it changed");
	System.out.println(test);

	System.out.println(test.get(3));

	System.out.println(test.size());
    }//end main

}//end class LLNode
