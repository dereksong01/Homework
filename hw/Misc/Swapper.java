// Derek Song
// APCS1 - pd1
// HW#40 - Make It Better
// 2017 - 11 - 26

/*
  What basically happens is that calling on the default constructor populates the array which fills with random characters from the string chars. each allocation of memory is either a 3 or 4 character string which is decided by Math.random. When swapping the strings, there would be a holde r because the value would change. Then, each change would occur and then they would be implemented. Printing takes each array of strings, prints each string, and puts a space inbetween each of the strings.
    */
/*
In version 2, all I did was take out bits and pieces of code that I regarded as unnecesary.
 */
import cs1.Keyboard;
import java.lang.Math;

public class Swapper {

    private String chars = "abcdefghijklmnopgrstuvwxyz"; // contains all possible values
    private String[][] ans;

    public Swapper() {
	ans = populate(); // populates the array
    }

    public String[][] populate(){
	String[][] ans2 = new String[4][4]; //initializes the 4 by 4 array
	for (int row = 0; row < ans2.length; row++) {
	    for (int col = 0; col < ans2[0].length; col++) {
		ans2[row][col] = populate2();
	    }
	}
	return ans2;
    }

    public String populate2() {
	if (Math.random() > 0.5) { //decides if string is 3 or 4 characters long
	    //four characters
	    int firstc = (int) (Math.random() * chars.length()); // all finds the position of the character in the default inst var chars
	    int secondc = (int) (Math.random() * chars.length());
	    int thirdc =  (int) (Math.random() * chars.length());
	    int fourthc =  (int) (Math.random() * chars.length());
	    // the "return" puts each string into the array 
	    return chars.substring(firstc, firstc + 1) + chars.substring(secondc, secondc + 1) + chars.substring(thirdc, thirdc + 1) + chars.substring(fourthc, fourthc + 1);
	}
	else {
	    //same functionality as the if statement but only three characters in the string
	    int firstc = (int) (Math.random() * chars.length());
	    int secondc = (int) (Math.random() * chars.length());
	    int thirdc =  (int) (Math.random() * chars.length());
	    return chars.substring(firstc, firstc + 1) + chars.substring(secondc, secondc + 1) + chars.substring(thirdc, thirdc + 1); 
	}
    }

    public void swap(int col1, int row1, int col2, int row2) {
        String holder = ans[row1][col1];
        ans[row1][col1] = ans[row2][col2];
        ans[row2][col2] = holder;
    }

    public void print() {
        for (String[] x : ans) { // for array of strings
            for (String y : x) { // each string
                System.out.print(y + " "); // print
            }
            System.out.println(); // separates each row
        }
    }
    
    public static void main(String [] args) {
	int row1, row2, col1, col2;
	Swapper test = new Swapper();
	
	test.print();
	System.out.println();
	
	System.out.println("Changing...");

	System.out.print("\nRow1: ");
	row1 = Keyboard.readInt();
	System.out.print("Col1: ");
	col1 = Keyboard.readInt();
	System.out.print("Row2: ");
	row2 = Keyboard.readInt();
	System.out.print("Col2: ");
	col2 = Keyboard.readInt();

	test.swap(col1, row1, col2, row2);
	System.out.print("\nAfter change... \n");
	test.print();

    }
}
