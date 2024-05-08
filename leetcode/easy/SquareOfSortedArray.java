/* 
977. Squares of a Sorted Array

Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Note: Two pointers
The greater value of square of an element starts from either the start pointer or the end pointer.

*/

class SquareOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] squares = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int index = nums.length - 1;
        while (start <= end) {
            if (nums[start] * nums[start] > nums[end] * nums[end]) {
                squares[index--] = nums[start] * nums[start];
                start++;
            } else {
                squares[index--] = nums[end] * nums[end];
                end--;
            }
        }
        return squares;
    }

}