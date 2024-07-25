/*
347. Top K Frequent Elements

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Note:
Heap的应用相当于heap sorting O(nlogn), 思路是min heap的top为最小值, 那么每次remove最小值之后, heap则剩下最大的k个值. 
目的是对the length of each repeating elements进行排序. Java PQ的底层实现是基于priority heap. PQ初始需要override comparator.
*/


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countingMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countingMap.put(nums[i], countingMap.getOrDefault(nums[i], 0) + 1);
        }

        // Heap sort the key compared by its value
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    return Integer.compare(countingMap.get(a), countingMap.get(b));
                }
            }
        );

        // Poll the key with min value until the min heap size is k
        for (Map.Entry<Integer, Integer> entry: countingMap.entrySet()) {
            minHeap.offer(entry.getKey());
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) {
            res[index++] = minHeap.poll();
        }
        
        return res;
    }
}