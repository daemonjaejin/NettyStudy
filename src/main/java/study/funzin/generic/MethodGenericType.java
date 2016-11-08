package study.funzin.generic;

/**
 * Created by JE on 2016-11-07.
 */
public class MethodGenericType {

    public static <T> int methodGeneric(T[] list, T item){
        int count = 0;
        for (T t : list){
            if(item == t){
                count++;
            }
        }
        return count;
    }

}
