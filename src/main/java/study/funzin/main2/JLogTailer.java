package study.funzin.main2;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * Created by JE on 2016-12-29.
 */
public class JLogTailer {

    public static void main(String args[]){

        try {

            String filePath = "D:\\test.txt";
            File file = new File(filePath);
            RandomAccessFile raf = new RandomAccessFile(file, "r");

            while (true){

                raf.seek(0);
                String line = null;
                while ((line = raf.readLine()) != null){
                    System.out.println(line);
                }
//                Long longs = raf.getFilePointer();
//                System.out.println(longs);
//                raf.close();
                Thread.sleep(100);
            }



        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
