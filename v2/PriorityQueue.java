//Learnenation_Frank-O_Lin-R_Tsui-S
//APCS2 pd02
//Lab03

public interface PriorityQueue{

  //Adds an element to priority queue.
  public void add(String s);

  //If queue is empty, return true; else return false
  public boolean isEmpty();

  //Returns the smallest element in priority queue without removing it.
  public String peekMin();

  //Removes and returns the smallest element in priority queue.
  public String removeMin();

}
