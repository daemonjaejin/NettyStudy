package study.funzin.main4;

import java.util.ArrayList;

/**
 * Created by JE on 2017-01-16.
 */
public class Thread3Main extends Thread{

    int seq;

    public Thread3Main(int seq){
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

        ArrayList<Thread> threads = new ArrayList<Thread>();

        for(int i=0; i<10; i++){
            Thread t = new Thread3Main(i);
            t.start();
            threads.add(t);
        }

        for (int i = 0; i < threads.size(); i++) {
            Thread t = threads.get(i);
            try {
                t.join();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        System.out.println("main end.");
    }

}
