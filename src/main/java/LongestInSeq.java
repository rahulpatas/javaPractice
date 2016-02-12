public class LongestInSeq {

    public static int lis(int[] arr){

        int maxCount =1;
        int current = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int count = 1;
            int j = i;

            if(maxCount >= arr.length -i){
                break;
            }

            while (j < arr.length ){

                if(current < arr[j]){
                    current = arr[j];
                    count++;
                }
                j++;
            }

            if(count>maxCount){
                maxCount = count;
            }
        }

        return maxCount;
    }

    public static void main(String[] args){

        System.out.println(lis(new int[]{ 10, 22, 9, 33, 21, 50, 41, 60, 80 }));
    }
}
