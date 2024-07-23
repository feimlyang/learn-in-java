/*
232. Implement Queue using Stacks
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.

*/

class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        this.stackIn = new Stack<>();
        this.stackOut = new Stack<>();
    }
    
    public void push(int x) {
        stackIn.push(x);
    }
    
    public int pop() {
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
        int val = stackOut.pop();
        while (!stackOut.isEmpty()) {
            stackIn.push(stackOut.pop());
        }
        return val;
    }
    
    public int peek() {
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
        int val = stackOut.peek();
        while (!stackOut.isEmpty()) {
            stackIn.push(stackOut.pop());
        }
        return val;
    }
    
    public boolean empty() {
        return stackIn.isEmpty();  
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */