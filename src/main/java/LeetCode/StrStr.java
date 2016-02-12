package LeetCode;

public class StrStr {

    public static int strStr(String haystack, String needle) {

        int nLen = needle.length();
        if(nLen == 0 ){
            return 0;
        }

        for (int i = 0; i <= haystack.length() - nLen; i++) {
            if(haystack.substring(i, i + nLen).equals(needle)){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        strStr("mississippi","pi");
        strStr("a","a");
    }
}
