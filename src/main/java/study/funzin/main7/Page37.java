package study.funzin.main7;

import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by JE on 2017-06-14.
 */
public class Page37 {

    public static void main(String [] args){

        OutputStream out = null;

        try {

            out = new FileOutputStream("D:\\text.txt");
            out.write('\n');
            out.flush();
            out.close();

        }catch (IOException ioe){
            ExceptionUtils.getStackTrace(ioe);
        }finally {
            if(out != null){
                try {
                    out.close();
                }catch (IOException ioe2){
                    ExceptionUtils.getStackTrace(ioe2);
                }
            }
        }

        try (OutputStream out2 = new FileOutputStream("D:\\text.txt")){

            out.write('\n');
            out.flush();
            out.close();

        }catch (IOException ex){
            ExceptionUtils.getStackTrace(ex);
        }

    }

}
