package study.funzin.main4;

/**
 * Created by JE on 2017-01-16.
 */
public class Thread1Main extends Thread{

    public void run(){
        System.out.println("thread run.");
    }

    public static void main(String [] args){

        Thread1Main main = new Thread1Main();

        try {
            int check = 0;
            while(true){
                main.run();
                Thread.sleep(1000);
                if(check % 10 == 0){
                    System.out.println("cnt : " + Thread.activeCount());
                }
                check++;
                System.out.println("alive0 : " + main.isAlive());
                if(main.isAlive()) {
                    main.interrupt();
                    System.out.println("alive1 : " + main.isAlive());
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
