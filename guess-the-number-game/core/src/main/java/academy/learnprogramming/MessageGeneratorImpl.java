package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {

    // == 로그 ==
    private static Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);
    // == field ==
    @Autowired
    private Game game;

    private int guessCount = 100;

    // == init ==
    @PostConstruct
    public void game() {
        log.info("game = {}", game);
    }

    // == public method
    @Override
    public String getMainMessage() {
        return "getMainMessage() 호출";
    }

    @Override
    public String getResultMessage() {
        return "getResultMessage() 호출";
    }
}
