package GeekCoder;

public class NumTrialDy {

    public static int numTrial(int numEggs, int numFloors){
        int min = Integer.MAX_VALUE;

        if(numEggs ==1){
            return numFloors;
        }

        if(numFloors <= 1){
            return numFloors;
        }

        for (int i = 1; i < numFloors ; i++) {

            int res = Integer.max(numTrial(numEggs -1, i -1), numTrial(numEggs, numFloors -i));

            if(res < min){
                min = res;
            }
        }

        return min + 1;
    }

    public static void main(String[] args){

        System.out.println(numTrial(2, 37));
        System.out.println(numTrial(3, 40));
    }
}
