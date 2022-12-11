package onboarding.problem1.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import onboarding.problem1.model.calculator.AdditionMax;
import onboarding.problem1.model.calculator.MultiplicationMax;
import onboarding.problem1.util.Validator;

public class Player {

    public static final int LEFT_PAGE_INDEX = 0;
    public static final int RIGHT_PAGE_INDEX = 1;
    private final List<Integer> pages;
    private final List<Integer> scores;

    public Player(List<Integer> pages) {
        new Validator().validate(pages);
        this.pages = pages;
        this.scores = calculateScores();
    }

    private List<Integer> calculateScores() {
        int leftPage = pages.get(LEFT_PAGE_INDEX);
        int rightPage = pages.get(RIGHT_PAGE_INDEX);
        List<Integer> scores = new ArrayList<>();
        scores.add(AdditionMax.addPageDigits(leftPage));
        scores.add(AdditionMax.addPageDigits(rightPage));
        scores.add(MultiplicationMax.multPageDigits(leftPage));
        scores.add(MultiplicationMax.multPageDigits(rightPage));
        return scores;
    }

    public int getMaxScore() {
        return Collections.max(scores);
    }

    @Override
    public String toString() {
        return "Player{" +
                "pages=" + pages +
                ", scores=" + scores +
                '}';
    }
}
