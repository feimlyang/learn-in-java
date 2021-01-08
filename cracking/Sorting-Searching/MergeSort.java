/**
 * MergeSort
 */
public class MergeSort {

    public static void mergeSort(int[] array){
        //extra space, use a helper array to compare two sub arrays in merge stage 
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length-1);
    }

    private static void mergeSort(int[] array, int[] helper, int low, int high){
        if (low < high){
            int middle = (low + high) / 2;
            mergeSort(array, helper, low, middle);
            mergeSort(array, helper, middle + 1, high);
            merge(array, helper, low, middle, high);
        }
    }

    private static void merge(int[] array, int[] helper, int low, int middle, int high){
        for (int i = low; i <= high; i++){
            helper[i] = array[i];
        }
        //use two pointer method to iterate helper, fill back in original array
        int i = low, j = middle + 1, current = low;
        while (i <= middle && j <= high){
            if (helper[i] <= helper[j]){
                array[current++] = helper[i++];
            }
            else{
                array[current++] = helper[j++];
            }
        }
        //Since sub arrays are sorted, if right array has remaining then it is already in the right position at the end of the original array.
        //So only check left sub array
        for (int k = 0; k <= middle - i; k++){
            array[current + k] = helper[i + k];
        }
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
        mergeSort(test1);
        mergeSort(test2);
        mergeSort(test3);
        mergeSort(test4);
        mergeSort(test5);
        arrayToString(test1);
        arrayToString(test2);
        arrayToString(test3);
        arrayToString(test4);
        arrayToString(test5);
    }

}