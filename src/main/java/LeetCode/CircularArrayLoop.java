package LeetCode;

public class CircularArrayLoop {

    public boolean circularArrayLoop(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                continue;
            }

            int j = i;
            int k = getIndex(i, nums);
            int val = nums[i];

            while (val * nums[k] > 0 && nums[getIndex(k, nums)] * val > 0) {

                if (j == k) {

                    if (j == getIndex(j, nums)) {
                        break;
                    }

                    return true;
                }

                j = getIndex(j, nums);
                k = getIndex(getIndex(k, nums), nums);
            }

            j = i;

            while (nums[j] * val > 0) {
                int next = getIndex(j, nums);
                nums[j] = 0;
                j = next;
            }
        }

        return false;
    }

    private int getIndex(int i, int[] nums) {
        int next = nums[i];
        int len = nums.length;

        return i + next >= 0 ? (i + next) % len : len + (i + next) % len;
    }
}
