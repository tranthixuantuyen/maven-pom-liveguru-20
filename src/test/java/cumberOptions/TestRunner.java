package cumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/demo",
		glue= "stepDefinitions",
		monochrome = true,
		plugin = {"pretty", "html:target/cucumber-report-default", "json:target/cucumber.json"},
		snippets = SnippetType.CAMELCASE,
		tags = {"@datatable_step"})
public class TestRunner {

}
