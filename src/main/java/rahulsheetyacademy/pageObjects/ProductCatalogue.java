package rahulsheetyacademy.pageObjects;

import BaseComponents.Abstractcomponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class ProductCatalogue extends AbstractComponent {

    WebDriver driverProductcatalogue;
    @FindBy(css=".offset-sm-1")
    List<WebElement> productsList;
    By productsLocator = By.cssSelector(".offset-sm-1");
    By addtoCartButton = By.cssSelector(".rounded  .fa-shopping-cart");
    By toastmessage = By.cssSelector("#toast-container");
    By loader = By.cssSelector(".ng-animating");

    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driverProductcatalogue = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getProductList() // get all the products present in the web page
    {
        waitforTheElementToAppear(productsLocator);
        return productsList;
    }

    public WebElement getProductName(String productName)// select the product to be added from the lis of products
    {
        WebElement prod = productsList.stream().filter(s -> s.findElement(By.cssSelector("b")).getText().equals(productName))
                .findFirst().orElse(null);
        return prod;
    }

    public Cartpage addToCart(String productName) {
        WebElement itemTobeSelected = getProductName(productName);
        itemTobeSelected.findElement(addtoCartButton).click();
        waitforTheElementToAppear(toastmessage);
        waitforTheElementToDisAppear(loader);
        gotoCartpage();
        return new Cartpage(driverProductcatalogue);
    }
}
