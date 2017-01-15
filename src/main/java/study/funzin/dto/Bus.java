package study.funzin.dto;

/**
 * Created by jin on 17. 1. 15.
 */
public class Bus extends Car{

    public Bus(String name){
        super(name);
    }

    public String toString(){
        return "Bus name=" + name;
    }

}
