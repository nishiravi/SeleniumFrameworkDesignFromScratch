package rahulsheetyacademy.pageObjects;

import BaseComponents.Abstractcomponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class Cartpage extends AbstractComponent {

    WebDriver driverCheckoutpage;
    @FindBy(css =".cartSection h3")
    List<WebElement> checkoutProducts;
    @FindBy(xpath ="//button[text()=\"Checkout\"]")
    WebElement checkoutbutton;

    public Cartpage(WebDriver driver) {
        super(driver);
        this.driverCheckoutpage=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean validateproductCheckout(String productName)
    {

        boolean  match=checkoutProducts.stream().anyMatch(items -> items.getText().equals(productName));
      return match;
    }
    public Paymentpage checkout()
    {
        checkoutbutton.click();
        return new Paymentpage(driverCheckoutpage);
    }
}
