package automation.hui.cucumber.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "@target/failed-tests/rerun.txt" }, glue = { "automation.hui.steps" }, plugin = {
		"pretty" })
public class Rerunner {

}
