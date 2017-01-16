package study.funzin.main4;

/**
 * Created by JE on 2017-01-16.
 */
public class Thread2Main extends Thread{

    int seq;

    public Thread2Main(int seq){
        this.seq = seq;
    }

    public void run(){
        System.out.println(this.seq + " thread start.");
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(this.seq + " thread end.");
    }

    public static void main(String args[]){

        for(int i=0; i<10; i++){
            Thread t = new Thread2Main(i);
            t.start();
        }

    }

}
