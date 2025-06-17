package com.example.hooks;

import com.example.logger.Log;
import io.cucumber.java.*;

import static io.github.the_sdet.adapter.CucumberSummaryReporter.registerTestUser;


@SuppressWarnings("unused")
public class Hook {
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
        registerTestUser(scenario.getUri().toString(), "Swain", "Pabitra");
    }

    @After
    public void afterTest(Scenario scenario) {
        registerTestUser(scenario.getUri().toString(), "runtime@gmail.com", "runtimePass$#");
        Log.info("Scenario Completed...");
    }
}