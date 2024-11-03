package io.github.the_sdet.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.the_sdet.logger.Log;

import java.util.Arrays;

import static io.github.the_sdet.adapter.CucumberSummaryReporter.testUsers;

@SuppressWarnings("unused")
public class Hook {

    @Before
    public void beforeTest(Scenario scenario) {
        Log.info("Scenario Started...");
    }

    @After
    public void afterTest(Scenario scenario) {
        testUsers.put(String.valueOf(scenario.getUri()), Arrays.asList("runtime@gmail.com", "runtimePass$#"));
        Log.info("Scenario Completed...");
    }
}