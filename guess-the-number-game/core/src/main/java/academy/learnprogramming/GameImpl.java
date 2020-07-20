package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/*
 *  Step 2 : 게임 클래스
 *  주의 :  의존성 주입
 */
public class GameImpl implements Game {

    // == constants ==
    private  static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    // == fields ==
    @Autowired
    private NumberGenerator numberGenerator;

    private int guessCount = 10;
    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses; // 게임 횟수
    private boolean validNumberRange = true;

    // == member variable init ==
    @PostConstruct
    @Override
    public void reset() {
        smallest = 0;
        guess = 0;
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        // 자동 생성된 램덤값
        number = numberGenerator.next();
        log.debug("the number is {}", number);
    }

    @PreDestroy
    public void preDestroy() {
        log.info("in Game preDestroy()");
    }

    // == public methods ==
    @Override
    public int getNumber() {
        // 채번값
        return number;
    }

    @Override
    public int getGuess() {
        // 콘솔 추측값
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        // 콘솔 입력값 설정
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    @Override
    public void check() {
        // 유효 범위 확인
        checkValidNumberRange();

        if (validNumberRange) {
            if (guess > number) {
                biggest = guess - 1;
            }

            if (guess < number) {
                smallest = guess + 1;
            }
        }
    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    // == private methods ==
    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }

}
