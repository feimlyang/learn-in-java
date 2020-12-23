import java.util.EmptyStackException;

/**
 * ThreeInOne: Describe how you could use a single array to implement three stacks
 */
public class FixedMultiStack {
    //easy implementaion, fixed division
    private int numOfStacks = 3;
    //capcity for each stack
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackSize){
        stackCapacity = stackSize;
        values = new int[stackSize * numOfStacks];
        sizes = new int[numOfStacks];
    }

    public void push(int stackNum, int value) throws RuntimeException{
        if (isFull(stackNum)) throw new RuntimeException("stack is full");
        values[indexOfTop(stackNum)+1] = value;
        sizes[stackNum]++;
    }
    public int pop(int stackNum){
        if (isEmpty(stackNum)) throw new EmptyStackException();
        int value = values[indexOfTop(stackNum)];
        values[indexOfTop(stackNum)] = 0;
        sizes[stackNum]--;
        return value;
    }
    public int peek(int stackNum){
        if (isEmpty(stackNum)) throw new EmptyStackException();
        return values[indexOfTop(stackNum)];

    }
    public boolean isEmpty(int stackNum){
        return sizes[stackNum] == 0;

    }
    public boolean isFull(int stackNum){
        return sizes[stackNum] == stackCapacity;

    }
    /* Returns index of the top of the stack. */
    private int indexOfTop(int stackNum){
        return stackNum * stackCapacity - 1 + sizes[stackNum];
    }

    public void printMultiStack(){
        int stackNum = 0;
        int index = 0;
        while (index < numOfStacks * stackCapacity){
            while (index <= indexOfTop(stackNum)){
                System.out.print(values[index++] + "->");
            }
            System.out.println("TOP");
            stackNum++;
            index = stackNum * stackCapacity;
        }
    }

    public static void main(String[] args) {
        try{
            int[] data = {2, 3, 6, 9, 1, 1, 7};
            FixedMultiStack multiStack = new FixedMultiStack(10);
            for (int n : data){
                multiStack.push(n%3, n);
            }
            multiStack.printMultiStack();

            System.out.println(multiStack.pop(0));
            System.out.println(multiStack.peek(0));
            System.out.println(multiStack.pop(2));
            multiStack.printMultiStack();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }


}