package study.funzin.main;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by JE on 2016-11-08.
 */
public class MethodMain {

    public static void main(String [] args){

        Function<String, Integer> f = str -> Integer.parseInt(str);
        Integer result = f.apply("123");
        System.out.println(result);

        Function<String, Integer> f2 = Integer::parseInt;
        Integer result2 = f2.apply("123");
        System.out.println(result2);

        Function<String, Boolean> f3 = String::isEmpty;
        Boolean result3 = f3.apply("123");
        System.out.println(result3);

        Function<String, Integer> f4 = Integer::parseInt;
        Integer result4 = f4.apply("123");
        System.out.println(result4);

        Function<String, Boolean> f5 = String::isEmpty;
        Boolean result5 = f5.apply("123");
        System.out.println(result5);

        Supplier<String> s = String::new;
        s.get();

        String str = "hello";
        Predicate<String> p = str::equals;
        Boolean result6 = p.test("world");
        System.out.println(result6);

//        Predicate<String> p2 = String::equals;

        Comparator<String> c = String::compareTo;
        Integer result7 = c.compare("abc", "bbb");
        System.out.println(result7);

    }

}
