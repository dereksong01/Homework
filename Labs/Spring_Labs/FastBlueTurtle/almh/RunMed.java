//FastBlueTurtles, John Liu, Derek Song, Alan Wang, Alvin Ye
//APCS2 pd8
//HW #50: Run Run Run
//2018-05-18

import java.util.NoSuchElementException;
public class RunMed{
    private ALHeapMax lilVals;
    private ALHeapMin bigVals;

    public RunMed(){
	lilVals=new ALHeapMax();
	bigVals=new ALHeapMin();
    }

    public Integer getMedian(){

    //if the min/max heaps are the same size, return mean of the roots
	if(lilVals.size()==bigVals.size()){ 
	    return (lilVals.peekMax()+bigVals.peekMin())/2;
	}
	//otherwise, return the root of the bigger heap  
	if(lilVals.size()>bigVals.size()){
	    if(lilVals.isEmpty()){
		throw new NoSuchElementException();
	    }
	    else{
		return lilVals.peekMax();
	    }
	}
	else{
	    if(bigVals.isEmpty()){
		throw new NoSuchElementException();
	    }
	    else{
		return bigVals.peekMin();
	    }
	}
    }


    public void add(Integer newVal){
	if(lilVals.isEmpty()){
	    lilVals.add(newVal);
	}

	//to make sure that the roots of the heaps are the median:
	//if newVal is greater than the max heap root, add a value to the max heap
	//if newVal is less than the max heap root, add a value to the min heap
	else{
	    if(lilVals.peekMax().compareTo(newVal)>0){
		lilVals.add(newVal);
	    }
	    else{
		bigVals.add(newVal);
	    }
	}

	//if the size difference between the heaps are greater than 1:
	//remove and add the max or min value from the smaller heap to the larger heap
	while(Math.abs(lilVals.size()-bigVals.size())>1){
	    if(lilVals.size()>bigVals.size()){
		bigVals.add(lilVals.removeMax());
	    }
	    else{
		lilVals.add(bigVals.removeMin());
	    }
	}
    }
}
