package study.funzin.main7;

import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by JE on 2017-06-15.
 */
public class Page40 {

    public static void main(String [] args){

//        byte [] input = new byte[10];

//        byte [] input = new byte[1024];

        InputStream in = new InputStream() {
            @Override
            public int read() throws IOException {
                return 0;
            }
        };

        try {

            int byteAvailable = in.available();
            byte [] input2 = new byte[byteAvailable];
            int bytesRead2 = in.read(input2, 0, byteAvailable);

//            int byteRead = in.read(input);

            int bytesRead    = 0;
            int byteToRead  = 1024;

            byte [] input = new byte[byteToRead];

            while (bytesRead < byteToRead){
                int result = in.read(input, bytesRead, byteToRead - bytesRead);
                System.out.println("result : " + result);
                if(result == -1) break;
                bytesRead += result;
            }

            for (int i = 0; i < input.length; i++) {
                int b = in.read();
                if(b == -1) break;
                input[i] = (byte)b;
                in.markSupported();
                in.mark(10);
            }

        }catch (IOException ioe){
            ExceptionUtils.getStackTrace(ioe);
        }



    }

}
