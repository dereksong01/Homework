// Derek Song
// APCS2 - pd8
// HW#21c - Rockin’ Through the Night
// 2018 - 3 - 19

public class LList implements List {

    // instance vars
    public LLNode first;
    public int size;

    public LList() {
	first = null;
	size = 0;
    }

    public boolean add (String x) {
	LLNode holder = first;
	if (first == null) {
	    first = new LLNode(x, null);
	    size++;
	    return true;
	}
	while (holder.getNext() != null) { // getting a null value means we reached the end
	    holder = holder.getNext(); // on to the next!
	}
	holder.setNext(new LLNode(x, null));
	size++;
	return true;
    }

    public String get (int i) {
	LLNode holder = first;
	for (int x = 0; x < i; x++)
	    holder = holder.getNext();
	return holder.getCargo();
    }

    public String set (int i, String x) {
	String prev = get(i);
	LLNode holder = first;
	for (int y = 0; y < i; y++) // was going to use x but realized it was a param
	    holder = holder.getNext();
	holder.setCargo(x);
	return prev;
    }

    public int size() {
	return size;
    }

    public String toString() {
	LLNode holder = first;
	String ans = "";
	for (int x = 0; x < size; x++) {
	    ans += holder.getCargo() + "\t>\t";
	    holder = holder.getNext();
	}
	ans += "null";
	return ans;
    }
}
