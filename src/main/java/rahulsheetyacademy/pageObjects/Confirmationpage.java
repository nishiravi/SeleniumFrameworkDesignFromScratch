package rahulsheetyacademy.pageObjects;

import BaseComponents.Abstractcomponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Confirmationpage extends AbstractComponent {
    WebDriver driverConfirmationpage;
    @FindBy(css=".em-spacer-1 .ng-star-inserted")
    WebElement orderid;
    @FindBy(css=".hero-primary")
    WebElement confirmationmsg;
    public Confirmationpage(WebDriver driver)
    {
        super(driver);
        this.driverConfirmationpage=driver;
        PageFactory.initElements(driver,this);
    }
    public String verifyconfirmationmsg()
    {
       return confirmationmsg.getText();
    }
    public void orderdetails()
    {
        System.out.println(" order number is   " + orderid.getText());
    }
}
