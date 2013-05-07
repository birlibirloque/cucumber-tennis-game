package com.caf.examples.cucumber.tennis;

import cucumber.api.junit.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(
        //format={"pretty", "html:target/cucumber"},
        format={"pretty", "junit:target/cucumber-junit-report/allcukes.xml"},
        features="src/test/resources/"
        )

public class RunTest{

}
