/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/
class MinStack {
    //when compare Integer with Integer, remember to use .intValue() == or equals, because integer == integer only works from -128 to 127. JVM caches small interger numbers so that -128 - 127 reference point to the same. numbers out of this range == will fail because reference points to diff objects even though the int value is the same
    Stack <Integer> elements = new Stack<Integer>();
    Stack <Integer> mins = new Stack<Integer>();
    public void push(int x) {
        elements.push(x);
        if(mins.empty() || mins.peek().intValue()>=x){
            mins.push(x);
        }
    }

    public void pop() {
        if(!mins.empty() && mins.peek().intValue() == elements.peek().intValue()){
            mins.pop();
        }
        elements.pop();
    }

    public int top() {
        if(!elements.empty()){
            return elements.peek();
        }
        return Integer.MIN_VALUE;
    }

    public int getMin() {
        if(!mins.empty()){
            return mins.peek();
        }
        return Integer.MIN_VALUE;
    }
}
