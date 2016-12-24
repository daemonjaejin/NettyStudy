package study.funzin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jin on 16. 11. 12.
 */
@Configuration
public class SpringConfigTest {

    @Bean
    public Integer test1(){
        return 1;
    }

    @Bean
    public Integer test2(){
        return 1;
    }

}
