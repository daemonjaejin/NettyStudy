package study.funzin.dto;

import java.io.Serializable;

/**
 * Created by jin on 17. 1. 15.
 */
public class CastingDTO implements Serializable {

    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
