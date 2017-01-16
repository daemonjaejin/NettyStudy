package study.funzin.main4;

import java.util.ArrayList;

/**
 * Created by JE on 2017-01-16.
 */
public class Thread5Main implements Runnable{

    int seq;
    static Thread thread;

    @Override
    public void run(){
        int max = 2;
        while (true){
            try {
                System.out.println("기지국 넘버 : " + this.seq);
                max--;
                if(max < 0){
                    thread.interrupt();
                    break;
                }
                thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        System.out.println(seq + " : " + thread.isInterrupted());

    }

    public Thread5Main(int seq){
        this.seq = seq;
    }

    public synchronized static void main(String [] args){

        ArrayList<Thread> list = new ArrayList<Thread>();

        try {

            for (int i = 0; i <10 ; i++) {
                thread = new Thread(new Thread5Main(i));
//                thread.start();
                list.add(thread);
            }

            for (int i = 0; i < list.size(); i++) {

//                synchronized (list){
//                    list.get(i).start();
//                    list.get(i).join();
//                }

                list.get(i).start();
                list.get(i).join();

//                if(list.get(i).isAlive()){
//                    System.out.println("i :" + i);
//                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
