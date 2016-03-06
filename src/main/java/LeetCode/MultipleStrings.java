package LeetCode;


public class MultipleStrings {

    public static java.lang.String multiply(String num1, String num2) {


        int n = num1.length();
        int n2 = num2.length();

        int[] results = new int[n + n2];

        for (int i = n - 1; i >= 0; i--) {


            for (int j = n2 - 1; j >= 0; j--) {

                int a = Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j))
                        + results[i + j + 1];

                results[i + j + 1] = (a % 10);
                results[i + j] += a / 10;

            }
        }

        StringBuilder sb = new StringBuilder();

        for(int p : results) {
            if(!(sb.length() == 0 && p == 0)){
                sb.append(p);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(multiply("1", "1"));
    }

}
