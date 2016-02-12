public class binSearchWhile {

    public static int binSearch(int a[], int value){

        int l = 0;
        int r = a.length -1;


        while (r >= l ){

            int mid = l + (r - l) / 2;

            if(a[mid] == value){
                return mid;
            }else if(a[mid] > value){
                r = mid -1;
            }else {
                l = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int a[] = {2, 3, 4, 8, 9, 10};
        int x = 10;
        System.out.println(binSearch(a, x));
    }
}
