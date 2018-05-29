// Derek Song
// APCS2 - pd8
// HW#34 - The English Do Not Wait in Line
// 2018 - 4 - 16

public class NodeQueue<Quasar> implements Queue<Quasar> {

    LLNode<Quasar> node = new LLNode<Quasar>(null, null);
    LLNode<Quasar> holder;
    
    public Quasar dequeue() {
	while (node.getNext() != null) {
	    node.setNext(node.getNext());
	}
	return (Quasar) node.getNext();
    }
    
    public void enqueue(Quasar x) {
	
	holder = new LLNode<Quasar>(node.getValue(), null);
	node.setValue(x);
	node.setNext(holder);
	
	while (node.getNext() != null) {
	    holder.setValue(node.getValue());
	    node.setValue(x);
	    node.setNext(holder);
	}
    }

    public Quasar peekFront() {
	return (Quasar) node.getNext();
    }

    public boolean isEmpty() {
	if (node.getValue() == null)
	    return true;
	return false;
    }

}
