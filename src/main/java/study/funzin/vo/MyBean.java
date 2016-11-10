package study.funzin.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by JE on 2016-11-09.
 */

@JsonIgnoreProperties({"foo", "bar"})
public class MyBean {

    public String foo;
    public String bar;

    @JsonIgnore
    public String internal;

    public String external;

    private int _code;

    @JsonIgnore
    public void setCode(int c) { _code = c; }

    // note: will also be ignored because setter has annotation!
    public int getCode() { return _code; }

}
