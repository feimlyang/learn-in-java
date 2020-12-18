
/**
 * CheckPermutation: Given two strings, write a method to decide if one is a permutation of the
other.
 */
public class CheckPermutation {
    public static boolean solution(String str1, String str2){
        if (str1.length() != str2.length()) return false;
        int[] charSet = new int[128];
        for (int i = 0 ; i < str1.length(); ++i){
            charSet[str1.charAt(i)]++;
        }
        for (int j = 0; j < str2.length(); ++j){
            charSet[str2.charAt(j)]--;
            if (charSet[str2.charAt(j)] < 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(solution("abc", "bca") == true);
        System.out.println(solution("abbc", "bca") == false);
        System.out.println(solution("abcd", "ebca") == false);
        System.out.println(solution("aaaabb", "aabbbb") == false);
        
    }
}