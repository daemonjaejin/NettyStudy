package study.funzin.main;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

/**
 * Created by JE on 2016-11-08.
 */
public class OptionalMain {

    public static void main(String [] args){

        String str = "hello";
//        String str = null;
        Optional<String> o1 = Optional.of(str); // str이 null이면 NPE 발생
        Optional<String> o2 = Optional.ofNullable(str); // str이 null이면 빈 Optional 객체 반환
        Optional<String> o3 = Optional.empty(); // 빈 Optional 객체 반환

        /* Anti Pattern */
        Optional<Integer> integer = Optional.empty();
        if(integer.isPresent()){

        }

        Optional<Object> objectOptional = Optional.empty();
        Object object1 = objectOptional.orElse(new Object());
        Object object2 = objectOptional.orElseGet(() -> new Object());
        Object object3 = objectOptional.orElseGet(Object::new);

        Object object4 = objectOptional.orElseGet(() -> {
            Object obj = new Object();
//            obj.setItem();
//            obj.setName();
            return obj;
        });

        Optional<Integer> integerOptional = Optional.empty();
        Integer number1 = integerOptional.orElse(5);
        Integer number2 = integerOptional.orElseGet(() -> 5);

        /* 중요한 사용방법 */
        Optional<Object> objectOptional1 = Optional.empty();
        Object obj = objectOptional1.map(Object::getClass)
                .map(Object::getClass)
                .orElse(null);

        OptionalInt optionalInt = OptionalInt.empty();
        OptionalDouble optionalDouble = OptionalDouble.empty();
        OptionalLong optionalLong = OptionalLong.empty();

    }

    public void method01(Object obj){
        if(obj == null){
            return;
        }

        // 로직

    }

    public String method02(String str){
        if(str == null){
            return null;
        }
        return "";
    }

    public void method03(Object obj){
        Object obj1 =
//                obj.getObject().getObject().getObject();
        obj.getClass().getClass().getClass();
    }

    public void method04(Object obj){
        Object obj1 = null;
        if(obj != null){
            if(obj.getClass() != null){
                if(obj.getClass().getClass() != null){
                    obj1 = obj.getClass().getClass().getClass();
                }
            }
        }
    }

    public void method05(Object obj){
        Object obj1 = null;
        if(obj != null && obj.getClass() != null && obj.getClass().getClass() != null){
            obj1 = obj.getClass().getClass().getClass();
        }
    }

    public void method06(Object obj){
        Object obj1 = null;
        if(isValiedObject(obj)){
            obj1 = obj.getClass().getClass().getClass();
        }
    }

    public boolean isValiedObject(Object obj){
        return obj != null && obj.getClass() != null && obj.getClass().getClass() != null;
    }

}

//class Optional<T>{
//    private T t;
//}
