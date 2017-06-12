import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.UnsupportedEncodingException;

/**
 * Created by JE on 2016-10-20.
 */
public class CharacterSet {

    @org.junit.Test
    public void test() {

        String d = "안녕 2jae眞"; // 자바는 내부 문자열을 모두 유니코드 처리한다.

        try {

            byte [] test = d.getBytes();

            // 유니코드 문자열을 UTF-8 케릭터 바이트 배열로 변환하어 반환
            byte [] utf8 = d.getBytes("UTF-8");

            // 유니코드 문자열을 EUC-KR 케릭터 바이트 배열로 변환하여 반환
            byte [] euckr = d.getBytes("EUC-KR");

            // 당연히 다른 바이트 배열이므로 사이즈가 다르다.
            System.out.println("byte length > " + utf8.length); // byte length > 14
            System.out.println("byte length > " + euckr.length); // byte length > 11

            // 실수 코드
            // UTF-8 케릭터 셋으로 배열된 바이트 배열을 EUC-KR로 해석할 수 없다.
            System.out.println(new String(utf8, "EUC-KR"));

            // UTF-8 케릭터 셋으로 배열된 바이트 배열을 UTF-8로 해석할 수 있다.
            System.out.println(new String(utf8, "UTF-8"));

            // EUC-KR 케릭터 셋으로 배열된 바이트 배열을 EUC-KR로 해석할 수 있다.
            System.out.println(new String(euckr, "EUC-KR"));

            // EUC-KR 케릭터 셋으로 배열된 바이트 배열을 UTF-8로 해석할 수 없다.
            System.out.println(new String(euckr, "UTF-8"));

            // default -> UTF-8
            System.out.println(new String(test, "UTF-8"));

            // default -> EUC-KR 해석할 수 없다.
            System.out.println(new String(test, "EUC-KR"));


        }catch (UnsupportedEncodingException uee){
            ExceptionUtils.getStackTrace(uee);
        }

    }

}
