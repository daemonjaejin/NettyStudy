package study.funzin.main3;

import java.io.File;

/**
 * Created by JE on 2017-01-16.
 */
public class FileSizeMain {

    public static void main(String args[]){

        try {

            File file = new File("D:\\usr\\local\\gemsapi\\build\\deploy\\ALARM.201701");
            System.out.println("length : " + file.length());

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
