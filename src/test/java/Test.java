import org.junit.Assert;

import java.nio.charset.Charset;
import java.text.DecimalFormat;

/**
 * Created by JE on 2016-10-20.
 */
public class Test {

    @org.junit.Test
    public void test(){

        String defaultCharset = Charset.defaultCharset().displayName();
//        System.out.println(defaultCharset);


        Integer ab = 321;
        Double a = 1000d;

        a = ab/a;

        DecimalFormat df = new DecimalFormat("###.0");

//        System.out.println(df.format(a));

        Number scale = 1;

        String value = "84...6";

        System.out.println(value.indexOf("."));

        System.out.println(scale.intValue());

        System.out.println(scale.intValue() + 1);

        System.out.println(value.indexOf(".") + scale.intValue() + 1);

        value = value.substring(0, value.indexOf(".") + scale.intValue() + 1);

        System.out.println("value : " + value);

    }

}
