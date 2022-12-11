package onboarding.problem1.controller;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import onboarding.problem1.model.ApplicationStatus;

public class GameController {
    private final Map<ApplicationStatus, Supplier<ApplicationStatus>> gameGuide;

    public GameController() {
        this.gameGuide = new EnumMap<>(ApplicationStatus.class);
        initializeGameGuide();
    }

    private void initializeGameGuide() {
        gameGuide.put(ApplicationStatus.INITIALIZE_APPLICATION, this::playGame);
    }

    public ApplicationStatus progress(ApplicationStatus applicationStatus) {
        try {
            return gameGuide.get(applicationStatus).get();
        } catch (IllegalArgumentException exception) {
            return applicationStatus;
        }
    }

    private ApplicationStatus playGame() {
        return null;
    }


}
