package hui_automation.test_suites;

import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("hui_features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "hui_automation.steps")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/html_reports/index.html, json:target/json_reports/index.json")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@cleanup")
public class RunCleanupSuite {

}
