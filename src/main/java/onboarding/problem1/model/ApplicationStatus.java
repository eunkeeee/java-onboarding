package onboarding.problem1.model;

public enum ApplicationStatus {

    INITIALIZE_APPLICATION,
    APPLICATION_EXIT;

    public boolean isPlayable() {
        return this != APPLICATION_EXIT;
    }
}
