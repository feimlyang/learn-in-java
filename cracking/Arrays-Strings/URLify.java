/**
 * URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. perform this operation in place
 */
public class URLify {

    public static void replaceSpace (char[] str, int trueLength){
        //calculate the last index I need
        int index = -1;
        for (int i = 0; i < trueLength; i++){
            if (str[i] == ' ') index += 3;
            else index++;
        }

        for (int i = trueLength-1; i >= 0; i--){
            if (str[i] == ' '){
                str[index] = '0';
                str[index-1] = '2';
                str[index-2] = '%';
                index -= 3;
            }
            else{
                str[index] = str[i];
                index--;
            }
        }
    }

    public static void main(String[] args) {
        char[] testStr = "Mr John Smith           ".toCharArray();
        replaceSpace(testStr, 13);
        System.out.println(new String(testStr));
    }
}