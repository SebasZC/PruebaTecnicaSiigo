package co.com.automation.screenplay.web.tasks;

import co.com.automation.screenplay.web.models.DataRegres;
import co.com.automation.screenplay.web.utils.constants.ReadFile;
import co.com.automation.screenplay.web.utils.constants.SharedContext;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static co.com.automation.screenplay.web.utils.constants.AutomationConstants.*;
import static co.com.automation.screenplay.web.utils.constants.JsonRoutes.ROUTE_JSON_REGRES;

public class PutAUser implements Task {
    private String id;
    private DataRegres dataRegres;

    public PutAUser(String id, DataRegres dataRegres) {
        this.id = id;
        this.dataRegres = dataRegres;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        String bodyCreate = replaceJsonValues(String.format(ReadFile.returnFile(ROUTE_JSON_REGRES),
                dataRegres.getName(),
                dataRegres.getJob()));
        if(id!=null){
            if(id.equals("guardado")){
                id= SharedContext.getVariable("idPost",null).toString();
            }
        }
        System.out.println(id);
        t.attemptsTo(
                Put.to(PATH_PUT_USER+id).with(requestSpecification -> requestSpecification
                        .header(HEADER_NAME_CONTENT_TYPE, HEADER_VALUE_CONTENT_TYPE)
                        .body(bodyCreate)
        ));
        System.out.println(SerenityRest.lastResponse().getBody().prettyPrint());
        String idPost =null;
    }

    private static String replaceJsonValues(String input) {
        if (input == null) {
            return null;
        }

        input = input.replaceAll("\"true\"", "true");
        input = input.replaceAll("\"false\"", "false");
        input = input.replaceAll("\"null\"", "null");

        return input;
    }
    public static PutAUser putAUser(String id, DataRegres dataRegres){
        return Tasks.instrumented(PutAUser.class, id, dataRegres);
    }
}
