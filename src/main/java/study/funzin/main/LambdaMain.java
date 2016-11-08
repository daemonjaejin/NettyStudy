package study.funzin.main;

import study.funzin.lambda.Fruit;
import study.funzin.lambda.Movable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by JE on 2016-11-07.
 */
public class LambdaMain {

    public static void main(String args[]){

        Movable m = str -> System.out.println("gogo move move" + str);
        m.move("car");

        List<Fruit> fruits = Arrays.asList(new Fruit("apple", "red"), new Fruit("melon", "green"), new Fruit("banana", "yellow"));

        List<Fruit> appleList = extractFruitList(fruits, new Predicate<Fruit>() {
            @Override
            public boolean test(Fruit fruit) {
                return "apple".equals(fruit.getName());
            }
        });

        for (Fruit fruit : appleList){
            System.out.println(fruit.getName());
        }

        List<Fruit> redList = extractFruitList(fruits, new Predicate<Fruit>() {
            @Override
            public boolean test(Fruit fruit) {
                return "red".equals(fruit.getColor());
            }
        });

        for (Fruit fruit : redList){
            System.out.println(fruit.getColor());
        }

        List<Fruit> appleList2 = extractFruitList(fruits, fruit -> "apple".equals(fruit.getName()));
        List<Fruit> redList2 = extractFruitList(fruits, fruit -> "red".equals(fruit.getColor()));

        System.out.println(appleList2.size());
        System.out.println(redList2.size());

        System.out.println(appleList2.get(0).getName());
        System.out.println(redList2.get(0).getColor());

    }

    Movable movable = new Movable() {
        @Override
        public void move(String str) {
            System.out.println("gogo move move" + str);
        }
    };

    Movable movable1 = (str) -> {
        System.out.println("gogo move move" + str);
    };

    Movable movable2 = str -> System.out.println("gogo move move" + str);

    /* 상태가 없는 객체(Stateless Object) */
    Movable movable3 = new Movable() {

        private int speed;

        @Override
        public void move(String str) {
            System.out.println("gogo move move current speed : " + speed);
        }
    };

    /* 행위 파라미터화(Behavior Parameterize) */
    List<Fruit> extractApple(List<Fruit> fruits){
        List<Fruit> resultList = new ArrayList<>();
        for (Fruit fruit : fruits){
            if("apple".equals(fruit.getName())){
                resultList.add(fruit);
            }
        }
        return resultList;
    }

    List<Fruit> extractRed(List<Fruit> fruits){
        List<Fruit> resultList = new ArrayList<>();
        for (Fruit fruit : fruits){
            if("red".equals(fruit.getColor())){
                resultList.add(fruit);
            }
        }
        return resultList;
    }

    // 위 두개의 메서드를 하나로 합친다.
    static List<Fruit> extractFruitList(List<Fruit> fruits, Predicate<Fruit> predicate){
        List<Fruit> resultList = new ArrayList<>();
        for (Fruit fruit : fruits){
            if(predicate.test(fruit)){
                resultList.add(fruit);
            }
        }

        return resultList;
    }

}
