/**
 * BinaryToString: Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double,
print the binary representation. If the number cannot be represented accurately in binary with at
most 32 characters, print"ERROR:'
 */
public class BinaryToString {
    public static String binaryToString(double n){
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        int counter = 32;
        while (counter > 0){
            n *= 2;
            if (n == 1) return sb.append(1).toString();
            else if (n > 1){
                sb.append(1);
                n -= 1;
            }
            else{
                sb.append(0);
            }
            counter--;
        }
        return "ERROR";
    }
    public static void main(String[] args) {
        System.out.println(binaryToString(0.72));
        System.out.println(binaryToString(0.001));
        System.out.println(binaryToString(0.5));
        System.out.println(binaryToString(0.357421875)); //0.010110111
        System.out.println(binaryToString(0.59375)); //0.10011
        System.out.println(binaryToString(0.9998779296875)); //0.1111111111111
        
    }
}