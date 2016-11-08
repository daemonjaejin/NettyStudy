package study.funzin.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by JE on 2016-11-08.
 */
public class ExecutorMain {

    public static void main(String [] args){

        int ThreadCnt = 1000;

//        ExecutorService executor = Executors.newSingleThreadExecutor();
        ExecutorService executor = Executors.newFixedThreadPool(ThreadCnt);

        executor.execute(System.out::println);
//        executor.execute(doGo());
        executor.shutdown();

    }

    public static void doGo(){
        for (int i = 0; i < 10; i++) {
            System.out.println("테스트 중입니다.");
        }
    }

}
