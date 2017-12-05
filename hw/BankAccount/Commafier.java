// Derek Song
// APCS1 - pd1
// HW#21 - Karmacomma
// 2017-10-23

public class Commafier {
    public static String commafyR (int x) {
	String add = "" + (x % 1000);
	if (x < 1000) {
	    return "" + x;
	    // there are no commas in numbers below 1000
	}
	if (add.equals("0")) { // not "000" because mod gives remainder
	    add = "000";
	}
	return commafyR (x / 1000) + "," + add;
	//does the function again with three less places
    }
    
    public static String commafyF (int x) {
	String intstr = "" + x;
	String last = intstr.substring(intstr.length() - 3); // str = last 3 digits
	String result = last; // the last three digits are put into result
	if (x < 1000) {
	    return "" + x;
	    // there are no commas in numbers below 1000
	}
	for (int i = intstr.length() - 4; i > -1; i = i-3){
	    if (i < 3) { // to get the very first few numbers and making sure no error pops up
		result  = intstr.substring(0, i+1) + "," + result;
	    }
	    else { // will get the next 3 digits necessary and put in commas
		result = intstr.substring(i-2, i+1) + "," + result;
	    }
	}
	return result;
    }
    public static void main (String [] args) {
	
	/*System.out.println("===================Recursive Tests=====================");
	  System.out.println(commafyR(100)); // 100
	  System.out.println(commafyR(1000)); // 1,000

	  System.out.println("===================For Tests=====================");
	  System.out.println(commafyF(100)); // 100
	  System.out.println(commafyF(1000)); // 1,000*/

	//FOREACH
	for (String str: args){
	    /* I don't know why but when I put 1 it gives me an out of
	       bounds error. Is that supposed to happen? */
	    System.out.println(commafyR(Integer.parseInt(str)));
	    System.out.println(commafyF(Integer.parseInt(str)));
	}
	
    }
}
