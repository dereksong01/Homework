// Derek Song
// APCS2 - pd8
// HW#32 - Leon Leonwood Stack
// 2018 - 4 - 11

import java.util.ArrayList;

public class ALStack<PANCAKE> implements Stack<PANCAKE> {

    public ArrayList<PANCAKE> _stack;

    public ALStack() {
	_stack = new ArrayList<PANCAKE>();
    }

    public boolean isEmpty() {
	return _stack.size() == 0;
    }
    
    public PANCAKE peek() {
	return _stack.get(_stack.size() - 1);
    }

    public PANCAKE pop() {
	return _stack.remove(_stack.size() - 1);
    }

    public void push ( PANCAKE x ) {
	_stack.add(x);
    }

}
