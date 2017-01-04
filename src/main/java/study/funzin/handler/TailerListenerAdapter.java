package study.funzin.handler;

/**
 * Created by JE on 2017-01-04.
 */
public class TailerListenerAdapter implements TailerListener{

    public void init(Tailer tailer) {
    }

    public void fileNotFound() {
    }

    public void fileRotated() {
    }

    public void handle(String line, long position, String fileName) {
    }

    public void handle(Exception ex) {
    }

    public void endOfFileReached() {
    }

}
