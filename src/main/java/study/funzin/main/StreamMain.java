package study.funzin.main;

import java.util.*;
import java.util.stream.*;

/**
 * Created by JE on 2016-11-08.
 */
public class StreamMain {

    public static void main(String [] args){

        int [] numberArr = {1, 2, 3, 4, 5, 6, 7};
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Set<Integer> numberSet = new HashSet<>(numberList);

        Arrays.stream(numberArr);
        Stream.of(1, 2, 3, 4, 5, 6, 7);
        numberList.stream();
        numberSet.stream();

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.get(0);
        numbers.remove(0);


        /* Case1 */
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> eventList = new ArrayList<>();

        for (int number : numbers2){
            if(number % 2 == 0){
                eventList.add(number);
            }
        }

        System.out.println(eventList);

        /* Case2 */
        /**
         * limit() 메서드는 무언가 객체를 반환할 것이다.
         * void 타입의 메서드라면 filter() 메서드를 호출할 수가 없기 때문이다.
         * limit() 반환하는 객체는 filter() 메서드를 갖고있는 객체다.
         * 그리고 filter() 메서드 역시 collect() 라는 메서드를 갖고 있는 객체를 반환한다.
         * */
        List<Integer> eventList2 = Stream.iterate(1, n -> n+1)
                .limit(7)
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(eventList2);

        /* Case3 */
        Stream<Integer> stream = Stream.iterate(1, n -> n+1)
                .limit(7)
                .peek(System.out::println)
                .filter(number -> number % 2 == 0);

        stream.collect(Collectors.toList());

        /* Other */
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> s = stream2.peek(System.out::println);

        System.out.println("");

        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> s2 = stream3.peek(System.out::println);
        s2.collect(Collectors.toList());

        Object obj = null;
        boolean b = 1 == 2 && obj.toString().equals(123);
        System.out.println(b);

        System.out.println();

        List<String> list = Arrays.asList("a", "b", "c");

        boolean b2 = list.stream().allMatch(str -> {
            System.out.println(str);
            return str.equals("d");
        });

        System.out.println();

        List<Integer> list1 = new ArrayList<>();

        Stream<Integer> stream4 = Stream.of(1, 2, 3, 4, 5);

        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0);
        LongStream longStream = LongStream.of(1L, 2L, 3L, 4L, 5L);

        Integer result = intStream.sum();
        System.out.println(result);

        System.out.println();

//        List<Integer> integer = intStream.boxed().collect(Collectors.toList());

    }

}
