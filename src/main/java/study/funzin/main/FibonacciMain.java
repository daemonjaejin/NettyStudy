package study.funzin.main;

/**
 * Created by jin on 16. 12. 4.
 */
public class FibonacciMain {

    public static void main(String [] args){

        int a1 = 1;
        int a2 = 1;
        int a3;

        for (int i=1; i<=8; i++){
            a3 = a1+a2;
//            System.out.println(a3);
            a1 = a2;
            a2 = a3;
        }

        int input = 8;

        for (int i=1; i<=input; i++){
            System.out.println("end : " + fibo(i, i));
        }

    }

    public static int fibo(int n, int number){
        if(n <= 1){
            System.out.println("last : " + number + " : " + n);
            return n;
        }else{
            System.out.println(number + " : " + fibo(n-2, number));
            System.out.println(number + " : " + fibo(n-1, number));
            return fibo(n-2, number) + fibo(n-1, number);
        }
    }

}
