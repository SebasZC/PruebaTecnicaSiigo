package co.com.automation.screenplay.web.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static co.com.automation.screenplay.web.utils.constants.AutomationConstants.PATH_GET_USER;

public class DeleteAUser implements Task {
    private String id;

    public DeleteAUser(String id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        if(id!=null){
            t.attemptsTo(Delete.from(PATH_GET_USER+id));
        }
    }
    public static DeleteAUser deleteAUser(String id){
        return Tasks.instrumented(DeleteAUser.class, id);
    }
}
