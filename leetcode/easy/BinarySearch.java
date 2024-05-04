
/* 704. Binary Search 
Given an array of integers nums which is sorted in ascending order, and an integer target, 
write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

Note: 注意区间 [left, right]

Since array is sorted, target value is either in the left section or right section.
For each search on one section divided by a middle point that never been checked, we look if the middle point of searched section is the target value.
Assume the middle point is always the floor of left + (right - left) / 2, left index == right index would be the last case while loop over on left <= right because of closed upper bound [left, right].

Why not take middle = (left + right) / 2? left可能不断增大，如果到极限状态，也就是left达到了right-1的地步的时候刚好数组的长度又很大，那么就可能导致left + right的溢出出现负数；
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