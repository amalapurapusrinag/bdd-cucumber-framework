package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features" },
         glue = "stepDefs",
//         tags = "@Smoke",
//        dryRun = true,
        plugin ={"pretty","json:target/cucumber-report/cucumber.json",
                "html:target/cucumber-report/cucumber_report.html",
                "com.epam.reportportal.cucumber.StepReporter"
        } )

public class CucumberTestRunner {
}
