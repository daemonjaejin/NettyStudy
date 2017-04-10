package study.funzin.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by JE on 2017-04-10.
 */
public class Consumer implements Runnable{


    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run(){
        while (true){
            try {

                Thread.sleep(1000);

                String msg = queue.take();

                System.out.println("메시지를 꺼냅니다. : " + msg + "[" + queue.size() + "]");

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
