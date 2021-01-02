/**
 * NextNumber: Given a positive integer, print the next smallest and the next largest number that
have the same number of 1 bits in their binary representation.
 */
public class NextNumber {

    public static int getNext(int n){
        if (n == 0) return 0;
        //find right most 0 that on the left of 1, eg: ...01...
        int clear = 0;
        int maskToOne = 1;
        int m = n;
        int pivot = n & 1;
        int pivotLeft = (m >> 1) & 1;
        while (n != 0 && !(pivot == 1 && pivotLeft == 0)){
            if (pivot == 1){
                maskToOne <<= 1;
                maskToOne += 1;
            }
            clear++;
            n >>= 1;
            m = n;
            pivot = n & 1;
            pivotLeft = (m >> 1) & 1;
        }
        n = n & (~0 - 1);
        n = ((n >> 1) + 1) << (clear + 1);
        return n | (maskToOne >> 1);
    }

    public static int getPrev(int n){
        if (n == 0) return n;
        //find right most 1 that on the left of 0, eg: ...10...
        int maskToOne = 0;
        int clear = 0;
        int m = n;
        int pivot = n & 1;
        int pivotLeft = (m >> 1) & 1;
        while (n != 0 && !(pivot == 0 && pivotLeft == 1)){
            maskToOne <<= 1;
            if (pivot == 1){
                maskToOne += 1;
            }
            clear++;
            n >>= 1;
            m = n;
            pivot = n & 1;
            pivotLeft = (m >> 1) & 1;
        }
        if (n != 0){
            n = ((n >> 2) << 2) + 1;
            n <<= clear;
        }
        return n | maskToOne;

    }
    public static void main(String[] args) {
        System.out.println(getNext(0b01) == 0b10);
        System.out.println(getNext(0b110110) == 0b111001);
        System.out.println(getNext(0b110110011100) == 0b110110100011);
        System.out.println(getNext(0b11011011111100) == 0b11011100011111);
        System.out.println(getNext(0b10011110000011) == 0b10011110000101);
        System.out.println(getNext(0b0) == 0b0);
        System.out.println(getNext(0b0000001) == 0b10);
        System.out.println(getNext(0b11111) == 0b101111);

        System.out.println(getPrev(0b010001) == 0b01100);
        System.out.println(getPrev(0b11011001111100) == 0b11011001111010);
        System.out.println(getPrev(0b10011110000011) == 0b10011101110000);
        System.out.println(getPrev(0b11111) == 0b11111);
        System.out.println(getPrev(0b0) == 0b0);
        System.out.println(getPrev(0b00001) == 0b1);
        System.out.println(getPrev(0b0011010101) == 0b0011010011);

    }
}