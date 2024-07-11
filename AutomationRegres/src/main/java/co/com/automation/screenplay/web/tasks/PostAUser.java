package co.com.automation.screenplay.web.tasks;

import co.com.automation.screenplay.web.models.DataRegres;
import co.com.automation.screenplay.web.utils.constants.ReadFile;
import co.com.automation.screenplay.web.utils.constants.SharedContext;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static co.com.automation.screenplay.web.utils.constants.AutomationConstants.*;
import static co.com.automation.screenplay.web.utils.constants.JsonRoutes.ROUTE_JSON_REGRES;

public class PostAUser implements Task {
    private DataRegres dataRegres;

    public PostAUser(DataRegres dataRegres) {
        this.dataRegres = dataRegres;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        String bodyCreate = replaceJsonValues(String.format(ReadFile.returnFile(ROUTE_JSON_REGRES),
                dataRegres.getName(),
                dataRegres.getJob()));

        t.attemptsTo(
                Post.to(PATH_POST_USER).with(requestSpecification -> requestSpecification
                        .header(HEADER_NAME_CONTENT_TYPE, HEADER_VALUE_CONTENT_TYPE)
                        .body(bodyCreate)
        ));
        String idPost =null;
        if (SerenityRest.lastResponse().getStatusCode()==200 || SerenityRest.lastResponse().getStatusCode()==201) {
            idPost = SerenityRest.lastResponse().getBody().path("id").toString();
            SharedContext.setVariable("idPost",idPost);
        }
        System.out.println("POST: "+SerenityRest.lastResponse().getBody().prettyPrint());
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
    public static PostAUser postAUser(DataRegres dataRegres){
        return Tasks.instrumented(PostAUser.class, dataRegres);
    }
}
