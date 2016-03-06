package LeetCode;

public class InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {

        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        if(l3 != l1 + l2) {
            return false;
        }

        int s1Index = 0;
        int s2Index = 0;

        for (int i = 0; i < s3.length(); i++) {

            if(s1Index < l1 && s3.charAt(i) == s1.charAt(s1Index) &&
                    s2Index < l2 && s3.charAt(i) == s2.charAt(s2Index)) {

                return isInterleave(s1.substring(s1Index), s2.substring(s2Index + 1), s3.substring(i + 1)) ||
                        isInterleave(s1.substring(s1Index + 1), s2.substring(s2Index), s3.substring(i + 1));


            } else if (s2Index < l2 && s3.charAt(i) == s2.charAt(s2Index)) {
                s2Index++;
            } else if (s1Index < l1 && s3.charAt(i) == s1.charAt(s1Index)) {
                s1Index++;
            } else {
                return false;
            }
        }

        return true;
    }

    public static boolean isInterleaveOptz(String s1, String s2, String s3) {

        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }

        boolean[] optimal = new boolean[s2.length() + 1];
        optimal[0] = true;

        for (int j = 0; j < s2.length(); j++) { //check no s1 char is selected, if s2 could equals to s3

            if (optimal[j] && s2.charAt(j) == s3.charAt(j)) {
                optimal[j + 1] = true;
            }
        }

        for (int i = 0; i < s1.length(); i++) { //check select i-th char in s1

            //no char in s2 is selected
            optimal[0] = optimal[0] && s1.charAt(i) == s3.charAt(i);

            for (int j = 0; j < s2.length(); j++) {  //select j-th char

                optimal[j + 1] = (s1.charAt(i) == s3.charAt(i + j + 1) && optimal[j + 1]) ||
                        s2.charAt(j) == s3.charAt(i + j + 1) && optimal[j];
            }
        }

        return optimal[s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
//        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
