import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.xmlbeans.impl.util.Base64;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.DecimalFormat;

/**
 * Created by JE on 2016-10-20.
 */
public class StringByteString {

    @org.junit.Test
    public void test(){

        String value = "funzingemsgogo";

        System.out.println(value);

        System.out.println(value.getBytes());

        byte[] encoded = Base64.encode(value.getBytes());

        System.out.println(encoded);

        System.out.println(String.valueOf(encoded));

        System.out.println(new String(encoded));

        System.out.println("=========================================================================================================");

        String target = "funzingemsgogo";

        try {

            byte [] targetBytes = target.getBytes("UTF-8");

            // Base64 인코딩
            java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();

            // Encoder#encode(byte [] src) :: 바이트배열로 변환
            byte [] encodedBytes = encoder.encode(targetBytes);
            System.out.println(encodedBytes);

            // Encoder#encodeToString(byte[] src) :: 문자열로 변환
            String encodedString = encoder.encodeToString(targetBytes);
            System.out.println(encodedString);

            // Base64 디코딩
            java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();

            // Decoder#decode(bytes[] src)
            byte[] decodeBytes1 = decoder.decode(encodedBytes);
            byte[] decodeBytes2 = decoder.decode(encodedString);

            // 디코딩한 문자열을 표시
            String decodedString = new String(decodeBytes1, "UTF-8");
            System.out.println(decodedString);

            System.out.println(new String(decodeBytes2, "UTF-8"));


        }catch (UnsupportedEncodingException uee){
            ExceptionUtils.getStackTrace(uee);
        }





    }

}
