import java.util.Arrays;
import java.util.Random;

/**
 * QuickSort
 * not stable as the pivot value is not guaranteed to be the median.
 * could be improved for large number of duplicated elements, use 3-way partition.
 */
public class QuickSort {
    public static void quickSort(int[] array){
        quickSort(array, 0, array.length-1);
    }
    private static void quickSort(int[] array, int left, int right){
        int p = partition(array, left, right);
        if (p-1 > left) quickSort(array, left, p-1);
        if (p < right) quickSort(array, p, right);
    }
    private static int partition(int[] array, int left, int right){
        //pivot value is random
        int pivot = array[left];
        while(left <= right){
            while(array[left] < pivot) left++;
            while(array[right] > pivot) right--;

            if(left <= right){
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }

        }
        //index left has to pass the right and points to the first value of right sub array,
        //but it is not necessarily be the smallest value in right sub array.
        return left;
    }

    public static void arrayToString(int[] array){
        for (int i : array){
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test1 = {2,1,4,5,10,7,3,8,20,11,0};
        int[] test2 = {1,2,3,4,5,6,7,8};
        int[] test3 = {9,8,7,6,5,4,3,2,1,0};
        int[] test4 = {1,2,-3,4,-5,6,7,8,-9};
        int[] test5 = {1,0};
        quickSort(test1); arrayToString(test1);
        quickSort(test2); arrayToString(test2);
        quickSort(test3); arrayToString(test3);
        quickSort(test4); arrayToString(test4);
        quickSort(test5); arrayToString(test5);


        int[] test = new int[100];
        int[] standard = new int[100];
        Random rand = new Random();
        for (int i = 0; i < 100; i++){
            int num = rand.nextInt();
            System.out.println(num + " ");
            test[i] = num;
            standard[i] = num;
        }
        quickSort(test);
        Arrays.sort(standard);
        System.out.println(Arrays.equals(test, standard));
        
    }
}