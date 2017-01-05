package study.funzin.main2;

import study.funzin.handler.Tailer;
import study.funzin.handler.TailerListener;
import study.funzin.util.DateUtil;

import java.io.File;
import java.util.Date;

/**
 * Created by JE on 2016-12-30.
 */
public class TailTest {

    public static final String DATE_TYPE = "yyyyMMdd-HH";

    public static TailerListener listener;
    public static Tailer tailer;

    public static boolean allCheck = true;

    public static boolean stopCheck = false;

    public static void main(String args[]){

        try {

            String filePath = "D:\\source\\";
//            filePath = "D:\\data\\oss\\skt\\fm\\";

            while (true) {

                String fileName = DateUtil.formatDate(new Date(), DATE_TYPE);
//                File file = new File(filePath+"ALARM."+fileName);
                File file = new File(filePath+fileName);

                if(file.isFile()){

                    System.out.println(filePath+fileName);
                    listener = new ShowLinesListener2();
                    tailer = Tailer.create(file, listener);
                    while (allCheck){
                        if(!DateUtil.formatDate(new Date(), DATE_TYPE).equals(fileName)){
                            System.out.println("fileName : " + fileName);
                            System.out.println("DateUtil.formatDate : " + DateUtil.formatDate(new Date(), DATE_TYPE));
                            allCheck = false;
                            stopCheck = true;
                        }
                    }

                }

                Thread.sleep(1000);

                if(stopCheck){
                    allCheck = true;
                    stopCheck = false;
                    tailer.stop();
                }

            }

        } catch (Exception e) {
            System.out.println(e);
        }


    }



}
