//John Liu
//APCS2 pd8
//HW #46: Arrr, There Be Priorities Here Matey
//2018-05-10
import java.util.ArrayList;
public class ArrayPriorityQueue implements PriorityQueue{
    private ArrayList<String> data;
    public ArrayPriorityQueue(){
	data=new ArrayList<String>();
    }
    public void add(String str){
	int i=0;
	while(i<data.size()){
	    if(str.compareTo(data.get(i))>0){
		data.add(i,str);
		return;
	    }
	    i++;
	}
	data.add(str);
    }
    public boolean isEmpty(){
	return data.size()==0;
    }
    public String peekMin(){
	if(isEmpty())
	    return null;
	return data.get(data.size()-1);
    }
    public String removeMin(){
	if(isEmpty())
	    return null;
	String str=peekMin();
	data.remove(data.size()-1);
	return str;
    }
    public static void main(String[] args){
	ArrayPriorityQueue tester=new ArrayPriorityQueue();
	tester.add("loo");
	tester.add("moo");
	tester.add("boo");
	tester.add("roo");
	tester.add("goo");
	tester.add("foo");
	tester.add("coo");
	tester.add("aoo");
	while(!tester.isEmpty()){
	    System.out.println(tester.removeMin());
	}
    }
}
