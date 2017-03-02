package LeetCode;

public class LargestPalindrome {

    public static int largestPalindrome(int n) {

        if(n == 1){
            return 9;
        }

        int maxVal = (int) (Math.pow(10, n) - 1);
        int minVal = maxVal / 10;

        long maxProduct = (long) maxVal * (long) maxVal;

        long firstHalf = maxProduct / (long) Math.pow(10, n);

        boolean found = false;
        long palindrome = 0;

        while(!found) {
           palindrome =  createPalindrome(firstHalf);

           for(long i = maxVal; i > minVal; i--) {

               if (palindrome / i > maxVal || i * i < palindrome) {
                   break;
               }

               if (palindrome % i == 0) {
                   found = true;
                   break;
               }
           }

           firstHalf--;
        }

        return (int)(palindrome %  1337L);
    }

    private static long createPalindrome(long num) {
        long reverse = 0;
        long y = num;

        while(y / 10 > 0) {
            reverse += y % 10;
            y = y / 10;
            reverse *= 10;
            num *= 10;
        }

        return num * 10 + reverse + y;
    }

    public static void main(String[] args) {
        largestPalindrome(8);
    }
}
