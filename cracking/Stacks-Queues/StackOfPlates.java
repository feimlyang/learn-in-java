import java.util.ArrayList;

/**
 * StackOfPlates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
composed of several stacks and should create a new stack once the previous one exceeds capacity.
SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack
(that is, pop () should return the same values as it would if there were just a single stack).

 */
public class StackOfPlates {
    private ArrayList<MyStack<Integer>> stackLists;
    private int counter;
    private int capacity;
    private MyStack<Integer> workingStack;

    public StackOfPlates(int capacity){
        this.capacity = capacity;
        this.counter = 0;
        this.stackLists = new ArrayList<MyStack<Integer>>();
        this.workingStack = new MyStack<Integer>();
        stackLists.add(workingStack);
    }

    public void push(Integer elem){
        if (counter >= capacity){
            workingStack = new MyStack<Integer>();
            stackLists.add(workingStack);
            counter = 0;
        }
        workingStack.push(elem); 
        counter++;
    }
    public Integer pop(){
        if (counter == 0){
            stackLists.remove(stackLists.size()-1);
            if (stackLists.size() == 0) return null;
            workingStack = stackLists.get(stackLists.size()-1);
            counter = capacity;
        }
        Integer elem = workingStack.pop();
        counter--;
        return elem;
    }

    public static void main(String[] args) {
        StackOfPlates stack = new StackOfPlates(10);
        for (int i = 0; i < 45; i++){
            stack.push(i);
        }
        for (int i = 0; i < 42; i++){
            System.out.print(stack.pop() + " -> ");
        }
        System.out.println("END");
    }
}