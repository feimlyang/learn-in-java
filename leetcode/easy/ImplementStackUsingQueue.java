/*
225. Implement Stack using Queues
Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.


Note: 
Queue is Interface in Java, so we instanlised with LinkedList
*/

class MyStack {
    Queue<Integer> queueIn;
    Queue<Integer> queueOut;

    public MyStack() {
        this.queueIn = new LinkedList<>();
        this.queueOut = new LinkedList<>();
    }
    
    // Add the latest elem to the head of linkedlist because linkedlist pop the head
    public void push(int x) {
        queueOut.offer(x);
        while (!queueIn.isEmpty()) {
            queueOut.offer(queueIn.poll());
        }
        while (!queueOut.isEmpty()) {
            queueIn.offer(queueOut.poll());
        }
    }
    
    public int pop() {
        return queueIn.poll();
    }
    
    public int top() {
        return queueIn.peek();
    }
    
    public boolean empty() {
        return queueIn.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

