package LeetCode;

public class NimGame {

    public static boolean canWin(int n){

        if(n <= 0){
            throw new IllegalArgumentException();
        }

        if(n <= 3){
            return true;
        }

         boolean[] win = new boolean[n + 1];

        win[0] = true;
        win[1] = true;
        win[2] = true;

        for(int i = 3 ; i < n ; i++) {

            win[i] = !(win[i - 1] && win[i - 2] && win[i - 3]);
        }

        return win[n -1];
    }

    public static boolean canWinShort (int n){

        if(n <= 0){
            throw new IllegalArgumentException();
        }

       return !(n % 4 == 0);
    }

    public static void main(String[] args){
        System.out.println(canWin(4));
        System.out.println(canWinShort(4));
    }
}
