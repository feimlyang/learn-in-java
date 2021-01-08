/**
 * BinarySearch
 */
public class BinarySearch {
    public static int binarySearch(int[] array, int n){
        int left = 0, right = array.length-1;
        int middle;
        while (left <= right){
            middle = (left + right)/2;
            if (n == array[middle]){
                return middle;
            }
            else if (n < array[middle]){
                right = middle - 1;
            }
            else{
                left = middle + 1;
            }
        }
        return -1;
    }

}