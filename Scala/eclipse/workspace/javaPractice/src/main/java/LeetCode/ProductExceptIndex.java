package LeetCode;

import java.util.Arrays;

public class ProductExceptIndex {

    public static int[] product(int[] nums){

        int[] products = new int[nums.length];

        int productTillIndex = 1;

        for (int i = 0; i < nums.length; i++) {

            products[i] = productTillIndex;
            productTillIndex *= nums[i];
        }

        productTillIndex = 1;

        for (int i = nums.length -1; i > -1; i--) {

            products[i] *= productTillIndex;
            productTillIndex *= nums[i];
        }

        return products;
    }

    public static void main(String[] args){

       System.out.print(Arrays.toString(product(new int[]{1, 2, 6, 5, 9, 10})));
    }
}
