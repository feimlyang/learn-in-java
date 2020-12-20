
/**
 * StringRotation: Assume you have a method isSubstring which checks if one word is a substring
of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
call to isSubstring (e.g., "waterbottle" is a rotation of" erbottlewat").
trick: if x and y are two strings and yx is the rotation of xy, then yx is a substring of xyxy. eg. xy+xy.
 */
public class StringRotation {
    public static boolean isRotatedString(String str1, String str2){
        if (str1.length() == str2.length()){
            return isSubstring(str2, str1 + str1);
        }
        return false;
    }

    //return if str1 is substring of str2
    public static boolean isSubstring(String str1, String str2){
        for (int i = 0; i <= str2.length() - str1.length(); i++){
            boolean isFound = true;
            for (int j = 0; j < str1.length(); j++){
                if (str2.charAt(i+j) != str1.charAt(j)){
                    isFound = false;
                    break;
                }
            }
            if (isFound) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isSubstring("st", "st") == true);
        System.out.println(isSubstring("str", "sstring") == true);
        System.out.println(isSubstring("tor", "string") == false);
        System.out.println(isSubstring("abc", "abd") == false);

        System.out.println(isRotatedString("waterbottle", "erbottlewat"));
        
    }

    
}