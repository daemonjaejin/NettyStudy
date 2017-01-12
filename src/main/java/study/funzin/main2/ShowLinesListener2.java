package study.funzin.main2;


import study.funzin.handler.TailerListenerAdapter;
import study.funzin.util.DateUtil;

import java.util.Date;

/**
 * Created by JE on 2016-12-29.
 */
public class ShowLinesListener2 extends TailerListenerAdapter {

    @Override
    public void handle(String line, long position, String fileName, boolean check, Date date){
        System.out.println("line : " + line);
        System.out.println("position : " + position);
        System.out.println("check : " + check);
        System.out.println("date : " + DateUtil.formatDate(date, "yyyyMMdd-HH:mm:ss.SSS"));
        if(fileName.equals("20170104-18") && position > 80){
            System.out.println(line);
            System.out.println(position);
            System.out.println(fileName);
        }
    }

}
