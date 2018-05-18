/*****************************************************
 * class ALHeapMax
 * SKELETON
 * Implements a Max heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeapMax
{

    //instance vars
    private ArrayList<Integer> _heap; //array of integers of tree
    int _size;

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeapMax()
    {
	_heap = new ArrayList<Integer>();
    }


    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (more complicated, more fun)
     * Implementation: Traverse through _heap and add it to the return String
     *****************************************************/
    public String toString()
    {
	String retStr = "";     //to be returned
	for (int i: _heap) {    //iterate through each integer
	    retStr += i + " ";  //add it to string
	}
	return retStr;          //return
    } //O(n)


    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     * Implementation: Use the ArrayList method size() to check
     *****************************************************/
    public boolean isEmpty()
    {
	return _heap.size() == 0; //return if size if 0
    }  //O(1)


    /*****************************************************
     * Integer peekMax()
     * Returns max value in heap
     * Postcondition: Heap remains unchanged.
     * Implementation: With _heap storing the level-order transversal, the first element is the highest value
     *****************************************************/
    public Integer peekMax()
    {
	return _heap.get(0);  //return val at 0th
    }  //O(1)


    /*****************************************************
     * add(Integer)
     * Inserts an element in the heap
     * Postcondition: Tree exhibits heap property.
     * 1) Add addVal to the end of _heap
     * 2) While the Max Heap condition is not true, change the place of addVal with its parent
     * 3) Stop once the Max Heap condition is met
     *****************************************************/
    public void add( Integer addVal )
    {
        _heap.add(addVal);                                    //add addVal to the end
	if (_heap.size() == 1) {                              //if it's the only element
	    return;                                           //stop
	}
	int index = _heap.size() - 1;                         //index of addVal
	while(index > 0 && addVal > _heap.get((index-1)/2)) { //while the max heap condition is not met
	    swap(index, (index-1)/2);                         //swap addVal with its parent
	    index = (index-1)/2;                              //get the new index of addVal
	}
  _size++;
    }  //O(logn)


    /*****************************************************
     * removeMax()  ---  means of removing an element from heap
     * Removes and returns most element in heap.
     * Postcondition: Tree maintains heap property.
     * 1) Swap the last element with the first element (lowest)
     * 2) Remove the new last element
     * 3) Swap the new first element with its children when needed
     *****************************************************/
    public Integer removeMax()
    {
	if (isEmpty()) {                  //if empty
	    return null;                  //stop
	}
	if (_heap.size() == 1) {          //if there only 1 element
	    return _heap.remove(0);       //remove
	}

	Integer retVal = peekMax();          //get the val of int to be removed
        swap(_heap.size()-1, 0);          //swap first and last element of _heap
	_heap.remove(_heap.size()-1);     //remove last
	int index = 0;                    //stores index of element to be carried
	int poss = maxChildPos(index); //stores index of child that can swap

	//While there is a child with a higher value than the parent, swap
	while(index*2+1 < _heap.size() && _heap.get(index) < _heap.get(poss)) {
	    swap(index, poss);
	    index = poss;
	    poss = maxChildPos(index);
	}
  _size--;
	return retVal;
    }//O(logn)


    /*****************************************************
     * maxChildPos(int)  ---  helper fxn for removeMax()
     * Returns index of most child, or
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     * 1) Check for out of bounds and find index of the left and right child
     * 2) Check if there's only one child, return that child
     * 3) Check if there's 2 children, return the one with higher value
     * 4) If all fails, return -1
     *****************************************************/
    private int maxChildPos( int pos )
    {
	//pos is not in _heap
	if (pos >= _heap.size()) {                          //check for out of bounds
	    return -1;                                      //return -1
	}
	int left = (pos*2) + 1;                             //left child index
	int right = (pos*2) + 2;                            //right child index

	//only one child
	if (left < _heap.size() && _heap.size() <= right) { //only has a left child
	    return left;                                    //return that left child's index
	}

	//two children
	if (left < _heap.size() && right < _heap.size()) {  //check for 2 children
	    Integer leftVal = _heap.get(left);                    //element at index left
	    Integer rightVal = _heap.get(right);                   //element at index right
	    if (maxOf(leftVal,rightVal) == leftVal) {                          //if left is bigger
		return left;                                //return left index
	    }
	    else {                                          //otherwise
		return right;                               //return right index
	    }
	}

	//no children
	return -1;                                          //if no other conditions apply, return -1
    }//O(1)


    //************ aux helper fxns ***************
    private Integer maxOf( Integer a, Integer b )
    {
	if ( a.compareTo(b) > 0 )
	    return a;
	else
	    return b;
    }

    //swap for an ArrayList
    private void swap( int pos1, int pos2 )
    {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );
    }
    //********************************************



    //main method for testing
    public static void main( String[] args )
    {

	  ALHeapMax pile = new ALHeapMax();

	  pile.add(2);
	  System.out.println(pile);
	  pile.add(4);
	  System.out.println(pile);
	  pile.add(6);
	  System.out.println(pile);
	  pile.add(8);
	  System.out.println(pile);
	  pile.add(10);
	  System.out.println(pile);
	  pile.add(1);
	  System.out.println(pile);
	  pile.add(3);
	  System.out.println(pile);
	  pile.add(5);
	  System.out.println(pile);
	  pile.add(7);
	  System.out.println(pile);
	  pile.add(9);
	  System.out.println(pile);

	  System.out.println(pile.maxChildPos(0));
	  System.out.println(pile.maxChildPos(1));
	  System.out.println(pile.maxChildPos(2));
	  System.out.println(pile.maxChildPos(3));

	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMax() + "...");
	  System.out.println(pile);
	  /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class ALHeapMax
