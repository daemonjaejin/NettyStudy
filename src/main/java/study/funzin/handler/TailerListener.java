package study.funzin.handler;

import java.util.Date;

/**
 * Created by JE on 2017-01-04.
 */
public abstract interface TailerListener {

    public abstract void init(Tailer paramTailer);

    public abstract void fileNotFound();

    public abstract void fileRotated();

    public abstract void handle(String paramString, long position, String fileName, boolean check, Date date);

    public abstract void handle(Exception paramException);

}
