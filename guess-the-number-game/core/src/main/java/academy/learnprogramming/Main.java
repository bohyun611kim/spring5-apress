package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        logger.info("Guess the Number Game!");

        // create context (container)
        ConfigurableApplicationContext context
                = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        // == 콩을 꺼낸다
        NumberGenerator numberGenerator
                = context.getBean("numberGenerator", NumberGenerator.class);
        // == 램덤 함수 호출 ==
        int number = numberGenerator.next();

        // log
        logger.info("number = {}", number);

        // get game bean from context
        Game game = context.getBean("game", GameImpl.class);

        // call reset method
        game.reset();

        // close
        context.close();
    }
}
