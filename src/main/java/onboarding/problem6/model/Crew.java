package onboarding.problem6.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Crew {

    public static final int EMAIL_INDEX = 0;
    public static final int NICKNAME_INDEX = 1;
    private final String email;
    private final String nickname;
    private final Set<String> nicknameSequences;

    public Crew(List<String> info) {
        this.email = info.get(EMAIL_INDEX);
        this.nickname = info.get(NICKNAME_INDEX);
        this.nicknameSequences = getNicknameSequences();
    }

    public Set<String> getNicknameSequences() {
        Set<String> nicknameSequences = new HashSet<>();
        for (int index = 0; index < nickname.length() - 1; index++) {
            nicknameSequences.add(getNicknameSequence(index));
        }
        return nicknameSequences;
    }

    private String getNicknameSequence(int index) {
        return nickname.substring(index, index + 2);
    }

    public boolean isDuplicatedNickname (){
        return Crews.isDuplicateNickname(this);
    }
    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Crew crew = (Crew) o;
        return Objects.equals(email, crew.email) && Objects.equals(nickname, crew.nickname)
                && Objects.equals(nicknameSequences, crew.nicknameSequences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, nickname, nicknameSequences);
    }

    @Override
    public String toString() {
        return "Crew{" +
                "nickname='" + nickname + '\'' +
                '}';
    }
}
