/**
 * QueueViaStacks: Implement a MyQueue class which implements a queue using two stacks.
 */
public class QueueViaStacks<T> {
    private MyStack<T> stack1, stack2;

    public QueueViaStacks(){
        this.stack1 = new MyStack<T>();
        this.stack2 = new MyStack<T>();
    }
    public void add(T elem){
        stack2.push(elem);
    }
    public T remove(){
        if (stack1.isEmpty()){
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
        return stack1.pop();

    }
    public T peek(){
        if (stack1 == null){
            while (!stack2.isEmpty()) stack1.push(stack2.pop());
        }
        return stack1.peek();
    }
    public boolean isEmpty(){
        return stack1 == null && stack2 == null;
    }

    public static void main(String[] args) {
        QueueViaStacks<Integer> queue = new QueueViaStacks<>();
        for (int i = 0; i < 25; i++){
            queue.add(i);
        }
        System.out.print("FIRST -> ");
        for (int i = 0; i < 11; i++){
            System.out.print(queue.remove() + " -> ");
        }
        System.out.println(" ... ");

        for (int i = 25; i < 30; i++){
            queue.add(i);
        }
        System.out.print("FIRST -> ");
        for (int i = 0; i < 15; i++){
            System.out.print(queue.remove() + " -> ");
        }
        System.out.println(" ... ");
    }
}