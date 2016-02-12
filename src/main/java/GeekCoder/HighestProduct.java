package GeekCoder;

public class HighestProduct {

    public static int highestPro(int[] nums){
        int h3, h2, l2, h1, l1;

        h1 = Math.max(nums[0], nums[1]);
        l1 = Math.min(nums[0], nums[1]);

        h2 = l2= nums[0] * nums[1];

        h3 = nums[0] * nums[1] * nums[2];

        for (int i = 2; i < nums.length ; i++) {

            int current = nums[i];

            h3 = Math.max(h3, Math.max(h2 * current, l2* current));

            h2 = Math.max(h2, Math.max(h1 * current, l1 * current));
            l2 = Math.min(l2, Math.min(l1 * current, h1 * current));

            h1 = Math.max(h1, current);
            l1 = Math.min(l1, current);
        }
        return h3;
    }

    public static void main(String[] args){
        System.out.print(highestPro(new int[]{-100, 2, 6, -5, 9}));
    }
}
