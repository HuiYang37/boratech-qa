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
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, " + "html:target/html_reports/cucumber.html, "
		+ "json:target/json_reports/cucumber.json, " + "rerun:target/rerun.txt, "
		+ "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:")
@ConfigurationParameter(key = PARALLEL_EXECUTION_ENABLED_PROPERTY_NAME, value = "true")
@ConfigurationParameter(key = PARALLEL_CONFIG_STRATEGY_PROPERTY_NAME, value = "fixed")
@ConfigurationParameter(key = PARALLEL_CONFIG_FIXED_PARALLELISM_PROPERTY_NAME, value = "1")
@ConfigurationParameter(key = PARALLEL_CONFIG_FIXED_MAX_POOL_SIZE_PROPERTY_NAME, value = "3")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@ui or @e2e")
public class RunParallelSuite {

}
