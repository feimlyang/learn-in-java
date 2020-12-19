import java.util.Arrays;

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

    public static boolean solutionTwo (String str1, String str2){
        if (str1.length() != str2.length()) return false;
        return sortStr(str1).equals(sortStr(str2));

    }
    private static String sortStr (String str){
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }


    public static void main(String[] args) {
        System.out.println(solution("abc", "bca") == true);
        System.out.println(solution("abbc", "bca") == false);
        System.out.println(solution("abcd", "ebca") == false);
        System.out.println(solution("aaaabb", "aabbbb") == false);

        System.out.println(solutionTwo("abc", "bca") == true);
        System.out.println(solutionTwo("abbc", "bca") == false);
        System.out.println(solutionTwo("abcd", "ebca") == false);
        System.out.println(solutionTwo("aaaabb", "aabbbb") == false);
        
    }
}