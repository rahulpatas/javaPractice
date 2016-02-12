public class binSearch {

    public static int binSearch(int a[], int l, int r, int value){

        if (r >= l){
            int mid = l + (r - l) / 2;

            if(a[mid] == value){
                return mid;
            }else if(a[mid] > value){
                return binSearch(a, l, mid - 1, value);
            }else {
                return binSearch(a, mid + 1, r, value);
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int a[] = {2, 3, 4, 8, 9, 10};
        int x = 10;
        System.out.print(binSearch(a, 0, a.length, x));
    }
}
