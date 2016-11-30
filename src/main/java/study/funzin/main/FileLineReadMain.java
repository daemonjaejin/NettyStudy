package study.funzin.main;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;

/**
 * Created by JE on 2016-11-30.
 */
public class FileLineReadMain {

    public static void main(String [] args){

        try {

            File file = new File("D:\\data\\oss\\skt\\fm\\20161130\\ALARM.1627.csv");
            if(file.isFile()){
                LineNumberReader lnr = new LineNumberReader(new FileReader(file));
                System.out.println(lnr.getLineNumber());
                lnr.skip(Long.MAX_VALUE);
                System.out.println(lnr.getLineNumber());
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
