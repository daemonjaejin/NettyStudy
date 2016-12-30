package study.funzin.main2;

import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListener;
import study.funzin.util.DateUtil;

import java.io.File;
import java.util.Date;

/**
 * Created by JE on 2016-12-29.
 */
public class ShowLinesListener{

    private static TailerListener listener;
    private static Tailer tailer;

    private final static String DATE_TYPE = "yyyyMMdd-HHmm";

    public static void main(String args[]){

        String compare = "";

        try {

            Thread thread = new Thread();


            while (true){
                String filePath = "D:\\source\\";
                String fileName = DateUtil.formatDate(new Date(), DATE_TYPE);
                System.out.println(compare);
                System.out.println(fileName);
                if(!compare.equals(fileName)){
                    File file = new File(filePath + fileName);
                    if(!file.isFile()) file.createNewFile();
                    goTail(filePath + fileName);
                    compare = fileName;
                }
                Thread.sleep(1000);

                thread.start();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void goTail(String filePath) throws Exception{

        System.out.println(filePath);
        if(tailer!=null) tailer.stop();
        listener = new ShowLinesListener2();
        File file = new File(filePath);
        tailer = new Tailer(file, listener, 0, true, false);
        tailer.run();

        System.out.println("goTail !!!");

        try{
            Thread.sleep(0);
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }

    }

}
