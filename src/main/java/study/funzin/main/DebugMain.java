package study.funzin.main;

/**
 * Created by jin on 16. 12. 4.
 */
public class DebugMain {

    public static void main(String [] args){

        System.out.println("디버깅 시작");

        for (int i=0; i<10; i++){
            if(i%2==0){
                System.out.println("짝수");
            }else{
                System.out.println("홀수");
            }
        }

        System.out.println("디버깅 끝");

    }

}
