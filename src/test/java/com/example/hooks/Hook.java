package com.example.hooks;

import com.example.logger.Log;
import io.cucumber.java.*;

import static io.github.the_sdet.adapter.CucumberSummaryReporter.registerTestUserForScenario;

@SuppressWarnings("unused")
public class Hook {
    static int counter = 1;

    @BeforeAll
    public static void beforeAll() {
        System.setProperty("cucumber.summary.env.url", "https://github.com/the-sdet");
    }

    @AfterAll
    public static void afterAll() {
        System.setProperty("cucumber.summary.executed.by", "Pabitra");
    }

    @Before
    public void beforeTest(Scenario scenario) {
        Log.info("Scenario Started...");
    }

    @After
    public void afterTest(Scenario scenario) {
        registerTestUserForScenario(scenario, "contact.the.sdet." + counter + "@gmail.com", "cucumberSummary@" + counter);
        Log.info("Scenario Completed...");
        counter++;
    }
}