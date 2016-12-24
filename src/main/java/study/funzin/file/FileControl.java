package study.funzin.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by jin on 16. 12. 25.
 */
public class FileControl {

    public FileControl(){

    }

    public static void main(String args[]){
        try {

//            FileWriter fileWriter =  new FileWriter(file);

//            System.out.println(fileReader.getEncoding());
//            System.out.println(fileReader.markSupported());
//            System.out.println(fileReader.ready());
//            System.out.println(fileReader.read());

//            System.out.println("ttt");

            long compare = 0l;
            try {
                while (true){
                    File file = new File("C:\\developer\\test\\test.log");
                    long fileSize = file.length();
                    if(fileSize > compare){
                        compare = fileSize;
                        System.out.println("사이즈 변경");
                        System.out.println(fileSize);
                        System.out.println(compare);
                    }
                    FileReader fileReader = new FileReader(file);
                    BufferedReader br = new BufferedReader(fileReader);
                    System.out.println(System.currentTimeMillis());
                    while(true) {
//                        System.out.println("ttt2");
                        String line = br.readLine();
                        if (line==null) break;
                        System.out.println(line);
                    }
                    Thread.sleep(1000);
                    br.close();
                    fileReader.close();
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }




        }catch (Exception e1){
            System.out.println(e1.getMessage());
        }

    }

}
