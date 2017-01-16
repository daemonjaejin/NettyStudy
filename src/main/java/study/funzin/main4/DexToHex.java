package study.funzin.main4;

/**
 * Created by JE on 2017-01-16.
 */
public class DexToHex {

    private static final int sizeOfIntInHalfBytes = 8;
    private static final int numberOfBitsInAHalfByte = 4;
    private static final int halfBYte = 0x0F;
    private static final char[] hexDigits = {
      '0', '1', '2', '3', '4', '5', '6', '7',
      '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };

    public static String dexToHex(int dec){
        StringBuilder hexBuilder = new StringBuilder(sizeOfIntInHalfBytes);
        hexBuilder.setLength(sizeOfIntInHalfBytes);
        for (int i = sizeOfIntInHalfBytes - 1; i >= 0 ; --i) {
            System.out.println("dec1 : " + dec);
            int j = dec & halfBYte;
            System.out.println("hexDigits[" + j + "] : " + hexDigits[j]);
            hexBuilder.setCharAt(i, hexDigits[j]);
            System.out.println("hexBuilder : " + hexBuilder.toString());
            dec >>= numberOfBitsInAHalfByte;
            System.out.println("dec2 : " + dec);
        }
        return hexBuilder.toString();
    }


    public static void main(String [] args){
//        int dec = 888;
//        String hex = dexToHex(dec);
//        System.out.println("halfBYte : " + halfBYte);
//        System.out.println("hex : " + hex);
//        int tempInt = Integer.parseInt(hex);
//        String tempStr = Integer.toString(tempInt);
//        System.out.println("tempStr : " + tempStr);
//        dec = dec*50;
//        System.out.println("dec2 : " + dec);
//        dec>>=numberOfBitsInAHalfByte;
//        System.out.println("dec3 : " + dec);

//        int a = 100;
//        int b = 4;
//        a >>= b;
//        System.out.println("a : " + a);

        System.out.println(0x0F & 15);

    }

}
