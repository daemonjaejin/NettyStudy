package study.funzin.main2;

import org.apache.commons.io.input.TailerListenerAdapter;

/**
 * Created by JE on 2016-12-29.
 */
public class ShowLinesListener2 extends TailerListenerAdapter {

    @Override
    public void handle(String line){
        System.out.println(line);
    }

}
