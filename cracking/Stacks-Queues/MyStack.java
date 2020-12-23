import java.util.EmptyStackException;

/**
 * MyStack
 */
public class MyStack<T> {
    private static class StackNode<T>{
        private T value;
        private StackNode<T> next;

        public StackNode(T value){
            this.value = value;
        }
    }

    private StackNode<T> top;

    public T pop(){
        if (top == null) throw new EmptyStackException();
        T temp = top.value;
        top = top.next;
        return temp;
        
    }
    public void push(T item){
        StackNode<T> node = new StackNode<T>(item);
        node.next = top;
        top = node;
    }
    public T peek(){
        if (top == null) throw new EmptyStackException();
        return top.value;
    }
    public boolean isEmpty(){
        return top == null;
    }
}