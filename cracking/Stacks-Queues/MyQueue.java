import java.util.NoSuchElementException;

/**
 * MyQueue
 */
public class MyQueue<T> {
    private static class QueueNode<T>{
        private T value;
        private QueueNode<T> next;

        public QueueNode(T value){
            this.value = value;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T item){
        if (first == null) first = last = new QueueNode<T>(item);
        else {
            QueueNode<T> temp = last;
            last = new QueueNode<T>(item);
            temp.next = last;
        }
    }
    public T remove(){
        if (first == null) throw new NoSuchElementException();
  
        QueueNode<T> temp = first;
        first = first.next;
        if (first == null) last = null;
        return temp.value;
    }
    public T peek(){
        if (first == null) throw new NoSuchElementException();
        return first.value;

    }
    public boolean isEmpty(){
        return first == null;
        
    }
}