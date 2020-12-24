
/**
 * SortStack: Write a program to sort a stack such that the smallest items are on the top. You can use
an additional temporary stack, but you may not copy the elements into any other data structure
(such as an array). The stack supports the following operations: push, pop, peek, and is Empty
 */
public class SortStack {
    public static void sortStack(MyStack<Integer> stack){
        MyStack<Integer> sortedStack = new MyStack<>();
        while (!stack.isEmpty()){
            Integer temp = stack.pop();
            while (!sortedStack.isEmpty() && sortedStack.peek() > temp){
                stack.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }
        while (!sortedStack.isEmpty()){
            stack.push(sortedStack.pop());
        }
    } 
    public static void main(String[] args) {
        Integer[] data = {8,4,3,9,0,1,2,5};
        MyStack<Integer> stack = new MyStack<>();
        for (Integer i : data){
            stack.push(i);
        }
        sortStack(stack);
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " -> ");
        }
        System.out.println("BOTTOM");
    }
}