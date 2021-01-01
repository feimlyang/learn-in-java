/**
 * Insertion: You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method
to insert M into N such that M starts at bit j and ends at bit i. You can assume that the bits j through
i have enough space to fit all of M. That is, if M = 10011, you can assume that there are at least 5
bits between j and i. You would not, for example, have j = 3 and i = 2, because M could not fully
fit between bit 3 and bit 2.
Input:   N = 10000000000, M = 10011, i = 2, j = 6
Output:  N = 10001001100
 */
public class Insertion {
    public static int insert(int n, int m, int i, int j){
        // ...000 << 2 -> ...100 - 1 -> ...011
        int a = (1 << i) - 1; 
        // ...11 << 7 -> ...110000000
        int b = ~0 << j + 1;
        int n_clear = n & (a | b);
        return n_clear | (m << i); 
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(insert(0b10000000000, 0b10011, 2, 6)));
        System.out.println(Integer.toBinaryString(insert(0b10000000111, 0b10011, 1, 6)));
        System.out.println(Integer.toBinaryString(insert(0b10000000111, 0b10011, 0, 6)));
        System.out.println(Integer.toBinaryString(insert(0b11000000001, 0b10011, 2, 10)));
    }
}