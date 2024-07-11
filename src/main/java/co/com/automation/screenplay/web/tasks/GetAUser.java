package co.com.automation.screenplay.web.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.automation.screenplay.web.utils.constants.AutomationConstants.PATH_GET_USER;

public class GetAUser implements Task {
    private String id;

    public GetAUser(String id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        if(id!=null){
            t.attemptsTo(Get.resource(PATH_GET_USER+id));
        }
    }
    public static GetAUser getAUser(String id){
        return Tasks.instrumented(GetAUser.class, id);
    }
}
