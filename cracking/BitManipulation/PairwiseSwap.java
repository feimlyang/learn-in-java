/**
 * PairwiseSwap: Write a program to swap odd and even bits in an integer with as few instructions as
possible (e.g., bit O and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
 */
public class PairwiseSwap {
    public static int swap(int n){
        //a: 1010 -> 0101 logic shift
        //5: 0101 -> 1010
        return ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
    }
}