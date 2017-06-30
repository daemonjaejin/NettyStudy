import java.nio.charset.Charset;
import java.text.DecimalFormat;

/**
 * Created by JE on 2016-10-20.
 */
public class Test3 {

    @org.junit.Test
    public void test(){

        Integer [] a = new Integer[6000];
        Integer [] b = new Integer[6000];

        for (int i = 0; i < 6000; i++) {
            a[i] = i;
            b[i] = i;
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                  if(a[i] == b[j]){
//                      System.out.println("a[i] == b[j] : " + (a[i] == b[j]));
                      System.out.println("1 : " + a[i] + ", " + b[j]);
                  }
                  if(a[i].equals(b[j])){
//                      System.out.println("a[i].equals(b[j]) : " + (a[i].equals(b[j])));
                      System.out.println("2 : " + a[i] + ", " + b[j]);
                  }
                if(a[i].intValue() == b[j].intValue()){
//                    System.out.println("a[i].intValue() == b[j].intValue() : " + (a[i].intValue() == b[j].intValue()));
                    System.out.println("3 : " + a[i] + ", " + b[j]);
                }
            }
        }


    }

}
