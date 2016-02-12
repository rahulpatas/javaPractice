package GeekCoder;

public class BestStock {

    public static void getMostProfit(double[] stockPrice){

        double min = stockPrice[0], buy = 0.0, maxDiff = 0.0, sell = 0.0;

        for(double current : stockPrice){
            if(current < min){
                min = current;
            }else {
                if(maxDiff < current - min){
                    maxDiff = current - min;
                    buy = min;
                    sell = current;
                }
            }
        }

        System.out.println("Buy Stock when price : " + buy + " and sell when price :" + sell + " profit: " + maxDiff);

    }

    public static void main(String[] args){
        getMostProfit( new double[]{10, 11, 10, 10, 10});
    }
}
