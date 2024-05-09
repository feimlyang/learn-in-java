/* 
209. Minimum Size Subarray Sum

Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Note: Sliding Window
Move the right pointer until the sum is greater than or equal to the target.
Move the left pointer if the sum is still greater than or equal to the target; otherwise continue moving the right pointer. 

*/

class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            currentSum += nums[right];
            while (currentSum >= target) {
                minLength = right - left + 1 > minLength ? minLength : right - left + 1;
                currentSum -= nums[left++];
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}