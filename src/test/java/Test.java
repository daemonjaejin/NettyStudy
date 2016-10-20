import org.junit.Assert;

import java.nio.charset.Charset;

/**
 * Created by JE on 2016-10-20.
 */
public class Test {

    @org.junit.Test
    public void test(){
        String defaultCharset = Charset.defaultCharset().displayName();
        System.out.println(defaultCharset);
    }

}
