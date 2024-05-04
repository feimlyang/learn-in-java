
/* 367. Valid Perfect Square 
Given a positive integer num, return true if num is a perfect square or false otherwise.
A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.

*/

class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num < 2) return true;
        long left = 1;
        long right = num;
        while (left <= right) {
            long middle = left + (right - left) / 2;
            if (middle * middle == num) {
                return true;
            } else if (middle * middle < num) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }

}