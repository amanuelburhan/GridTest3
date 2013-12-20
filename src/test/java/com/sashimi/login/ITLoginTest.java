package com.sashimi.login;


import org.junit.runner.RunWith;
import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(tags="@SashimiLogin", format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})


public class ITLoginTest {

}
