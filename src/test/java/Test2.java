import java.nio.charset.Charset;
import java.text.DecimalFormat;

/**
 * Created by JE on 2016-10-20.
 */
public class Test2 {

    @org.junit.Test
    public void test(){

        byte [] test = {0x01, 0x02, 0x03, 0x04};

        byte [] test2 = {1, 2, 3, 4};

        for(byte a : test){
            System.out.println((byte)a);
            System.out.println(a);
            int b = a;
            System.out.println(b);
        }

        for(byte b : test2){
            System.out.println((byte)b);
        }

    }

}
