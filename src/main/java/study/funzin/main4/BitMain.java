package study.funzin.main4;

/**
 * Created by JE on 2017-01-16.
 */
public class BitMain {

    public static void main(String [] args){

        int a = 170, b = 245;
        // 논리곱(and), 각 비트를 비교하여 양쪽 모두 1 이면 1, 아니면 0을 반환한다.
        System.out.println(a&b);
        // 논리합(or), 각 비트를 비교하여 어느 한쪽이 1이면 1, 아니면 0을 반환한다.
        System.out.println(a|b);
        // 베타적 논리합(xor), 각 비트를 비교하여 한쪽이 1이고 다른 한쪽이 0이면 1을, 아니면 0을 반환한다.
        System.out.println(a^b);
        // 1의 보수 표현(not), 각 비트를 반전시킨 값을 반환한다.
        System.out.println(~a);
        System.out.println(~b);
        // 왼쪽 시프트 연산자
        System.out.println(178<<2);
        // 오른쪽 시프트 연산자
        System.out.println(178>>2);
        // 논리 오른쪽 시프트 연산자
        System.out.println(178>>>2);

        String aa = "", bb = "";
        while(a>0){
            aa += a%2;
            System.out.println("aa : " + aa);
            a = a/2;
            System.out.println("a : " + a);
        }
        if(aa.length()<9){
            for (int i = aa.length(); i < 9; i++) {
                aa = "0"+aa;
            }
        }
        System.out.println(aa);
    }

}
