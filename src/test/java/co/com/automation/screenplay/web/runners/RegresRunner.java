package co.com.automation.screenplay.web.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src\\test\\resources\\features\\regres_test.feature",
        glue = "co.com.automation.screenplay.web.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "")
public class RegresRunner {
}
