package GeekCoder;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args){
        int[] a = {2, 6, 3, 5, 10};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int[] a){
        mergeSort(a, 0, a.length-1);
    }

    private static void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, left, center);
            mergeSort(a, center + 1, right);
            merge(a, left, right);
        }
    }

    private static void merge(int[] a, int left, int right){

        int center = (left + right) / 2;
        int[] l =Arrays.copyOfRange(a, left, center+1);
        int[] r = Arrays.copyOfRange(a, center+1, right+1);

        int i =0, j=0, k = left;

        while (i <= (center - left) && j<(right - center)){

            if(l[i] < r[j]){
                a[k] = l[i];
                i++;
            }else {
                a[k] = r[j];
                j++;
            }
            k++;
        }
        while (i <= (center - left)){
            a[k++] = l[i++];
        }
        while (j<(right - center)){
            a[k++] =r[j++];
        }

    }
}
