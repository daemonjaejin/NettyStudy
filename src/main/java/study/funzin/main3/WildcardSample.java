package study.funzin.main3;

import study.funzin.dto.Bus;
import study.funzin.dto.Car;
import study.funzin.dto.WildcardGeneric;

/**
 * Created by jin on 17. 1. 15.
 */
public class WildcardSample {

    public static void main(String [] args){
        WildcardSample sample = new WildcardSample();
//        sample.callWildcardMethod();
//        sample.callBoundedWildcardMethod();
        sample.callGenericMethod();
    }

    public void callWildcardMethod(){
        WildcardGeneric<String> wildcard = new WildcardGeneric<String>();
//        WildcardGeneric<?> wildcard = new WildcardGeneric<String>();
        wildcard.setWildcard("A");
        wildcardMethod(wildcard);
    }

    public void wildcardMethod(WildcardGeneric<String> c){
        String value = c.getWildcard();
        System.out.println(value);
    }

    public void callBoundedWildcardMethod(){
//        WildcardGeneric<Car> wildcard = new WildcardGeneric<Car>();
//        wildcard.setWildcard(new Car("BMW"));

        WildcardGeneric<Bus> wildcard = new WildcardGeneric<Bus>();
        wildcard.setWildcard(new Bus("Bongo"));

        boundedWildcardMethod(wildcard);

    }

    public void boundedWildcardMethod(WildcardGeneric<? extends Car> c){
        Car value = c.getWildcard();
        System.out.println(value);
    }

    public <T> void genericMethod(WildcardGeneric<T> c, T addValue){
        c.setWildcard(addValue);
        T value = c.getWildcard();
        System.out.println(value);
    }

    public void callGenericMethod(){
        WildcardGeneric<String> wildcard = new WildcardGeneric<String>();
        genericMethod(wildcard, "Data");
    }

    public <T extends Car> void boundedGenericMethod(WildcardGeneric<T> c, T addValue){

    }

    public <S, T extends Car> void multiGenericMethod(WildcardGeneric<T> c, T addValue, S another){

    }

}
