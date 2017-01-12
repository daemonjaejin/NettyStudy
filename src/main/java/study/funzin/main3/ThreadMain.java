package study.funzin.main3;

/**
 * Created by JE on 2017-01-11.
 */
public class ThreadMain {

    public static void main(String args[]){


        System.out.println("ttt1 : " + Thread.activeCount());



        try {

            System.out.println("ttt2 : " + Thread.activeCount());

            while(true){

                try {

                    Thread tr1 = new Thread();

                    tr1.start();

                    Thread.sleep(1000);

                    System.out.println(Thread.activeCount());

                    Thread.sleep(1000);

//                    Thread.currentThread().interrupt();

                }catch (Exception e1){
                    System.out.println(e1.getMessage());
                }

            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

}
