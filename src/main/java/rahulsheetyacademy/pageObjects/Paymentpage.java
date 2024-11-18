package rahulsheetyacademy.pageObjects;

import BaseComponents.Abstractcomponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Paymentpage extends AbstractComponent {
    WebDriver driverpaymentpage;
    @FindBy(css = ".form-group")
    WebElement country;
    By waitfortabledata=By.cssSelector(".ta-results");
    @FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
    WebElement selectcountry;
    @FindBy(css = ".action__submit")
    WebElement placeorder;
    public Paymentpage(WebDriver driver)
    {
        super(driver);
        this.driverpaymentpage=driver;
        PageFactory.initElements(driver,this);
    }
public void enterPaymentdetails(String countryName) {
    Actions a = new Actions(driverpaymentpage);
    a.sendKeys(country,countryName).build().perform();
    // WAIT TILL THE DROPDOWN TABLE IS DISPLAYED AFTER SEARCH
    waitforTheElementToAppear(waitfortabledata);
    // CODE TO CLICK ON THE COUNTRY FROM THE DROPDOWN
    selectcountry.click();
}
public Confirmationpage placeOrder()
{
    // CODE TO CLICK ON PLACE ORDER
    placeorder.click();
    return new Confirmationpage(driverpaymentpage);
}
}
