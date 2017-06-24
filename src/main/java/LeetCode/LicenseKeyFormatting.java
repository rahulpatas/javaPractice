package LeetCode;

public class LicenseKeyFormatting {

    public static String licenseKeyFormatting(String S, int K) {

        S = S.replaceAll("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder(S);

        int i = sb.length() - K;

        while (i > 0) {
            sb.insert(i, '-');
            i = i - K;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        licenseKeyFormatting("2-4A0r7-4k", 4);
    }
}
