// Derek Song
// APCS2 - pd8
// HW#33 - What a Racket
// 2018 - 4 - 12

/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 * 
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Steal underpants.
 *   2. ...
 *   5. Profit!
 *
 * STACK OF CHOICE: ____ by ____
 * b/c ...
 ******************************************************/

public class Scheme
{
    ArrayList store = new ArrayList();
    
    /****************************************************** 
     * precond:  Assumes expr is a valid Scheme (prefix) expression,
     *           with whitespace separating all operators, parens, and 
     *           integer operands.
     * postcond: Returns the simplified value of the expression, as a String
     * eg,
     *           evaluate( "( + 4 3 )" ) -> 7
     *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
     ******************************************************/
    public static String evaluate( String expr ) 
    {
	String[] splitted = expr.split("\\s+"); //split!
	Stack<String> _stack = new ALStack<String>(); //make a stack
	String current; //will represent the String we are currently examining
	for (int i = splitted.length - 1; i > -1; i--) { //for loop going through splitted
	    current = splitted[i]; //the string we are examining
	    if (current.equals("(")) { //if it is the start of an operation
		String op = _stack.pop(); //get the operation
		if (op.equals("+")) { 
		    _stack.push(unload(1,_stack)); //"replace" the expression with a sngle string
		}
		else if (op.equals("-")) {
		    _stack.push(unload(2,_stack));
		}
		if (op.equals("*")) {
		    _stack.push(unload(3,_stack));
		}
	    }
	    else { //all other necessary elements go into stack. This is so unload has access to the numbers and when to end with ")"
		_stack.push(current);
	    }
	}
	return _stack.pop(); //get the last computation unload made
	}
    }//end evaluate()


    /****************************************************** 
     * precond:  Assumes top of input stack is a number.
     * postcond: Performs op on nums until closing paren is seen thru peek().
     *           Returns the result of operating on sequence of operands.
     *           Ops: + is 1, - is 2, * is 3
     ******************************************************/
    public static String unload( int op, Stack<String> numbers ) 
    {
	int first = Integer.parseInt(numbers.pop()); //we must get a "base" 
	int current; //will represent the current string
	while (!(numbers.peek().equals(")"))) { //go until we have reached the end of the operation
	    current = Integer.parseInt(numbers.pop()); //get current value. It's important to pop so we get rid of the expression
	    if (op == 1) { 
		first += current; //
	    }
	    if (op == 2) {
		first -= current;
	    }
	    if (op == 3) {
		first *= current;
	    }
	}
	numbers.pop(); //eliminate ")" so the expression is gone
	return "" + first; //return as datatype string
    }//end unload()


    /*
    //optional check-to-see-if-its-a-number helper fxn:
    public static boolean isNumber( String s ) {
    try {
    Integer.parseInt(s);
    return true;
    }
    catch( NumberFormatException e ) {
    return false;
    }
    }
    */


    //main method for testing
    public static void main( String[] args )
    {

	  String zoo1 = "( + 4 3 )";
	  System.out.println(zoo1);
	  System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
	  //...7

	  String zoo2 = "( + 4 ( * 2 5 ) 3 )";
	  System.out.println(zoo2);
	  System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
	  //...17

	  String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
	  System.out.println(zoo3);
	  System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
	  //...29

	  String zoo4 = "( - 1 2 3 )";
	  System.out.println(zoo4);
	  System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
	  //...-4
	  	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }//main

}//end class Scheme
