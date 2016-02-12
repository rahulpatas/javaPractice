package LeetCode;

public class ReverseInt {

    public static int reverse(int x) {
        int a = x < 0? -1: 1;

        String b = String.valueOf(x*a);
        String result = "";

        for (int i = 0; i < b.length(); i++) {

            result += b.charAt(b.length() - i - 1);

        }
        try {
            return Integer.valueOf(result) * a;

        }catch(NumberFormatException e)
        {
            return 0;
        }
    }

    public static int myAtoi(String str) {

        if(str==null)return 0;
        if(str.length()==0)return 0;
        int result = 0, temp = 10;
        boolean positive = true;
        int i = 0;

        for(; i < str.length();i++){
            char s = str.charAt(i);
            if(s==' ')continue;
            if(s=='-'){positive = false; i++; break;}
            if(s=='+'){i++; break;}
            if(s>='0'&&s<='9'){break;}
            else return 0;
        }
        for(int j = i;j<str.length();j++){

            char s = str.charAt(j);
            if(s>'9'||s<'0') break;

            if(result  >=(Integer.MAX_VALUE-(s -'0'))/10){
                if(positive){
                    return Integer.MAX_VALUE;
                }else{
                    if(result  == (Integer.MAX_VALUE - (s -'0'))/10)return 0-Integer.MAX_VALUE;
                    else return Integer.MIN_VALUE;
                }

            }
            result = result * temp + (s -'0');

        }
        if(positive)return result;
        else return 0-result;
    }

    public static void main(String[] args){
        System.out.println(reverse(1534236469));
        System.out.println(myAtoi("-2147483647"));

    }
}
