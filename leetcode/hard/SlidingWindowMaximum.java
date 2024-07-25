/*
239. Sliding Window Maximum
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Note:
Solve in O(n)
主要思路是记录sliding window在滑动中出现的最大值, 找到最大值, 首先remove掉不然range中的数, 然后scan k range里比较小的数. 
因为每次在head记录最大的数, 那么较小的数是从tail开始. 每次remove在sliding window种较小的数都和nums[i]对比, 这保证了再滑动的过程中, window的head一定是当前最大值, 加入res中.

*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        // Save index of max number in the sliding window 
        Deque<Integer> window = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // Remove num out of range
            if (!window.isEmpty() && window.peek() < i - k + 1) {
                window.poll();
            }
            // Scan window and remove smaller numbers
            while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
                window.pollLast();
            }
            window.offer(i);
            if (i >= k - 1) {
                res[index++] = nums[window.peek()];
            }
        }
        return res;
    }
}
