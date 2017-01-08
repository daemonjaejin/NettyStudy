package study.funzin.main3;

/**
 * Created by jin on 17. 1. 8.
 */
public class StringSample {

    public StringSample(){

    }

    public static void main(String args[]){
        StringSample sample = new StringSample();
        sample.constructors();
    }

    public void constructors(){

        try {

            String str = "한글";

            byte[] array1 = str.getBytes();
            for (byte data : array1){
                System.out.print(data + " ");
            }
            System.out.println();
            String str1 = new String(array1);
            System.out.println(str1);

        }catch (Exception e){
            e.getStackTrace();
        }

    }

    public void printByteArray(byte [] array){
        for(byte data:array){
            System.out.print(data + " ");
        }
        System.out.println();
    }



}
