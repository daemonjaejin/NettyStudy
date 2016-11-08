package study.funzin.main;

import java.util.function.Supplier;

/**
 * Created by JE on 2016-11-07.
 */
public class FunctionalMain {

    public static void main(String args[]){

        Runnable r = () -> System.out.println("hello functional");
        r.run();

        Supplier<String> s = () -> "hello supplier";
        String result = s.get();

        System.out.println(result);

    }

}
