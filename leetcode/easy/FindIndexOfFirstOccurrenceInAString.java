/*
28. Find the Index of the First Occurrence in a String

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Note: KMP
主要思想是当出现字符串不匹配时，可以知道一部分之前已经匹配的文本内容，可以利用这些信息避免从头再去做匹配了。
所以如何记录已经匹配的文本内容，是KMP的重点，也是next数组肩负的重任
next数组就是一个前缀表（prefix table）
前缀表有什么作用呢？
前缀表是用来回退的，它记录了模式串与主串(文本串)不匹配的时候，模式串应该从哪里开始重新匹配。
*/

class FindIndexOfFirstOccurrenceInAString1 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return -1;

        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                j = next[j - 1];
            }
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
            }
            if (j == needle.length()) return i - needle.length() + 1;
        }
        return -1;
    }

    private void getNext(int[] next, String pattern) {
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
                j = next[j - 1];
            }
            if (pattern.charAt(j) == pattern.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
    }


    /* 
    Sliding window: 
    loop over 'pattern' on window for each sliding; 
    If window can match to the last value of the 'pattern'. It means found the matched string. 
    */

     class FindIndexOfFirstOccurrenceInAString2 {
        public int strStr(String haystack, String needle) {
            for (int start = 0; start <= haystack.length() - needle.length(); start++) {
                for (int i = 0; i < needle.length(); i++) {
                    if (needle.charAt(i) != haystack.charAt(start + i)) break;
                    if (i == needle.length() - 1) return start;
                }
            }
    
            return -1;
        }
    }
}