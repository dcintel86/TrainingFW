package bdd.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

public class GoogleRunner {
	 @CucumberOptions(features = "src/test/java/bdd/features/",
			   glue = "bdd.steps",
			   tags = {"@google_wiki"},
			   plugin = {"pretty:target/cucumber/google-pretty.txt","html:target/cucumber/google","json:target/cucumber/google.json","junit:target/cucumber/google-results.xml"})
			 public class Test extends AbstractTestNGCucumberTests {
			  
			 }
}
