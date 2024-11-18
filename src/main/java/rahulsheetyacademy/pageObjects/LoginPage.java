package rahulsheetyacademy.pageObjects;

import BaseComponents.Abstractcomponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponent {

    WebDriver driverLandingPage;
    // Webelements present in the Login page
    @FindBy(id = "userEmail")
    WebElement emailID;
    @FindBy(id="userPassword")
    WebElement password;
    @FindBy(id="login")
    WebElement login;
    @FindBy(css="[class*='flyInOut']")
    WebElement loginerrormessage;
    public LoginPage(WebDriver driver)
    {
        super(driver);
        this.driverLandingPage=driver;
        PageFactory.initElements(driver,this);
    }

    public void gotoURL()
    {
        driverLandingPage.get("https://rahulshettyacademy.com/client");
    }
    public ProductCatalogue loginApplication(String userEmail, String userPassword)
    {
        emailID.sendKeys(userEmail);
        password.sendKeys(userPassword);
        login.click();
       return  new ProductCatalogue(driverLandingPage);
    }
    public String loginErrorMessage()
    {
        waitforTheElementToAppear(loginerrormessage);
       String errormsg= loginerrormessage.getText();
       return errormsg;
    }
}
