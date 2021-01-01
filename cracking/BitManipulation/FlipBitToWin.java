/**
 * FlipBitToWin: You have an integer and you can flip exactly one bit from a O to a 1. Write code to
find the length of the longest sequence of 1 s you could create.
 */
public class FlipBitToWin {
    public static int longestOnes(int n){
        int counter = 0, max = 0, lastBit;
        while (n != 0){
            lastBit = n & 1;
            if (lastBit == 1){
                counter++;
                max = Math.max(counter, max);
            }
            else{
                counter = 0;
            }
            n = n >>> 1;
        }
        return max;

    }
    public static void main(String[] args) {
        System.out.println(longestOnes(0b1000111110) == 5);
        System.out.println(longestOnes(0b01100000) == 2);
        System.out.println(longestOnes(0b1111000111) == 4);
        System.out.println(longestOnes(0b10001111) == 4);
        System.out.println(longestOnes(0b011110001111) == 4);
        System.out.println(longestOnes(0b00000) == 0);
        System.out.println(longestOnes(0b11111) == 5);
        System.out.println(longestOnes(0b10101010) == 1);
    }
}