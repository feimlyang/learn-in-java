/* 
34. Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].

Note:
The goal is to use binary search to find the left most and right most occurrences of the target.
This means if the left most occurrence happens, then there is no need to search toward left; also it applies to the case that right most occurrence happens.
Therefore, binary search should be applied to locate the interval.
*/


class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, target);

        if (index == -1) return new int[]{-1, -1};

        // We only know there is such a target and the index is fall within an unknown interval, so we need to search the boundaries
        int left = index;
        int right = index;
        while (left > 0 && nums[left - 1] >= target) {
            left--;
        }
        while (right < nums.length - 1 && nums[right + 1] <= target) {
            right++;
        }
        return new int[]{left, right};
        
    }

    public int binarySearch(int[] nums, int target) {
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
