/* 
69. Sqrt(x) 
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. 
The returned integer should be non-negative as well.

Note:
When using x*x where x is 32 bits, then x*x should be casted to long which is 64 bits.

*/

class Sqrtx {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int left = 1;
        int right = x;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if ((long)middle * middle == x) {
                return middle;
            } else if ((long)middle * middle < x) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }

        }
        // In the last case, left is greater than right, so take right index to get rounded down value
        return right;
    }
    
}