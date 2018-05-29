// Derek Song
// APCS1 - pd1
// HW#20 - For the Love of Strings
// 2017-10-19

public class Foresrever {
    //instance vars
      //holds the fence
    String fence = "";
      //holds the reverse for the for loop
    String reversefor = "";
      //holds the reverse for the recursion
    String reverseRec = "";

    
    public String fenceF (int posts) {
	int x;
	for (x = posts; x > 0; x -= 1) {
	    fence += "|--";
	}
	//closes off the fence
	fence += "|";
	return fence;
    }

    public String reverseF (String s) {
	//gives us the length of the string to help us set params
	int x;
	//s.length() -1 because the upcoming line gives the last character
	for (x = s.length() - 1; x > -1; x -= 1) {
	    reversefor += s.substring (x, x + 1);
	}
	return reversefor;
    }

    public String reverseR (String s) {
	if (s.length() > 0) {
	    //sets the variable as the original string
	    //without the last character
	    reverseRec = s.substring (0, s.length() - 1);
	}
	else {
	    return s.substring (0);
		}
	//length gets smaller as we go
	return s.substring (s.length() -1 ) +  reverseR (reverseRec);
    }
    
    public static void main (String [] args) {
	
	Foresrever fences = new Foresrever();
	System.out.println (fences.fenceF(27));

	Foresrever reverseFOR = new Foresrever();
	System.out.println (reverseFOR.reverseF("stressed"));

	Foresrever reverseREC = new Foresrever();
	System.out.println (reverseREC.reverseR("stressed"));
    }		    
}
