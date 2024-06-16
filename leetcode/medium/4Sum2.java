/* 
454. 4Sum II

Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:

0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0


Note:
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0  
=>  (nums1[i] + nums2[j]) + (nums3[k] + nums4[l]) == 0
=>  (nums1[i] + nums2[j]) == - (nums3[k] + nums4[l])
We can use one hashmap to record the combinations of nums1 and nums2, and looking for offset while finding all combinations with nums3 and nums4.

*/


class 4Sum2 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> pairMap = new HashMap<>();
        int res = 0;

        for (int m : nums1) {
            for (int n : nums2) {
                pairMap.put(m + n, pairMap.getOrDefault(m + n, 0) + 1);
            }
        }
        for (int m : nums3) {
            for (int n : nums4) {
                if (pairMap.getOrDefault(-(m + n), 0) > 0) {
                    // All occurrences
                    res += pairMap.getOrDefault(-(m + n), 0);
                }
            }
        }

        return res;
    }
}