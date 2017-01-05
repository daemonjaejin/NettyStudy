package study.funzin.main2;

import java.io.*;

/**
 * Created by JE on 2017-01-05.
 */
public class FileMain {

    public static void main(String args[]) throws  Exception{

        try {
            FileInputStream fis = new FileInputStream("D:\\source\\20170105-15");
            int i;
            int lineNumber = 0;
            while ((i = fis.read()) != -1) {
//                System.out.println(fis.available());
//                System.out.print((char) i);
                lineNumber += i;
            }
            fis.close();
//            System.out.println(lineNumber);
//            System.out.println("lineNum : " + lineNum);
        }catch (Exception e){
            e.printStackTrace();
        }

        String url = "D:\\source\\20170105-15";
        // 1.파이 사이즈 알아내기
        File f = new File(url);

        int fileSize = (int) f.length();
//        int fileSize = 200;
        System.out.println("파일의 사이즈:" + fileSize);

        // 2.파일 사이즈에 해당하는 배열 만들기
        byte[] bs = new byte[fileSize];

        // 3.스트림을 이용해서 배열에 데이터 채우기
        FileInputStream fis = new FileInputStream(url);
        int pos = 0;
        int size = 10;
        int temp;
        char c;
        while ((size = fis.read(bs, pos, size)) > 0) {

            pos += size;
            temp = bs.length - pos;
            if (temp < 10) {
                size = temp;
            }
            if(pos>20){



//                System.out.println("oos : " + pos);
            }


            // for each byte in buffer

//            for(byte b:bs)
//            {
//                // converts byte to character
//                c=(char)b;
//
//                // if byte is null
////                if(b==0)
////                    c='-';
//                // prints
//                if(b!=0) {
//                    System.out.println("Char read from buffer b: "+c);
//                }
//            }



        }

        StringBuilder sb = new StringBuilder();

        for (int i= 20; i<bs.length; i++){
            int nr = (int)bs[i];
            if(bs[i]!=0){
//                System.out.print((char)nr);
                sb.append((char)nr);
            }

        }

        System.out.println(sb.toString());

        System.out.println("length : " + sb.length());

        String [] str = sb.toString().split("\\n");

        System.out.println("str : " + str.length);

        fis.close();

        System.out.println("sb.length() : " + sb.length());

        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
            System.out.println(str[i].length());
        }

        System.out.println("읽은 바이트 수:" + pos);

        // 4.배열을 통째로 파일에 기록하기
//        FileOutputStream fos = new FileOutputStream("D:\\source\\20170105-15");
//        fos.write(b);
//        fos.close();


    }

}

