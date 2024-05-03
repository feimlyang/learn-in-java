
/* 704. Binary Search 
Given an array of integers nums which is sorted in ascending order, and an integer target, 
write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

Note: 注意区间 [left, right]

Since array is sorted, target value is either in the left section or right section.
For each search on one section divided by a middle point that never been checked, we look if the middle point of searched section is the target value.
Assume the middle point is always the floor of left + (right - left) / 2, left index == right index would be the last case while loop over on left <= right.  
*/

class BinarySearch {
    public int search(int[] nums, int target) {
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
        return -1;
    }
}