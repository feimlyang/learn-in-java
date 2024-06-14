/* 
349. Intersection of Two Arrays

Given two integer arrays nums1 and nums2, return an array of their intersection. 
Each element in the result must be unique and you may return the result in any order.

*/

class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> commonSet = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)) {
                commonSet.add(num);
            }
        }

        int[] res = new int[commonSet.size()];
        int index = 0;
        for (int num : commonSet) {
            res[index++] = num;
        }

        return res;
    }
}