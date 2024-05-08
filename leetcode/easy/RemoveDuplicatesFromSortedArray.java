/* 
26. Remove Duplicates from Sorted Array 

Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. 
The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Note: Two pointers
Since it is sorted array, the fast pointer search for difference occurrence.
If difference occurs, the slow pointer writes the unique element and then points to the next index.
 
*/


class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[fast-1] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

}