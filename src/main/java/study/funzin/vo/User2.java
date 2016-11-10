package study.funzin.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by JE on 2016-11-09.
 */
public class User2 {

    public Integer u;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer age;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String email;

}
