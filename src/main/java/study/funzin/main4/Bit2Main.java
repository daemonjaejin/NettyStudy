package study.funzin.main4;

/**
 * Created by JE on 2017-01-16.
 */
public class Bit2Main {

    public static void main(String args[]){
        byte a = 10;
        byte b = 9;
        byte c = 1;
        System.out.println((a&b));
        System.out.println((a|b));
        System.out.println((a^b));
        System.out.println((~a));
        System.out.println((a<<c));
        System.out.println((a>>c));
        System.out.println((a>>>c));
        System.out.println((-1*a>>c));
    }

}
