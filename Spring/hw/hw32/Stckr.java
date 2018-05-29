/*****************************************************
 * class Stckr
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 *****************************************************/

public class Stckr 
{
    public static void main( String[] args )
    {
	Stack<Integer> cakes = new ALStack<Integer>();
	//Stack<Integer> cakes = new LLStack<Integer>();

	//In this loop, you will be pushing all integer between 0-10 in order
	System.out.println("Starting Pushing:");
	for (Integer i = 0; i <= 10; i++) { //for loop
	    cakes.push(i); //push integers between 0-10
	    System.out.println(i);
	}
	
	System.out.println("After Pushing:");
	System.out.println("Is the stack empty?: " + cakes.isEmpty());

	System.out.println("Start Popping");
	//Should print a countdown starting from 10, ending at 0
	while (!cakes.isEmpty()) { //as long as it is not empty
	    System.out.println(cakes.pop()); //Pop!
	}
	
	System.out.println("After Popping:");
	System.out.println("Is the stack empty?: " + cakes.isEmpty());
	
    }//end main

}//end class

