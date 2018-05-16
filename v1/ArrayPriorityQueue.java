/* Simon Tsui
 * APCS2 pd02
 * HW46 -- Arrr, There Be Priorities Here Matey
 * 2018-05-10r
 */
import java.util.ArrayList;
public class ArrayPriorityQueue implements PriorityQueue {
    ArrayList<String> PriorityQueue;

    public ArrayPriorityQueue() {
	PriorityQueue = new ArrayList<String>();
    }

    public void add(String x) {
	PriorityQueue.add( x );
    }

    public boolean isEmpty() {
	return (PriorityQueue.size() == 0);
    }

    public String peekMin() {
	int temp = 0;
	for( int x = 0; x < PriorityQueue.size(); x++) {
	    if (PriorityQueue.get(x).compareTo(PriorityQueue.get(temp)) > 0) {
		temp = x;
	    }
	}
	return PriorityQueue.get(temp);
    }

    public String removeMin() {
	int temp = 0;
	String retVal = "";
	for( int x = 0; x < PriorityQueue.size(); x++) {
	    if (PriorityQueue.get(x).compareTo(PriorityQueue.get(temp)) > 0) {
		temp = x;
	    }
	}
	retVal = PriorityQueue.get(temp);
	PriorityQueue.remove(temp);
	return retVal;
    }

    public String toString() {
	String retVal = "";
	for (String x: PriorityQueue) {
	    retVal += x + " ";
	}
	return retVal;
    }

    public static void main (String[] args) {
	ArrayPriorityQueue x = new ArrayPriorityQueue();
	x.add("foo");
	x.add("moo");
	System.out.println(x);
  x.removeMin();
	System.out.println(x);
	x.add("goo");
	x.add("hoo");
	x.add("doo");
  x.removeMin();
	System.out.println(x);
	System.out.println(x.peekMin());
	System.out.println(x.removeMin());
	System.out.println(x);
    }
}
