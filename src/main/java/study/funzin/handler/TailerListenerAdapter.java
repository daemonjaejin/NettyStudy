package study.funzin.handler;

import java.util.Date;

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

    public void handle(String line, long position, String fileName, boolean check, Date date) {
    }

    public void handle(Exception ex) {
    }

    public void endOfFileReached() {
    }

}
