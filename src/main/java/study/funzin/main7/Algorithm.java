package study.funzin.main7;

/**
 * Created by JE on 2017-06-20.
 */
public class Algorithm {

    public static void main(String [] args){

        Algorithm1();

        Algorithm2();

        Algorithm3();

        Algorithm4();

    }

    public static void Algorithm1(){

        int [] arr = {31, -41, 59, 26, -53, 58, 97, -93, -23, 84};

        int maxSoFar = 0;
        int maxEndingHere = 0;

        for (int i = 0; i < arr.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + arr[i], 0);
            System.out.println();
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
            System.out.println();
        }

        System.out.println("maxSoFar : " + maxSoFar);

    }

    public static void Algorithm2(){

    }

    public static void Algorithm3(){

    }

    public static void Algorithm4(){

    }

}
