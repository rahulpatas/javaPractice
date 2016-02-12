public class SplitArraySum {

    public static boolean Split(int[] a) {

        long targetSum = targetSum(a);

        return targetSum != 0 && SplitPossible(a, 0, targetSum, 0);

    }
    private static boolean SplitPossible(int[] a, long currentSum, long targetSum, int index) {

        return index < a.length &&
                ((currentSum + a[index]) == targetSum
                        || (currentSum + a[index]) < targetSum
                        && SplitPossible(a, currentSum + a[index], targetSum, index + 1));

    }

    private static long targetSum(int[] a){

        long targetSum = 0;

        for(int e : a){
            targetSum += e;
        }
        if(targetSum%2 ==0){
            return targetSum/2;
        }else {
            return 0;
        }
    }

    public static void main(String[] args){

        System.out.println(Split(new int[]{1, 2, 3, 6, 12}));
        System.out.println(Split(new int[]{1, 2, 3, 6, 6, 184}));

    }

}
