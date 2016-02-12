package LeetCode;

import java.util.*;

public class PhoneBill {

    public static int solution(String S) {
        // write your code in Java SE 8

        int totalAmount = 0;
        Map<Integer, Integer> totalCallsByPN = new HashMap<>();
        Map<Integer, Integer> totalAmountByPN = new HashMap<>();

        Scanner scanner = new Scanner(S);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String[] timeNum = line.split(",");
            String[] time = timeNum[0].split(":");
            String[] num = timeNum[1].split("-");

            int callTime = Integer.valueOf(time[0]) * 3600 + Integer.valueOf(time[1]) * 60 + Integer.valueOf(time[2]);
            int amount = getAmountForTime(callTime);

            int phNum = Integer.valueOf(num[0]) * 1000000 + Integer.valueOf(num[1]) * 1000 + Integer.valueOf(num[2]);

            totalAmount += amount;

            totalCallsByPN.put(phNum, totalCallsByPN.getOrDefault(phNum, 0) + callTime);
            totalAmountByPN.put(phNum, totalAmountByPN.getOrDefault(phNum, 0) + amount);
        }
        scanner.close();

        int maxPhNum = 0, maxCallTime = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> numTotalTime : totalCallsByPN.entrySet()){

            if(numTotalTime.getValue() > maxCallTime){
                maxCallTime = numTotalTime.getValue();
                maxPhNum = numTotalTime.getKey();
            }else if(numTotalTime.getValue() == maxCallTime){
                maxPhNum = maxPhNum > numTotalTime.getKey() ? numTotalTime.getKey() : maxPhNum;
            }
        }

        return totalAmount - totalAmountByPN.get(maxPhNum);
    }

    private static int getAmountForTime(int time){

        if(time < 5 * 60){
            return time * 3;
        }else {

            int mins = time % 60 == 0 ? time / 60 : time / 60  + 1;
            return mins * 150;
        }
    }

    public static void main(String[]args){
        System.out.println(solution( "00:01:07,400-234-090\n" +
                "00:05:01,701-080-080\n" +
                "00:05:00,400-234-090"));
    }
}
