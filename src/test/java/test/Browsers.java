package test;
import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;
import junitparams.Parameters;

public class Browsers {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Parameters("browserName")
    public void setUp(@Optional("Chrome") String browserName) throws MalformedURLException {
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }


        driver.get("http://epinhydw1001/programs/#/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

}
