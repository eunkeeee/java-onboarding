package onboarding.problem1.model.calculator;

import java.util.Arrays;

public class AdditionMax {

    public static int addPageDigits(int page) {
        return Arrays.stream(String.valueOf(page).split("")).mapToInt(Integer::parseInt).sum();
    }

    private AdditionMax() {
    }
}
