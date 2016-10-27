package LeetCode;

public class FractionToDecimal {

    public String fractionToDecimal(int numerator, int denominator) {

        if (denominator == 1) {
            return String.valueOf(numerator);
        }

        String fulVal = String.valueOf(numerator/denominator);
        String[] split = fulVal.split(".");
        String finalVal = split[0];

        if (split.length == 2) {

            String decimal = split[1];

            char starting = decimal.charAt(0);

            for (int i = 1; i < decimal.length(); i++) {

                while (i < decimal.length() && decimal.charAt(i) != starting) {
                    i++;
                }
            }

        }

        return finalVal;
    }
}
