package study.funzin.main2;


import study.funzin.handler.TailerListenerAdapter;

/**
 * Created by JE on 2016-12-29.
 */
public class ShowLinesListener2 extends TailerListenerAdapter {

    @Override
    public void handle(String line, long position, String fileName){
        if(fileName.equals("20170104-18") && position > 80){
            System.out.println(line);
            System.out.println(position);
            System.out.println(fileName);
        }
    }

}
