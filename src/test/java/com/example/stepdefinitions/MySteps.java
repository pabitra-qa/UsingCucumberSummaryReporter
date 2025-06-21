package com.example.stepdefinitions;

import com.example.logger.Log;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Then;
import io.cucumber.plugin.event.Status;
import io.github.the_sdet.adapter.CucumberSummaryReporter;

import java.util.Map;

import static io.github.the_sdet.adapter.CucumberSummaryReporter.getSummaryData;


public class MySteps {
    @Then("Test Step One Feature One")
    public void testStepOneFeatureOne() {
    }

    @Then("Test Step Tow Feature One")
    public void testStepTowFeatureOne() {
    }

    @Then("Test Step One Feature Two")
    public void testStepOneFeatureTwo() {
    }

    @Then("Test Step Tow Feature Three")
    public void testStepTowFeatureThree() {
    }

    @Then("Test Step Tow Feature Two")
    public void testStepTowFeatureTwo() {
    }

    @Then("Test Step One Feature Three")
    public void testStepOneFeatureThree() {
    }

    @AfterAll
    public static void afterAll() throws Exception {
        CucumberSummaryReporter.SummaryData summaryData = getSummaryData();
        Map<String, Map<String, Status>> results = summaryData.results;
        for (Map.Entry<String, Map<String, Status>> entry : results.entrySet()) {
            Log.info("Feature Name: " + entry.getKey());
            for (Map.Entry<String, Status> scenario : entry.getValue().entrySet()) {
                Log.info("\tScenario Name: " + scenario.getKey());
                Log.info("\tScenario Status: " + scenario.getValue().name());
            }
        }
    }

    @Then("Test Step {string} Feature Three")
    public void testStepFeatureThree(String str) {
    }
}
