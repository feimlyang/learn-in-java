
/* 
35. Search Insert Position

Given a sorted array of distinct integers and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.

Note:
Binary Search O(logn)
For each binary search, check if the target is within this search. 
If the target as the middle value is found, then return the index; otherwise return the index that left index and right index encounters.
This is also the middle value in each binary search, just it does not occurs until the last case because it does not exist. 
 */

class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left; 
    }
}