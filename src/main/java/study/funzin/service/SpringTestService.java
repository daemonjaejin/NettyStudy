package study.funzin.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jin on 16. 11. 12.
 */
@Configuration
public class SpringTestService {

    @Bean
    public Integer testDao(){
        return 0;
    }

}
