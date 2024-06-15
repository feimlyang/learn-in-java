/* 
383. Ransom Note

Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.
*/


class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] dict = new int[26];

        for (char c : ransomNote.toCharArray()) {
            dict[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            if (dict[c - 'a'] > 0) dict[c - 'a']--;
        }
        for (int i : dict) {
            if (i > 0) return false;
        }

        return true;
    }
}