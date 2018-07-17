package bdd.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

public class WebMailRunner {
	 @CucumberOptions(features = "src/test/java/bdd/features/",
			   glue = "bdd.steps.webmail",
			   tags = {"@webmail"},
			   plugin = {"pretty:target/cucumber/google-pretty.txt","html:target/cucumber/google","json:target/cucumber/google.json","junit:target/cucumber/google-results.xml"})
			 public class Test extends AbstractTestNGCucumberTests {
			  
			 }
}
