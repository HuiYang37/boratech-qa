package automation.hui.cucumber.suites;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.ConfigurationParameter;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features.hui")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "automation.hui.steps")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/html_reports/cucumber.html, json:target/json_reports/cucumber.json")
@ConfigurationParameter(key = PLUGIN_PUBLISH_ENABLED_PROPERTY_NAME, value = "true")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@ui or @e2e")
public class RunRegressionSuite {

}
