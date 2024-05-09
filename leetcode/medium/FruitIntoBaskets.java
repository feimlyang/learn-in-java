/* 
904. Fruit Into Baskets

You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.

Note: Sliding Window

Find the longest subarray that can contain 2 types of fruits.

Wrote case: pivot back traverses the repeating fruits only. 
If the array has repeating fruits for max of length - 1, pivot pointer will have O(n). However, this only happen 1 time. Therefore, complexity is O(n).

Alternatives: use HashMap instead using pivot pointer (slower?)

*/

class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        if (fruits.length <= 2) return fruits.length;

        int maxLength = Integer.MIN_VALUE;
        int fruitA = fruits[0];
        int fruitB = fruits[0];
        int left = 0;
        int right = 0;
        int pivot = 0;
        while (right < fruits.length) {
            if (fruits[right] != fruitA && fruits[right] != fruitB) {
                pivot = right - 1;
                fruitA = fruits[pivot];
                fruitB = fruits[right];
                while (pivot >= left) {
                    if (fruits[pivot] != fruitA) {
                        left = pivot + 1;
                        break;
                    }
                    pivot--;
                }
            }
            maxLength = right - left + 1 > maxLength ? right - left + 1 : maxLength;
            right++;
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }
}