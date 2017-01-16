package study.funzin.main4;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by JE on 2017-01-16.
 */
public class ExecutorMain {

    public static void main(String [] args){

        try {

            ExecutorService service = Executors.newSingleThreadExecutor();

            ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

            int cnt = 0;

            while(cnt < 10){
                Thread t1 = new Thread();
                cachedThreadPool.execute(t1);
                cnt++;
            }

            List<Runnable> list = cachedThreadPool.shutdownNow();

            System.out.println("size : " + list.size());

            for (Runnable runnable : list){
                runnable.run();
                System.out.println("runnable : " + runnable.toString());
            }

            Thread t = new Thread();

            service.execute(t);

            service.shutdown();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
