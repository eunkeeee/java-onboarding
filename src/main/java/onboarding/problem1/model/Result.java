package onboarding.problem1.model;

import java.util.List;

public enum Result {

    TIE(0),
    PLAYER1_WIN(1),
    PLAYER2_WIN(2),
    EXCEPTION_OCCURRED(-1);

    public static final int TIE_SIZE = 2;
    public static final int PLAYER1_INDEX = 0;
    private final int answer;

    Result(int answer) {
        this.answer = answer;
    }

    public static Result from(List<Player> winner) {
        if (winner.size() == TIE_SIZE) {
            return TIE;
        }
        if (winner.contains(winner.get(PLAYER1_INDEX))) {
            return PLAYER1_WIN;
        }
        return PLAYER2_WIN;
    }

    public int getAnswer() {
        return answer;
    }
}
