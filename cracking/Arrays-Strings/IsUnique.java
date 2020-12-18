/**
 * IsUnique: Implement an algorithm to determine if a string has all unique characters. 
 */
public class IsUnique{

    public static boolean isUniqueSol(String str) {
        if (str.length() > 128) return false;
        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); ++i){
            if (charSet[str.charAt(i)]) return false;
            else charSet[str.charAt(i)] = true;
        }
        return true;
    }
    
    //assume input string is only lowercase char from 'a' to 'z'
    public static boolean isUniqueSolInBits(String str){
        //init 32 bit int 0
        int checker = 0;
        for (int i = 0; i < str.length(); ++i){
            //map char 'a' to 'z' to 32 bit (only need 26 bits actually)
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(isUniqueSolInBits("abc") == true);
        System.out.println(isUniqueSolInBits("aabji") == false);
        System.out.println(isUniqueSolInBits("jidsoaa") == false);
        System.out.println(isUniqueSolInBits("aaa") == false);
    }

}




