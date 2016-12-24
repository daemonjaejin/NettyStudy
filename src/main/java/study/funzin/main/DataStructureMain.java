package study.funzin.main;

/**
 * Created by JE on 2016-12-09.
 */
public class DataStructureMain {

    public static void main(String [] args){

        int n = 150;
        String abc = new String();
        String bbb = null;
        String ccc = "";
        String ddd = " ";

        System.out.println(abc);
        System.out.println(bbb);
        System.out.println(ccc);

        System.out.println(abc.isEmpty());
//        System.out.println(bbb.isEmpty());
        System.out.println(ccc.isEmpty());
        System.out.println(ddd.isEmpty());

        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toOctalString(n));
        System.out.println(Integer.toHexString(n));

        Byte bb;

        byte b = (byte)n;

        System.out.println(b);

        System.out.println(b & 0xff);


    }

}
