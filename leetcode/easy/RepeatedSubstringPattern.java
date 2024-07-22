/*
459. Repeated Substring Pattern

Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.


Note: KMP Algorithm

Next 数组是用来记录 如果String和pattern不匹配是应该回退到什么位置
EX1. “ABABC”

pattern: A B A B C
next:    0 0 1 2 0
当遍历到第四位时, 可知最长的prefix长度为2, 因为AB有已知的repeating pattern. 第五位C没有重复prefix, 因为记为0.

EX2. “ABACABAB”

A B A C A B A B
0 0 1 0 1 2 3 2
遍历到最后一位B时, 虽然不能match到’ABA’, 但是有’AB’可以match, 所以最长的prefix为2.

Now, we have a string “ABABABCAA” and apply the pattern given in EX1.

ABABABCAA
ABABC

A和C不匹配, 我们看上一位B标记的长度, 我们知道可以跳过2位来继续匹配, 即为:

ABABABCAA
  ABABC


*/

class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int[] next = new int[s.length()];
        getNext(next, s);
        // If s is constituted by k repeating pattern, the last value of next is the max length of the repeating pattern prefix
        // and it should be non zero
        // and s.length() - maxLen is the length of exact one repeating pattern
        int maxLen = next[next.length - 1];
        if (maxLen > 0) {
            return s.length() % (s.length() - maxLen) == 0;
        }
        return false;
    }

    private void getNext(int[] next, String pattern) {
        int j = 0;
        next[0] = j;
        for (int i = 1; i < pattern.length(); i++) {
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j-1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) j++;
            next[i] = j;
        }
     }
}