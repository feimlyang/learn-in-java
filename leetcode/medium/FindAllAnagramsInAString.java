/* 
438. Find All Anagrams in a String

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Note: Sliding Window
Since we compare character, we can use an array in length of 26 instead hashmap.
We compare the 

*/

// Easy solution
class FindAllAnagramsInAString1 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] chars = p.toCharArray();
        Arrays.sort(chars);

        for (int i = 0; i <= s.length() - p.length(); i++) {
            char[] sub = s.substring(i, i + p.length()).toCharArray();
            Arrays.sort(sub);
            if (Arrays.equals(sub, chars)) {
                res.add(i);
            }
        }
        
        return res;
    }
}

// Better solution using sliding window
class FindAllAnagramsInAString2 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] arrp = new int[26];
        int[] arrs = new int[26];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            arrp[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            // Use sliding window to update arrs and compare it with arrp
            arrs[s.charAt(i) - 'a']++;
            if (i >= p.length()) {
                arrs[s.charAt(i - p.length()) - 'a']--;
            }
            if (Arrays.equals(arrp, arrs)) {
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
}
