package study.funzin.blockingqueue;

import java.util.Date;
import java.util.concurrent.BlockingQueue;

/**
 * Created by JE on 2017-04-10.
 */
public class Producer implements Runnable{

    private BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run(){

        while (true){

            try {

                Thread.sleep(1000);

                Date d = new Date();
                String msg = "메시지" + d.toString();

//                System.out.println("Producer before size : " + queue.size());

                queue.put(msg);

                System.out.println("메시지를 생성합니다. [" + queue.size() + "]" + msg);

//                System.out.println("Producer after size : " + queue.size());

            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }

    }

}
