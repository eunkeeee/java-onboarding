package onboarding.problem6.controller;

import java.util.List;
import onboarding.problem6.model.Crews;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Crews crews = new Crews(forms);
        return crews.getEmails();
    }
}

