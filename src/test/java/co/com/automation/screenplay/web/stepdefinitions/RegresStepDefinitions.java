package co.com.automation.screenplay.web.stepdefinitions;

import co.com.automation.screenplay.web.models.DataRegister;
import co.com.automation.screenplay.web.models.DataRegres;
import co.com.automation.screenplay.web.questions.ValidateReponseService;
import co.com.automation.screenplay.web.questions.ValidateStusCode;
import co.com.automation.screenplay.web.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

import static co.com.automation.screenplay.web.utils.constants.AutomationConstants.END_POINT_REGRES;

public class RegresStepDefinitions {

    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(END_POINT_REGRES)));
        OnStage.theActorCalled("User");
        SerenityRest.useRelaxedHTTPSValidation();
    }

    @DataTableType
    public DataRegres dataRegres(Map<String, String> entry){
        return new DataRegres(
                entry.get("name"),
                entry.get("job")
        );
    }

    @DataTableType
    public DataRegister dataRegister(Map<String, String> entry){
        return new DataRegister(
                entry.get("email"),
                entry.get("password")
        );
    }

    @When("^the developer get a user with id (.*)$")
    public void theDeveloperGetAUserWithIdAny(String id) {
        OnStage.theActorInTheSpotlight().attemptsTo(GetAUser.getAUser(id));
    }

    @Then("^the status code should be (.*)$")
    public void theStatusCodeShouldBeAny(int statusCode) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateStusCode.validateStusCode(),Matchers.equalTo(statusCode)));
    }

    @And("^The service response must contain the (.*) value in the path (.*)$")
    public void theServiceResponseMustContainTheANYValueInThePathANY(String value, String key) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateReponseService.reponseService(key),Matchers.equalTo(value)));
    }

    @When("the developer POST a new user whit data")
    public void theDeveloperPOSTANewUserWhitData(List<DataRegres> dataRegres) {
        OnStage.theActorInTheSpotlight().attemptsTo(PostAUser.postAUser(dataRegres.get(0)));
    }

    @When("^the developer update the user with id (.*) and the data$")
    public void theDeveloperUpdateTheUserWithIdANYAndTheData(String id, List<DataRegres> dataRegres) {
        OnStage.theActorInTheSpotlight().attemptsTo(PutAUser.putAUser(id, dataRegres.get(0)));
    }

    @When("^the developer delete a user created with id (.*)$")
    public void theDeveloperDeleteAUserCreatedWithIdAny(String id) {
        OnStage.theActorInTheSpotlight().attemptsTo(DeleteAUser.deleteAUser(id));
    }

    @When("the developer POST a new register with data")
    public void theDeveloperPOSTANewRegisterWithData(List<DataRegister> dataRegisters) {
        OnStage.theActorInTheSpotlight().attemptsTo(PostARegister.postARegister(dataRegisters.get(0)));
    }
}
