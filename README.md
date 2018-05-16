# Learnenation_Frank-O_Lin-R_Tsui-S

## Choice   

We decided to use the API time complexities for our PriorityQueue because we are sheep and conform to standards. 

The more complex reason is that for add, we can simply use the method provided by List to append to the end instead of rewriting the whole add method to make it adhere to our standards. removeMin() is different from the normal remove() so it would make more sense to rewrite that method instead of rewriting add(). 

## Time Complexities   

add() -> Constant O(1)

isEmpty() -> Constant O(1) 

peekMin() -> Linear O(n)

removeMin() -> Linear O(n)

## Heap To-Do 

0. Write the default constructor for the class
1. Implement our add algorithm 
2. Implement minChildPost
3. Implement our remove algorithm 
4. Implement toString 
5. Test functionality of methods with appropriate test cases in main method 
6. Implement isEmpty() 
7. Implement peekMin() 
8. Wrap it all up with a nice bow 
