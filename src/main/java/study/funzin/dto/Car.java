package study.funzin.dto;

/**
 * Created by jin on 17. 1. 15.
 */
public class Car {

    protected String name;

    public Car(String name){
        this.name = name;
    }

    public String toString(){
        return "Car name=" + name;
    }
}
