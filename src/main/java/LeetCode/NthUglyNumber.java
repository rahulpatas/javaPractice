package LeetCode;

public class NthUglyNumber {

    public static int nthUglyNumber(int n) {

        int[] uglyNum = new int[n];
        int p2 = 0, p3 = 0, p5 = 0, p = 1;

        uglyNum[0] = 1;

        while (p < n){

            uglyNum[p] = min(uglyNum[p2] * 2, uglyNum[p3] * 3, uglyNum[p5] * 5);

            while (uglyNum[p2]*2 <= uglyNum[p]){
                p2++;
            }

            while (uglyNum[p3]*3 <= uglyNum[p]){
                p3++;
            }

            while (uglyNum[p5]*5 <= uglyNum[p]){
                p5++;
            }

            p++;
        }

        return uglyNum[n -1];
    }

    private static int min(int a, int b, int c){
        int tmp = Integer.min(a, b);

        return Integer.min(tmp, c);
    }

    public static void main(String[] args){

        System.out.println(nthUglyNumber(12));
    }
}
