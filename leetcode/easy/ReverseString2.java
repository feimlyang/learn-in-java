/* 
541. Reverse String II
Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. 
If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.

Rephrasing the question:
For every group of 2k characters, reverse the first k characters.
Example:
"onetwoten", k = 3
we take the first group of 2k, or 6 chars: "onetwo"
reverse the first k = 3 chars
ignore the next k = 3 chars from this group: "eno" + "two"
take the next group of 2k = 6 chars: "ten" (we only have 3 chars left, so take those)
reverse the first k = 3 chars of the group: so "ten" becomes "net"
result: "eno" + "two" + "net"
*/



class ReverseString2 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, chars.length - 1);
            while (left < right) {
                char temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
            }
        }
        
        return new String(chars);    
    }
}