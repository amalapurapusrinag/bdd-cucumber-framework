package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    public HomePage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id=\"nav-link-accountList-nav-line-1\"]")
    private WebElement signupbuttonclick;


    public HomePage clickSignup(){
        signupbuttonclick.click();
        return this;
    }






}
