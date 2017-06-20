package study.funzin.main7;

import java.io.*;

/**
 * Created by JE on 2017-06-16.
 */
public class Page57 {

    public static void main(String [] args){



        OutputStream w = new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
        };

        char [] network = {'N', 'e', 't', 'w', 'o', 'r', 'k'};



        for (int i=0; i<network.length; i++){

        }

    }

    public static String getMacCyrillicString(InputStream in) throws IOException{

        InputStreamReader r = new InputStreamReader(in, "MacCyrillic");
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = r.read()) != -1){
            sb.append((char)c);
        }

        return sb.toString();
    }

    public static String getMacCyrillicString2(InputStream in) throws IOException{

        Reader r = new InputStreamReader(in, "MacCyrillic");
        r = new BufferedReader(r, 1024);

        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = r.read()) != -1){
            sb.append((char)c);
        }

        return sb.toString();
    }

}
