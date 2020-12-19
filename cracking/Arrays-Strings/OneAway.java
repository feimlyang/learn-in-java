
/**
 * OneAway: There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
 */
public class OneAway {
    public static boolean isOneEditAway(String str1, String str2){
        if (Math.abs(str1.length() - str2.length()) > 1) return false;

        String longerString = str1.length() < str2.length() ? str2 : str1;
        String shorterString = str1.length() < str2.length() ? str1 : str2;

        boolean isOneAway = false;

        for (int i = 0; i < shorterString.length(); i++){
            if (!isOneAway && shorterString.charAt(i) != longerString.charAt(i)){
                isOneAway = true;
            }
            else{
                if (longerString.length() == shorterString.length()){
                    if (isOneAway && shorterString.charAt(i) != longerString.charAt(i)){
                        return false;
                    }
                }
                else{
                    if (isOneAway && shorterString.charAt(i-1) != longerString.charAt(i)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isOneEditAway("pale", "ple") == true);
        System.out.println(isOneEditAway("pales", "pale") == true);
        System.out.println(isOneEditAway("pale", "bale") == true);
        System.out.println(isOneEditAway("pale", "bae") == false);
    }


}