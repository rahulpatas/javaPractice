package LeetCode;

public class FindMedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int l1 = nums1.length;
        int l2 = nums2.length;

        if (l1 < l2) {
           return findMedianSortedArrays(nums2, nums1);
        }

        if (l2 == 0) {
            return (nums1[(l1 -1)/2] + nums1[l1/2])/2.0;
        }

        int lo = 0;
        int high = 2 * l2;

        while (lo <= high) {
            int mid2 = (lo + high) / 2;
            int mid1 = l1 + l2 - mid2;

            int left1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[(mid1 - 1) /2];
            int right1 = mid1 == l1 * 2 ? Integer.MAX_VALUE : nums1[mid1 / 2];
            int left2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[(mid2 - 1) /2];
            int right2 = mid2 == l2 * 2 ? Integer.MAX_VALUE : nums2[mid2 / 2];

            if (left1 > right2) {
                lo = mid2 + 1;
            } else if (left2 > right1) {
                high = mid2 - 1;
            } else {
                return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] nums1 = {1};
        int[] nums2 = {2,3};
        findMedianSortedArrays(nums1, nums2);
    }
}
