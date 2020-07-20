package academy.learnprogramming;

import org.springframework.stereotype.Component;

import java.util.Random;

/*
 *  Step 1 : 램덤값 생성
 */
@Component("numberGenerator")
public class NumberGeneratorImpl implements NumberGenerator {

    // == fields ==
    private  final Random random = new Random();

    // 0 ~ 100 까지 랜덤값
    private int maxNumber = 100;

    // == public methods ==

    @Override
    public int next() {
        // 램덤값 채번
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

}
