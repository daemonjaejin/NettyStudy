package study.funzin.generic;

/**
 * Created by JE on 2016-11-07.
 */
public class InterfaceGenericTypeImpl implements InterfaceGenericType<String, Integer> {

    @Override
    public String doSomething(Integer t){
        return null;
    }

    @Override
    public Integer doSomething2(String t){
        return null;
    }

}
