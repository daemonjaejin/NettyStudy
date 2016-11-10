package study.funzin.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by JE on 2016-11-09.
 */
public class User {

    @JsonProperty("userId")
    public Integer u;

    @JsonProperty("age")
    public Integer a;

    @JsonProperty("email")
    public String e;

}
