
public class FooBar {

    public static void fooBar(int n){
        for (int i = 1; i <= n ; i++) {
            String a = "";
            if(i%3 == 0){
              a += "foo";
            }
            if(i%5 == 0){
                a += "Bar";
            }
            if(i%3 > 0 && i%5>0){
                a += i;
            }
            System.out.println(a);
        }
    }

    public static void main(String[] args){
        fooBar(75);
    }
}
