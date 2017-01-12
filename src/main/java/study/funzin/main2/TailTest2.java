package study.funzin.main2;

import study.funzin.handler.Tailer;
import study.funzin.handler.TailerListener;
import study.funzin.util.DateUtil;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;

/**
 * Created by JE on 2016-12-30.
 */
public class TailTest2 {

    public static final String DATE_TYPE = "yyyyMMdd-HHmm";

    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

//    public static TailerListener listener;
//    public static Tailer tailer;

    public static boolean allCheck = true;

    public static boolean stopCheck = false;

    public static void main(String args[]){

        TailerListener listener;
        Tailer tailer = null;

        try {

            String filePath = "D:\\source\\";
//            filePath = "D:\\data\\oss\\skt\\fm\\";

            TailTest2 tailTest = new TailTest2();

            while (true) {

                String fileName = DateUtil.formatDate(new Date(), DATE_TYPE);
//                File file = new File(filePath+"ALARM."+fileName);
                File file = new File(filePath+fileName);

                if(file.isFile()){

                    System.out.println(filePath+fileName);
                    listener = new ShowLinesListener2();
                    Thread.sleep(5000);
                    tailer = Tailer.create(file, listener);
                    Tailer.check = false;
                    Tailer.date = new Date();
                    while (allCheck){
                        if(!DateUtil.formatDate(new Date(), DATE_TYPE).equals(fileName)){
                            System.out.println("fileName : " + fileName);
                            System.out.println("DateUtil.formatDate : " + DateUtil.formatDate(new Date(), DATE_TYPE));
                            allCheck = false;
                            stopCheck = true;
//                            tailTest.newFile(filePath);
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

    public void newFile(String path) throws Exception{
        File realFile = new File(path+"real");
        FileWriter fw = new FileWriter(realFile, false);
        fw.write("fileName=" + "ttt");
        fw.write(LINE_SEPARATOR);
        fw.write("position=" + 333);
        fw.close();
    }



}
