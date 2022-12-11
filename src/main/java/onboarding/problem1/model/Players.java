package onboarding.problem1.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public List<Player> getWinners() {
        int maxScore = Collections.max(
                players.stream().map(player -> player.getMaxScore()).collect(Collectors.toList()));
        return players.stream()
                .filter(player -> player.getMaxScore() == maxScore)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Players{" +
                "players=" + players +
                '}';
    }
}
