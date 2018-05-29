//Alvin Ye
//APCS2 pd8
//HW46--There be Priorities Here Matey
//2018-05-09

import java.util.ArrayList;

/*======================
In this implementation, the front of the array is the front of the queue and the
back of the array is the back of the queue.
=======================*/


public class ArrayPriorityQueue implements PriorityQueue{

	private ArrayList<String> queue;
	private int size;

	public ArrayPriorityQueue(){
		queue = new ArrayList<String>();
		size = 0;
	}

	//enqueues value to the end of the array (back of queue)
	//O(1) 
	public void add(String x){ 
		queue.add(x);
		size++;
	}

	//O(1)
	public boolean isEmpty(){
		return size == 0;
	}

	//O(1)
	public int size(){
		return size;
	}

	//returns the smallest value in the queue
	//O(n) 
	public String peekMin(){
		String retStr = queue.get(0);

		if(isEmpty()){
			throw new RuntimeException();
		}

		for(String s: queue){
			if(s.compareTo(retStr) < 0){
				retStr = s;
			}
		}
		return retStr;
	}

	//removes the smallest value in the queue and returns the removed value
	//O(n)
	public String removeMin(){
		String retStr = queue.get(0);
		int indexToRemove = 0;

		if(isEmpty()){
			throw new RuntimeException();
		}

		for(int i = 0; i < queue.size(); i++){
			if(queue.get(i).compareTo(retStr) < 0 ){
				retStr = queue.get(i);
				indexToRemove = i;
			}
		}
		queue.remove(indexToRemove);
		size--;
		return retStr;
	}

	//O(n)
	public String toString(){
		String retStr = "[";
		for(String s: queue){
			retStr += (s + ",");
		}
		return retStr.substring(0, retStr.length() - 1) + "]";
	}


	public static void main(String[] args){
		ArrayPriorityQueue q = new ArrayPriorityQueue();

		System.out.println(q.isEmpty());

		q.add("b");
		q.add("a");
		q.add("d");
		q.add("c");
		q.add("z");
		q.add("w");
		q.add("l");

		System.out.println(q);
		System.out.println("size: " + q.size());


		System.out.print("Removing...");
		System.out.println(q.removeMin());
		System.out.println(q);

		System.out.print("Removing...");
		System.out.println(q.removeMin());
		System.out.println(q);

		System.out.print("Removing...");
		System.out.println(q.removeMin());
		System.out.println(q);

		System.out.print("Removing...");
		System.out.println(q.removeMin());
		System.out.println(q);

		System.out.print("Removing...");
		System.out.println(q.removeMin());
		System.out.println(q);		
		System.out.println("size: " + q.size());
	}

}//end class