package br.com.rsinet.hub_bdd.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "br.com.rsinet.hub_bdd.stepDefinitions" })
public class TestRunner {

}