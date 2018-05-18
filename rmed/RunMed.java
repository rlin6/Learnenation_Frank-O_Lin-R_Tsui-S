//Learnenation -- Oliver Frank, Ricky Lin, Simon Tsui
//APCS2 pd02
//HW#50 -- Run Run Run
//2018-05-18 F

import java.util.NoSuchElementException;

/* Implementation:
 * Adding:
 The first element being added is added to MaxHeap.
 Every element that's added after that, check if the value is smaller than root of MaxHeap.
 - If smaller, add to the MaxHeap.
 - If not, add to the MinHeap.
 Check if the difference in size of the 2 Heaps is within 1. If greater than 1, proceed to balance.
 To balance them, remove from bigger Heap and add that to smaller Heap until the 2 Heaps have a size difference within 1.

 * Median:
 Size of both Heaps = 0 -> throw an exception.
 Heaps have different sizes -> return the root of the larger Heap.
 Heaps equal in size -> return the average of the 2 roots.
 */

public class RunMed {

    //instvars
    ALHeapMin bigVals;
    ALHeapMax lilVals;

    //constructor
    public RunMed(){
	bigVals = new ALHeapMin(); //init
	lilVals = new ALHeapMax(); //init
    }

    //methods
    public Integer getMedian(){

	//nothing
	if (lilVals.isEmpty() && bigVals.isEmpty()){ //if both empty
	    throw new NoSuchElementException();      //exception
	}

	//Odd number of elements
	if (bigVals._size > lilVals._size){            //See which Heap is larger
	    return bigVals.peekMin();                //return the root of larger Heap
	}
	else if (lilVals._size > bigVals._size){
	    return lilVals.peekMax();
	}

	//Even number of elements
	else{
	    Integer bigMed = bigVals.peekMin();      //min val of big nums
	    Integer lilMed = lilVals.peekMax();      //max val of lil nums
	    return new Integer ((bigMed.intValue() + lilMed.intValue()) / 2);
	}
    }//O(1)

    public void add(Integer newVal){
	if (lilVals.isEmpty()){                     //If first element
	    lilVals.add(newVal);                    //Add it to 0th index
	}

	else if (newVal > lilVals.peekMax()){       //Compare newVal with root of MaxHeap
	    bigVals.add(newVal);                    //If newVal is larger
	}                                           //add to the MinHeap
	else {
	    lilVals.add(newVal);                    //else, add to MaxHeap
	}

	int diff = lilVals._size - bigVals._size;  //size difference
	while (diff > 1 || diff < -1){       //if not within 1
	    if(diff > 1 ){                      //remove from larger, add to smaller
		bigVals.add(lilVals.removeMax());
	    }
	    else{
		lilVals.add(bigVals.removeMin());
	    }
	    diff = lilVals._size - bigVals._size;
	}
    }//O(logn)

}
