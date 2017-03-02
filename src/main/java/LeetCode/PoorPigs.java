package LeetCode;

public class PoorPigs {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return  buckets <= 1 ? 0 : (int)(Math.log(buckets - 1) / Math.log(minutesToTest/minutesToDie + 1)) + 1;
    }

    public int poorPigs1(int buckets, int minutesToDie, int minutesToTest) {

        int pigs = 0;

        while ((int) Math.pow(minutesToTest / minutesToDie + 1, pigs) < buckets) {
            pigs++;
        }

        return pigs;
    }
}
