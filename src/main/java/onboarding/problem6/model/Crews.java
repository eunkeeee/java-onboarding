package onboarding.problem6.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Crews {
    private static List<Crew> crews = new ArrayList<>();

    public Crews(List<List<String>> forms) {
        crews = createCrews(forms);
    }

    public List<String> getEmails() {
        List<String> emails = getEmailsOfDuplicatedNicknames();
        Collections.sort(emails);
        return emails;
    }

    private static List<String> getEmailsOfDuplicatedNicknames() {
        return crews.stream()
                .filter(Crew::isDuplicatedNickname)
                .map(Crew::getEmail)
                .collect(Collectors.toList());
    }

    private static List<Crew> createCrews(List<List<String>> forms) {
        return forms.stream().map(Crew::new).collect(Collectors.toList());
    }

    private static Set<String> nicknameSequencesWithout(Crew crew) {
        return crews.stream()
                .filter(element -> !element.equals(crew))
                .map(Crew::getNicknameSequences)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    public static boolean isDuplicateNickname(Crew crew) {
        for (String nicknameSequence : crew.getNicknameSequences()) {
            if (nicknameSequencesWithout(crew).contains(nicknameSequence)) {
                return true;
            }
        }
        return false;
    }

}
