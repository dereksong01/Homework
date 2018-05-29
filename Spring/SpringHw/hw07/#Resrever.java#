/*
  Joshua Weiner, Derek Song - OscarMayerWeinerSong
  APCS2 pd08
  HW07 --  A Man, A Plan, A Canal: Panama!
  2018 - 02 - 13
*/

public class Resrever{

    public static String linReverse(String str) {
	String back = "";
	for (int i = str.length() -1; i > -1; i --) {
	    back += str.substring(i, i + 1);
	}
	return back;
    } //runs in O(n) time, has to go through each character in the String

    public static String logReverse( String str ) {
	//if dataset is 1 element, then dataset is sorted
	if ( str.length() <= 1 )
	    return str;

	//else, halve dataset and recurse on each half
	int leftLen = str.length() / 2;
	String leftHalf = "";
	String rightHalf = "";

	for( int i=0; i<str.length(); i++ ) {
	    if ( i < leftLen )
		leftHalf += str.substring(i, i + 1);
	    else
		rightHalf += str.substring(i, i + 1);
	} //splits strings into halves - like in merge sort. This halving takes logn steps

	return merge(logReverse(rightHalf), logReverse(leftHalf)); //This is the part that is key, why logn is impossible: because the String has to be returned in reverse, which requires the concatenation of all of the characters after they've been sorted
    }//end sort()

    public static String merge(String uno, String dos) {
	return uno + dos;
    }//This is still O(n), however, because a concatenation is an operation that runs in n element time. There is no way, then, to make a sort algorithm for a string that divides the String in log(n) steps, because a concatenation of the string is still necessary. The fastest runtime we could get was the following:

    public static String nReverse(String str) {
	String reversed = "";
	int leftLen = str.length() / 2;
	char[] c = str.toCharArray();
	for (int i = 0; i < leftLen; i ++) {
	    char temp = c[i];
	    c[i] = c[str.length() - (i + 1)];
	    c[str.length() - (i + 1)] = temp;
	} //treats the string as an array of characters, only interates through half of them, giving us a runtime of O(n/2), which is O(n), but slightly faster. This was the fastest time we could accurately conceive.
	reversed = new String(c);
	return reversed;
    }

    public static void main(String[] args) {
	System.out.println(linReverse("Hello, world")); //linear runtime
	System.out.println(logReverse("m     h    t   i  r  a g ol")); //logarithmic runtime
	System.out.println(nReverse("dlorw, eybdooG")); //Linear runtime
    }

}
