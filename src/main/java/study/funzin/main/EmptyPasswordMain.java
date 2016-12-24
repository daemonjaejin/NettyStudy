package study.funzin.main;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by jin on 16. 12. 4.
 */
public class EmptyPasswordMain {

    public static void main(String [] args){

        System.out.println(madePassword());

    }

    public static String madePassword(){
        String password = "";
        boolean numCheck = false;
        boolean specialCheck = false;
        for (int i=0; i<8; i++){
            int empty = (int)(Math.random()*10);
            password += String.valueOf(empty);
            String test = RandomStringUtils.randomAscii(1);
            System.out.println(test);
        }

        return password;
    }


}
