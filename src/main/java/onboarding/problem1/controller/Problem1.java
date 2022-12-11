package onboarding.problem1.controller;

import java.util.List;
import onboarding.problem1.model.Player;
import onboarding.problem1.model.Players;
import onboarding.problem1.model.Result;

public class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Result result;
        try {
            Player player1 = new Player(pobi);
            Player player2 = new Player(crong);
            Players players = new Players(List.of(player1, player2));
            result = Result.from(players.getWinners());
        } catch (IllegalArgumentException exception) {
            result = Result.EXCEPTION_OCCURRED;
        }
        return result.getAnswer();
    }
}