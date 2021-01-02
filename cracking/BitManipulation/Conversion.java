/**
 * Conversion: Write a function to determine the number of bits you would need to flip to convert
integer A to integer B.
 */
public class Conversion {
    //number of bits that are different, A XOR B
    public static int numToFlip(int a, int b){
        int count = 0;
        int c = a ^ b;
        for (int i = c; i != 0; i >>= 1){
            if ((i & 1) == 1) count++;
        }
        return count;

    }
    public static void main(String[] args) {
        System.out.println(numToFlip(0b11101, 0b01111) == 2);
        System.out.println(numToFlip(0b0, 0b111) == 3);
        System.out.println(numToFlip(0b100110, 0b10) == 2);
        
    }
}