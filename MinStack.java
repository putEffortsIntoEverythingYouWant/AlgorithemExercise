/*
min stack
Implement a stack with min() function, which will return the smallest number in the stack.

It should support push, pop and min operation all in O(1) cost.

push(1)
pop()   // return 1
push(2)
push(3)
min()   // return 2
push(1)
min()   // return 1
Note
min operation will never be called if there is no number in the stack.

*/
public class MinStack {
    
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    public MinStack() {
        // do initialize if necessary
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if(min.isEmpty()|| min.peek()>=number){
            min.push(number);
        }
    }

    public int pop() {
        // write your code here
        int num = stack.pop();
        if(num==min.peek()){
            min.pop();
        }
        return num;
    }

    public int min() {
        // write your code here
        return min.peek();
    }
}
