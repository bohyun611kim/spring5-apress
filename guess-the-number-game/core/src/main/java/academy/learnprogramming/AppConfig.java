package academy.learnprogramming;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// == 빈을 검색, 등록   ==
@Configuration
@ComponentScan(basePackages = "academy.learnprogramming")
public class AppConfig {

    @Bean
    public NumberGenerator numberGenerator() {
        return new NumberGeneratorImpl();
    }
    @Bean
    public Game game() {
        return new GameImpl();
    }

    @Bean
    public MessageGenerator messageGenerator() {
        return new MessageGeneratorImpl();
    }
}
