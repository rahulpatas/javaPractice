package LeetCode;

public class CondensedInputCount {

    public static int getCondensedInputCount(final long[] inputValues, final long[] outputValues){

        int inputLen = inputValues.length;

        if(inputLen == 0 || outputValues.length == 0){
            return 0;
        }

        int globalMax = 0;

        for (long outputVal: outputValues) {

            int localMin = inputLen;

            for (int i = 0; i < localMin; i++) {
                localMin = Integer.min(sumValue(i, localMin, outputVal, inputValues), localMin);
            }
            globalMax = Integer.max(localMin, globalMax);
        }

        return globalMax + 1;
    }

    private static int sumValue(int index, int maxIndex, long val, long[] inputValues){

        int minVal = maxIndex;

        for (int i = index; i < minVal; i++) {

            if(inputValues[i] == val){
                minVal = i;
                break;
            } else if(inputValues[i] < val){
                minVal = Integer.min(sumValue(i + 1, maxIndex, val - inputValues[i], inputValues), minVal);
            }
        }

        return minVal;
    }

    public static void main(String[] args){
        long[] inputValues = new long[]{3,8,1,5,1,6,5,3,4,15,2};
        long[] outputValues = new long[]{7,16,25,40};

        System.out.println(getCondensedInputCount(inputValues, outputValues));
    }
}
