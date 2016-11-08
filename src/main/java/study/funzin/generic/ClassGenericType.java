package study.funzin.generic;

/**
 * Created by JE on 2016-11-07.
 */
public class ClassGenericType<T> {

    private T t;

    public void set(T t){
        this.t = t;
    }

    public T get(){
        return t;
    }

}


