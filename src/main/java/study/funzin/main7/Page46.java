package study.funzin.main7;

import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.*;

/**
 * Created by JE on 2017-06-16.
 */
public class Page46 {

    public static void main(String [] args){

        try {

            FileInputStream         fin = new FileInputStream("D:\\test.txt");
            BufferedInputStream     bin = new BufferedInputStream(fin);

            InputStream in = new FileInputStream("D:\\test.txt");
            in = new BufferedInputStream(in);

            DataOutputStream dout = new DataOutputStream(new BufferedOutputStream(
                    new FileOutputStream("D:\\test.txt")
            ));

            DataOutputStream dout2 = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("D:\\test.txt")
                    )
            );

        }catch (FileNotFoundException fnfe){
            ExceptionUtils.getStackTrace(fnfe);
        }



    }

}
