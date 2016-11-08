package study.funzin.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JE on 2016-11-07.
 */
public class WildcardGenericType {

    public List<? extends Number> method1(){
        return new ArrayList<Long>();
    }

    public <T> List<? extends String> method2(T param){
        return new ArrayList<String>();
    }

    public List<?> method3(){
        return new ArrayList<Object>();
    }

}
