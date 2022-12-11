package onboarding.problem1.util;

import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public class Validator {

    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]*$");
    public static final int LEFT_PAGE_INDEX = 0;
    public static final int RIGHT_PAGE_INDEX = 1;
    public static final int PAGE_GAP = 1;
    public static final int PAGE_SIZE = 2;

    public void validate(List<Integer> pages) {
        validatePagesSize(pages);
        validateBothPages(pages, this::validateNumeric);
        validateBothPages(pages, this::validateRange);
        validateBothPages(pages, this::validateNumberRange);
        validatePageGap(pages);
    }

    private static void validatePagesSize(List<Integer> pages) {
        if (pages.size() != PAGE_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBothPages(List<Integer> pages, Consumer<String> validator) {
        pages.stream().map(String::valueOf).forEach(validator);
    }


    private static void validatePageGap(List<Integer> pages) {
        if (pages.get(LEFT_PAGE_INDEX) + PAGE_GAP != pages.get(RIGHT_PAGE_INDEX)) {
            throw new IllegalArgumentException();
        }
    }


    static String removeSpace(String input) {
        return input.replaceAll(" ", "");
    }

    void validateNumeric(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }

    void validateRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

    void validateNumberRange(String input) {
        int number = Integer.parseInt(input);
        if (number < Range.MIN_RANGE.value || number > Range.MAX_RANGE.value) {
            throw new IllegalArgumentException();
        }
    }

    private enum Range {
        MIN_RANGE(2), MAX_RANGE(399);

        private final int value;

        Range(int value) {
            this.value = value;
        }
    }
}