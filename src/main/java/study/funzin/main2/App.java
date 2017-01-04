package study.funzin.main2;

import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListenerAdapter;

import java.io.File;

/**
 * Created by JE on 2016-12-29.
 */
public class App {

    private static final int SLEEP = 500;

    public static void main(String[] args) throws Exception {
        App app = new App();
        app.run();
    }

    private void run() throws InterruptedException {
        MyListener listener = new MyListener();
        Tailer tailer = Tailer.create(new File("test.txt"), listener, SLEEP);
        while (true) {
            tailer.run();
            Thread.sleep(SLEEP);
        }
    }

    public class MyListener extends TailerListenerAdapter {

        @Override
        public void handle(String line) {
            System.out.println(line);
        }

    }

}
