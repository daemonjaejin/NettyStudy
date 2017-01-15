package study.funzin.dto;

import java.io.Serializable;

/**
 * Created by jin on 17. 1. 15.
 */
public class CastingGenericDTO<T> implements Serializable {

    private T Object;

    public T getObject() {
        return Object;
    }

    public void setObject(T object) {
        Object = object;
    }
}
