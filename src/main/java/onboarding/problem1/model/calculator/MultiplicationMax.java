package onboarding.problem1.model.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultiplicationMax {

    public static int multPageDigits(int page) {
        int result = 1;
        for (int digit : getPageDigits(page)) {
            result *= digit;
        }
        return result;
    }

    private static List<Integer> getPageDigits(int page) {
        return Arrays.stream(String.valueOf(page).split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private MultiplicationMax() {
    }
}
