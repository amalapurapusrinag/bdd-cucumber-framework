package stepDefs;

import com.epam.reportportal.service.ReportPortal;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import test.Browsers;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;

public class MyStepdef1 {

    WebDriver driver;

    HomePage homePage;

    @Before
    public void setUp() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\Srinag_Amalapurapu\\IdeaProjects\\test_ui\\src\\test\\resources\\webdriver\\chromedriver.exe"
        );       // System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("user launches portal")
    public void userLaunchesPortal() {
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterStep
    public void takeScreenShotAndPublishRP(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFileToDirectory(screenshot, new File(System.getProperty("user.dir") + "/src/test/screenshot"));
            ReportPortal.emitLog("Taking ScreenShot", "INFO",
                    Calendar.getInstance().getTime(), screenshot);
        }
    }

    @When("user clicks on signup on the homepage")
    public void userClicksOnSignupOnTheHomepage() {
        homePage= new HomePage(driver);
        homePage.clickSignup();

    }

    @Then("user navigates to the signup page")
    public void user_navigates_to_the_signup_page() {

    }

    @When("user enters {string} as email")
    public void user_enters_as_email(String string) {

    }
    @When("user enters {string} as password")
    public void user_enters_as_password(String string) {

    }
    @After
    public void tearDown() {
        driver.quit();
    }
}