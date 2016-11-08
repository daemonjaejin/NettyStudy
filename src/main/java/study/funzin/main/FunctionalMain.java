package study.funzin.main;

import java.util.Comparator;
import java.util.function.*;

/**
 * Created by JE on 2016-11-07.
 */
public class FunctionalMain {

    public static void main(String args[]){

        /* Runnable */
        /**
         * 인자를 받지 않으며, 설정된 값을 리턴한다.
         * */
        Runnable r = () -> System.out.println("hello functional");
        r.run();

        /* Supplier */
        /**
         * 함수에 등록된 값을 리턴한다.
         * */
        Supplier<String> s = () -> "hello supplier";
        String result = s.get();
        System.out.println(result);

        /* Consumer */
        Consumer<String> c = str -> System.out.println(str);
        c.accept("hello consumer");

        /* Function<T, R> */
        /**
         * 두타입에 대해 변환해서 보여준다.
         * */
        Function<String, Integer> f = str -> Integer.parseInt(str);
        Integer result2 = f.apply("1");
        System.out.println(result2);

        /* Predicate<T> */
        /**
         * 타입에 대해 체크하여 결과를 true or false 리턴한다.
         * */
        Predicate<String> p = str -> str.isEmpty();
        boolean result3 = p.test("hello");
        System.out.println(result3);

        /* UnaryOperator<T> */
        /**
         * 하나의 값을 넣어 같으면 합친 값을 리턴한다.
         * */
        UnaryOperator<String> u = str -> str + "operator";
        String result4 = u.apply("Hello unary");
        System.out.println(result4);

        /* BinaryOperator<T> */
        /**
         * 두 값을 넣어 같으면 합친 값을 리턴한다.
         * */
        BinaryOperator<String> b = (str1, str2) -> str1 + " " + str2;
        String result5 = b.apply("hello", "binary");
        System.out.println(result5);

        /* BiPredicate<T, U> */
        /**
         * 두 값을 넣어 같으면 true, 틀리면 false 리턴한다.
         * */
        BiPredicate<String, Integer> bp = (str, num) -> str.equals(Integer.toString(num));
        boolean result6 = bp.test("1", 1);
        System.out.println(result6);

        /* BiConsumer<T, U> */
        /**
         * 두 값을 넣어 하나의 값을 리턴한다.
         * */
        BiConsumer<String, Integer> bc = (str, num) -> System.out.println(str + " :: " + num);
        bc.accept("숫자", 5);

        /* BiFunction<T, U, R> */
        /**
         * 두 타입을 넣어 다른 타입을 리턴한다.
         * */
        BiFunction<Integer, String, String> bf = (num, str) -> String.valueOf(num) + str;
        String result7 = bf.apply(5, "678");
        System.out.println(result7);

        /* Comparator<T> */
        /**
         * 타입을 넣고 비교하여 리턴한다.
         * */
        Comparator<String> c2 = (str1, str2) -> str1.compareTo(str2);
        int result8 = c2.compare("abc", "bbb");
        System.out.println(result8);

    }

}
