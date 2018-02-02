// Derek Song
// APCS1 pd 1
// HW #6 - On BigSib Individuality and the Elimination of Radio Fuzz
// 9-27-17

public class BigSib2 {
    private String helloMsg;
    public void setHelloMsg (String newMsg) {
	helloMsg = newMsg ;
    } // end setHelloMsg ()
    public String greet (String after) {
	String ans = helloMsg + after;
	return ans;
    } // end greet ()
} // end BigSib2
