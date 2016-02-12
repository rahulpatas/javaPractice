public class NumTrial {

    public static int numTrial(int numEggs, int numFloors){

        int[][]eggFloor = new int[numEggs+1][numFloors+1];

        if(numEggs <1 || numFloors < 1){
            throw new IllegalArgumentException("Number of Eggs or Number of floors can not be less than 1");
        }

        for (int i = 1; i < numEggs ; i++) {

            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }

        for (int i = 1; i < numFloors ; i++) {

            eggFloor[1][i] = i;
        }

        for (int i = 2; i <= numEggs ; i++) {

            for (int j = 2; j <= numFloors ; j++) {

                eggFloor[i][j] = Integer.MAX_VALUE;

                for (int k = 1; k < j; k++) {

                    int res = 1 + Integer.max(eggFloor[i-1][k-1], eggFloor[i][j-k]);

                    if(res<eggFloor[i][j]){
                        eggFloor[i][j] = res;
                    }
                }
            }
        }

        return eggFloor[numEggs][numFloors];
    }

    public static void main(String[] args){

        boolean t = false;
        System.out.println(numTrial(2, 37));
        System.out.println(numTrial(3, 40));

        try {
            numTrial(0, 37);
        }catch (IllegalArgumentException e){
            t = true;
            System.out.println(e.getMessage());
        }

        assert(t);

    }
}
