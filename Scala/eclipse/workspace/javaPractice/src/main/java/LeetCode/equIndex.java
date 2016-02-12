package LeetCode;

public class equIndex {

    public static int solution(int[] A) {
        // write your code in Java SE 8

        if(A.length < 3){
            return -1;
        }

        int sumTillIndex = 0;
        int equIndex = -1;

        int len = A.length;
        int[] sumForward = new int[len-1];
        sumForward[0] = 0;

        for (int i = 1; i < A.length -1; i++) {
            sumTillIndex += A[i - 1];
            sumForward[i] = sumTillIndex;
        }

        sumTillIndex = 0;
        int element = A[len - 1];

        for (int i = 1; i < A.length -1; i++) {

            sumTillIndex += element;
            element = A[len - i -1];
            A[len - i - 1] = sumTillIndex;
        }

        for (int i = 1; i < A.length -1; i++) {

            if(sumForward[i] == A[i]){
                equIndex = i;
                break;
            }
        }

        return equIndex;
    }

    public static void main(String[] args){

        solution(new int[]{-1,3,-4,5,1,-6,2,1});
    }
}
