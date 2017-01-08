package study.funzin.main3;

import java.io.*;

/**
 * Created by jin on 17. 1. 5.
 */
public class FileHandlerMain {

    public static void main(String args[]){

        String filePath = "D:\\";
        String fileName = "test.txt";

        try {
            File file = new File(filePath + fileName);
            if(file.isFile()){

                long len = file.length();
                System.out.println("파일이다.");
                System.out.println("파일 길이 : " + len);

                FileReader fileReader = new FileReader(file);
                System.out.println(fileReader.ready());
                System.out.println(fileReader.markSupported());
                System.out.println(fileReader.getEncoding());

                fileReader.close();

                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream, "euc-kr"));

//                System.out.println(br.read());
//                System.out.println(br.readLine());
                StringBuilder sb = new StringBuilder();
                byte [] buffer = new byte[(int)file.length()];
                System.out.println();
                for (int i=0; i<buffer.length; i++){
                    int num = (int)buffer[i];
                    if(buffer[i]!=0){
                        sb.append((char)num);
                    }
                }
                System.out.println();
                System.out.println(sb.toString());
                String s;
                while((s = br.readLine()) != null){
//                    System.out.println(s);
                }



            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

}
