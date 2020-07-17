package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Guess the Number Game!");

        // create context (container)
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        // == 콩을 꺼낸다
        NumberGenerator numberGenerator
                = context.getBean(NumberGenerator.class);
        // == 램덤 함수 호출 ==
        int number = numberGenerator.next();

        // log
        logger.info("number = {}", number);

        // get game bean from context (container)
        Game game = context.getBean(Game.class);
        // 초기화 메소드 삭제

        // close
        context.close();
    }
}
