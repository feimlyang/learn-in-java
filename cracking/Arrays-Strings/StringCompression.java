/**
 * StringCompression: Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class StringCompression {

    public static String compressString(String str){
        //Concat string copies every time, so O(n^2). Use StringBuilder (resizable array) to avoid.
        //could also loop to calculate the capacity and then init StringBuilder with final length. a bit better.
        StringBuilder res = new StringBuilder();
        int counter = 0;
        char countingChar = ' ';
        if (str.length() <= 1) return str;
        for (int i = 0; i < str.length(); i++){
            countingChar = str.charAt(i);
            counter++;
            if ( i >= str.length() - 1 || str.charAt(i) != str.charAt(i+1)){
                res.append(countingChar);
                res.append(counter);
                counter = 0;
            }
        }
        System.out.println(res);
        return res.length() < str.length() ? res.toString(): str;

    }

    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa").equals("a2b1c5a3"));
    }

}