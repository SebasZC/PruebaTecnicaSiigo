package co.com.automation.screenplay.web.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateReponseService implements Question<String> {
    private String keyPath;

    public ValidateReponseService(String keyPath) {
        this.keyPath = keyPath;
    }

    @Override
    public String answeredBy(Actor actor) {
        return SerenityRest.lastResponse().getBody().path(keyPath);
    }

    public static ValidateReponseService reponseService(String keyPath){
        return new ValidateReponseService(keyPath);
    }
}
