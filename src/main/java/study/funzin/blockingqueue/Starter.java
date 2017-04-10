package study.funzin.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by JE on 2017-04-10.
 */
public class Starter {

    public static void main(String [] args){

        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(50);

//        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        Thread p = new Thread(new Producer(queue));
        Thread c = new Thread(new Consumer(queue));

        p.start();
        c.start();

    }

}
