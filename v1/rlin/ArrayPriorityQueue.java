//Ricky Lin
//APCS2 pd02
//HW #46: Arrr, There Be Priorities Here Matey . . .
//2018-05-10 R

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue {

  private ArrayList<String> _queue;
  private int _size;

  public ArrayPriorityQueue() {
    _queue = new ArrayList<String>();
    _size = 0;
    //init variables
  }

  public void add( String str ) {
    _queue.add(str);  //use library add to the end
    _size++;  //increment size
  }

  public boolean isEmpty() {
    return _size == 0;
  }

  public String peekMin() {
    if (isEmpty()) {
      return null;  //if empty return null
    }
    String mini = _queue.get(0);  //set minimum to first
    for (String s: _queue) {
      if ( s.compareTo(mini) < 0 )  //if the string is less than the minimum
        mini = s;  //set new minimum
    }
    return mini;
  }

  public String removeMin() {
    if (isEmpty()) {
      return null;  //if empty return null
    }
    String mini = _queue.get(0);  //store first as minimum
    int index = 0;  //keep track of index of mini
    for (int curr = 1; curr < _size; curr++) {  //iterate through ArrayList
      if ( _queue.get(curr).compareTo(mini) < 0 ) {  //if curr element is less than mini
        mini = _queue.get(curr);  //set mini to new string
        index = curr;  //save its index
      }
    }
    _size--;  //decrement size
    data.remove(index);  //remove the string
    return mini;  //return the mini
  }

  public static void main(String[] args) {
    ArrayPriorityQueue bob = new ArrayPriorityQueue();

    System.out.println( bob.isEmpty() ); //expect true
    bob.add("boo");
    bob.add("coo");
    bob.add("aoo");
    bob.add("eoo");
    bob.add("doo");
    System.out.println( bob.isEmpty() ); //expect false

    System.out.println( test.peekMin() );
    System.out.println( test.removeMin() );  //expect aoo

    System.out.println( test.peekMin() );
    System.out.println( test.removeMin() );  //expect boo

    System.out.println( test.peekMin() );
    System.out.println( test.removeMin() );  //expect coo

    System.out.println( test.peekMin() );
    System.out.println( test.removeMin() );  //expect doo

    System.out.println( test.peekMin() );
    System.out.println( test.removeMin() );  //expect eoo

  }
}
