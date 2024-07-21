/* 
350. Intersection of Two Arrays II

Given two integer arrays nums1 and nums2, return an array of their intersection. 
Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

*/


class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] shortArr = nums1.length > nums2.length ? nums2 : nums1;
        int[] longArr = nums1.length > nums2.length ? nums1 : nums2;
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> countingMap = new HashMap<>();

        for (int i = 0; i < shortArr.length; i++) {
            int count = countingMap.getOrDefault(shortArr[i], 0);
            countingMap.put(shortArr[i], ++count);
        }
        for (int i = 0; i < longArr.length; i++) {
            int count = countingMap.getOrDefault(longArr[i], 0);
            if (count > 0) {
                countingMap.put(longArr[i], --count);
                res.add(longArr[i]);
            }
        }

        int[] res2 = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            res2[i] = res.get(i);
        }

        return res2;
    }
}