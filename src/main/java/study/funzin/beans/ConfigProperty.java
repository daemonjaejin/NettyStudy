package study.funzin.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by JE on 2017-02-09.
 */
//@Component(value = "config")
@Component
public class ConfigProperty {

    @Value("#{config['test']}")
    private Integer test;

    @Value("#{config['test2']}")
    private Integer test2;

    @Value("#{config['test100']}")
    private Integer test100;

    public Integer getTest() {
        return test;
    }

    public void setTest(Integer test) {
        this.test = test;
    }

    public Integer getTest2() {
        return test2;
    }

    public void setTest2(Integer test2) {
        this.test2 = test2;
    }

    public Integer getTest100() {
        return test100;
    }

    public void setTest100(Integer test100) {
        this.test100 = test100;
    }

}
