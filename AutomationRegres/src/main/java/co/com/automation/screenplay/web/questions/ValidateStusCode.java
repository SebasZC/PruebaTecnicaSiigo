package co.com.automation.screenplay.web.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateStusCode implements Question<Integer> {


    public static ValidateStusCode validateStusCode(){
        return new ValidateStusCode();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }
}
