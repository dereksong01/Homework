// Derek Song
// APCS2 - pd8
// HW#31 - Stack: What Is It Good For?
// 2018 - 4 - 10

/*****************************************************
 * skeleton for class LatKtS
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/


public class LatKtS
{

    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip( String s )
    {
	String retStr = "";
	for (int x = s.length(); x > 0; x--) {
	    retStr += s.substring(x - 1, x);
	}
	return retStr;
    }//end flip()


    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
    public static boolean allMatched( String s )
    {
	String holder = "";

	if (s.length() == 0)
	    return true;

	if (s.length() == 1)
	    return false;
	
	for (int x = 0; x < s.length(); x++) {

	    if ((x == s.length() - 1) && ((s.substring(x, x + 1).equals("(")) || (s.substring(x, x + 1).equals("{")) ||
					  (s.substring(x, x + 1).equals("[")))) {
		return false;
	    }
	    
	    if ((s.substring(x, x + 1).equals("(")) || (s.substring(x, x + 1).equals("{")) ||
		(s.substring(x, x + 1).equals("["))) {
		holder += s.substring(x, x + 1);
	    }

	    if ((s.substring(x, x + 1).equals(")")) || (s.substring(x, x + 1).equals("}")) ||
		(s.substring(x, x + 1).equals("]"))) {

		if (holder.length() == 0)
		    return false;
		
		if (((s.substring(x, x + 1).equals(")")) && (holder.substring(holder.length() - 1, holder.length()).equals("(")))
		    || ((s.substring(x, x + 1).equals("}")) && (holder.substring(holder.length() - 1, holder.length()).equals("{")))
		    || ((s.substring(x, x + 1).equals("]")) && (holder.substring(holder.length() - 1, holder.length()).equals("[")))) {
		    
		    holder = holder.substring(0, holder.length() - 1);

		}
		
		else
		    return false;
	    }    
	}
	return true;
    }//end allMatched()


    //main method to test
    public static void main( String[] args )
    {
	
	System.out.println(flip("stressed"));
	
	System.out.println(allMatched( "({}[()])" )); //true
	System.out.println(allMatched( "([)]" ) ); //false
	System.out.println(allMatched( "(){([])}" ) ); //true
	System.out.println(allMatched( "](){([])}" ) ); //false
	System.out.println(allMatched( "(){([])}(" ) ); //false
	System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }

}//end class LatKtS
