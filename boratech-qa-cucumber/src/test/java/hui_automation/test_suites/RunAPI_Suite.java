package hui_automation.test_suites;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.ConfigurationParameter;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("hui_features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "hui_automation.steps.api")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/html_reports/index.html, json:target/json_reports/index.json")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@api and @login")
public class RunAPI_Suite {
}
