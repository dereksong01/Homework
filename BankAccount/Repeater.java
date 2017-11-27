// Derek Song
// APCS1 - pd1
// HW#17 - Do I Repeat Myself?
// 2017-10-17

public class Repeater {
    int posts = 0;
    String original = "|--";

    /*//creates the function to add the fence
    public void addFence () {
        original += "--|";
    }
    */
    //accesors
    public String getoriginal () {
	return original;
    }

    public int getposts () {
	return posts;
    }
    
    //while loop
    public String FenceW (int NumPosts) {
	while (NumPosts > posts) {
	    // addFence ();
	    original += "|--";
	    posts += 1;
	}
	return original + "|";
    }

    public String FenceR (int NumPosts) {
	if (NumPosts == 1) {
	    return original + "|";
		}
	else {
	    return original += FenceR (NumPosts - 1);
	}
    }

    public static void main (String [] args) {
	//Tests while loop function
	Repeater whilee = new Repeater();
	System.out.println (whilee.FenceW (27));

	//Tests the recursive
	int posts = 0;
	String original = "|--";
	
	Repeater recursive = new Repeater();
	System.out.println (recursive.FenceR(27));
    }
}
	
