/**
 * PalindromePermutation: Given a string, write a function to check if it is a permutation of
a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
permutation is a rearrangement of letters. The palindrome does not need to be limited to just
dictionary words.
 */
public class PalindromePermutation {

    public static boolean isPermutationOfPalindromeOne(String str){
        int[] charSet = new int[26];
        int oddCounter = 0, charCounter = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) != ' '){
                //deal with case insensitive
                int index;
                if (str.charAt(i) - 'a' < 0){
                    index = str.charAt(i) - 'A';
                }
                else{
                    index = str.charAt(i) - 'a';
                }
                charSet[index]++;

                if (charSet[index] % 2 == 1){
                    oddCounter++;
                }
                else{
                    oddCounter--;
                }
                charCounter++;
            }  
        }
        if (charCounter % 2 == 1) return oddCounter == 1;
        else return oddCounter == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPermutationOfPalindromeOne("Tact Coa") == true);
        System.out.println(isPermutationOfPalindromeOne("TactCoa O") == true);
        System.out.println(isPermutationOfPalindromeOne("TactCoaO") == true);
        System.out.println(isPermutationOfPalindromeOne("tO") == false);
        
    }
}