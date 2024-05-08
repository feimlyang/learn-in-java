/* 
283. Move Zeroes
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note: Two pointers
The goal is to move all 0 to the end. 
This means if one element is 0, it can be swapped with next non zero element pointed by the fast pointer.
The left pointer always points to writable element, which means the same element or zero.
For each swap with non zero element, the left pointer will move to the next element which is always writable because the fast pointer will skip all zeros. 

*/


class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                int temp = nums[fast];
                nums[fast] = 0;
                nums[slow++] = temp;
            }
            fast++;
        }
    }

}
