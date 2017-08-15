package study.funzin.main5;

import java.math.BigInteger;

/**
 * Created by JE on 2017-06-14.
 */
public class HexStringToByte {

    public static void main(String [] args){

        String abc = "Apple";

        System.out.println(stringToHex(abc));

        System.out.println(stringToHex0x(abc));

        String str = "1B343A7D";
        byte [] buf;

        // string -> byte[]
        buf = new BigInteger(str, 16).toByteArray();

        // byte[] -> string
        str = new BigInteger(buf).toString(16);

        System.out.println(str);

        String result = bytArrayToHex(buf);
        System.out.println(result);

    }

    static String bytArrayToHex(byte [] a){
        StringBuilder sb = new StringBuilder();
        for (final byte b : a){
            sb.append(String.format("%02X ", b&0xff));
            System.out.println("ba : " + String.format("%02X ", b&0xff));
            System.out.println("b : " + b);
        }
        return sb.toString();
    }

    static String stringToHex(String s){
        String result = "";
        for (int i =0; i<s.length(); i++){
            result += String.format("%02X ", (int)s.charAt(i));
        }
        return result;
    }

    static String stringToHex0x(String s){
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result += String.format("0x%02X ", (int)s.charAt(i));
            System.out.println("charAt : " + s.charAt(i));
            System.out.println("(int)charAt : " + (int)s.charAt(i));
            System.out.println("String.format(\"0x%02X \", (int)s.charAt(i)) : " + String.format("%X ", (int)s.charAt(i)));
        }
        return result;
    }

}
