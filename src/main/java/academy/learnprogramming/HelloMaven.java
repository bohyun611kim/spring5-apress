package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloMaven {

    private static Logger logger = LoggerFactory.getLogger(HelloMaven.class);
    public static void main(String[] args) {
        System.out.println("hello maven!");
        logger.info("Hello Info");
        logger.debug("Hello Debug");
    }
}
