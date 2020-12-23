
/**
 * StackMin: How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 */
public class StackMin<T extends Comparable<T>> extends MyStack<T> {
    private MyStack<T> stackWithMins;

    public StackMin (){
        stackWithMins = new MyStack<T>();
    }

    public T min(){
        if (stackWithMins.isEmpty()) return null;
        return stackWithMins.peek();
    }

    public void push(T item){
        if (super.isEmpty() || item.compareTo(min()) < 0){
            stackWithMins.push(item);
        }
        super.push(item);
    }
    public T pop() {
        T top = super.pop();
        if (top == min()){
            stackWithMins.pop();
        }
        return top;
    } 


    public static void main(String[] args) {
        StackMin<String> minStack = new StackMin<String>();
        minStack.push("b");
        minStack.push("a");
        minStack.push("d");
        minStack.push("c");
        System.out.println(minStack.min());
        System.out.println(minStack.pop());
        System.out.println(minStack.min());
        System.out.println(minStack.peek());

    }  
}