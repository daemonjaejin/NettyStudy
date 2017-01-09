package study.funzin.main3;

import study.funzin.util.DateUtil;

import java.util.Date;

/**
 * Created by JE on 2017-01-05.
 */
public class DateCalMain {

    private static final String DATE_FORMAT = "yyyyMM";

    public static void main(String [] args){

//        StringBuilder sb = new StringBuilder();
//
//        System.out.println(sb.length());
//
//        for (int i = 0; i < 10; i++) {
//            if(i<5){
//                continue;
//            }
//            System.out.println("test"+(i+1));
//        }

        for (int i = 2; i > 0; i--) {
            String dateStr = DateUtil.formatDate(DateUtil.dayAdd(new Date(), (i * -1)), DATE_FORMAT);
            System.out.println("dateStr : " + dateStr);
        }

    }

}
