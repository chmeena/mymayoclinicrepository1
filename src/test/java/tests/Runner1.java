package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"src\\test\\resources\\featuresset"},glue="gluecode",
monochrome=true,plugin= {"pretty","html:target/testfile.html","rerun:target/failedtest.txt"})
public class Runner1 extends AbstractTestNGCucumberTests
{

}
