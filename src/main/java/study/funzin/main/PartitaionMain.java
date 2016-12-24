package study.funzin.main;

import study.funzin.util.DateUtil;

/**
 * Created by JE on 2016-12-01.
 */
public class PartitaionMain {

    public static void main(String [] args){

        String dropDate =  DateUtil.now().add(DateUtil.MONTH, -1).format("yyyyMM") + "01";
        System.out.println("date : " + dropDate);

    }

}
