/* 
242. Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

*/

class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] dict = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            dict[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            dict[t.charAt(i) - 'a']--;
        }
        for (int i : dict) {
            if (i != 0) return false;
        }

        return true;
    }
}