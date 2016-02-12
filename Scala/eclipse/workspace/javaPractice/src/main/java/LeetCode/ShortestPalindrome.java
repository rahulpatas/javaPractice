package LeetCode;

public class ShortestPalindrome {

    public static String shortestPalindromeKMP(String s) {

        if (s.length() <= 1) {
            return s;
        }

        String tmp = s + "#" + new StringBuilder(s).reverse().toString();
        return new StringBuilder(s.substring(getSP(tmp))).reverse().toString() + s;
    }

    private static int getSP(String s){

        int[] kmpIndex = new int[s.length()];

        int index = 0;

        for (int i = 1; i < s.length(); i++) {

            if(s.charAt(i) == s.charAt(index)){
                kmpIndex[i] = kmpIndex[i - 1] + 1;
                index++;
            }else {
                index = kmpIndex[i -1];

                while (index > 0 && s.charAt(i) != s.charAt(index)){
                    index = kmpIndex[index - 1];
                }

                if(s.charAt(i) == s.charAt(index)) {
                    index++;
                }

                kmpIndex[i] = index;
            }
        }

        return kmpIndex[kmpIndex.length -1];
    }

    public static String shortestPalindrome1(String s) {

        int n = s.length();

        if(n<=1){
            return s;
        }

        int idx = 0;

        for(int center = n/2; center >= 0; center--){

            if(valid(s, center, 1)){   //is the longest valid palindrome? (assume length is even)
                idx = 2*center + 1;
                break;
            }

            if(valid(s, center, 0)){  //assume length is odd
                idx = 2*center;
                break;
            }
        }

        String suffix = s.substring(idx+1);
        StringBuilder b = new StringBuilder(suffix);
        return b.reverse().toString()+s;
    }

    static boolean valid(String s, int center, int shift){
        int i = center, j = center+shift;

        while(i >= 0 && j < s.length()){

            if(s.charAt(i) != s.charAt(j)){
                break;
            }

            i--;
            j++;
        }
        return i < 0;
    }

    public static String shortestPalindrome2(String s) {

        int i = 0;
        while (!valid(s)){
            char c = s.charAt(s.length() -1 - i);
            s =  s.substring(0, i) + c + s.substring(i);
            i++;
        }

        return s;
    }

    private static boolean valid(String s){
        int len = s.length();
        String l, r;

        if(len % 2 == 0){
            l = s.substring(0, len/2 + 1);
            r = s.substring(len /2, len );
        }else {
            l = s.substring(0, len/2);
            r = s.substring(len /2 + 1, len );
        }

        r = new StringBuilder(r).reverse().toString();
        return r.equals(l);
    }

    public static void main(String[] args){
        System.out.println(shortestPalindromeKMP("aaacecaaa"));
        System.out.println(shortestPalindromeKMP("abcd"));
        System.out.println(shortestPalindromeKMP("abbacd"));
        System.out.println(shortestPalindromeKMP("abb"));
        System.out.println(shortestPalindromeKMP("aabbaad"));
    }
}
