package rahulsheetyacademy.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String productName = "ADIDAS ORIGINAL";
        driver.get("https://rahulshettyacademy.com/client");
        // CODE TO LOGIN
        driver.findElement(By.id("userEmail")).sendKeys("selenium@abc.com");
        driver.findElement(By.id("userPassword")).sendKeys("selenium");
        driver.findElement(By.id("login")).click();
        // CODE TO FETCH ALL THE PRODUCTS
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
        // CODE TO FIND THE MENTIONED PRODUCT NAME
        WebElement prod = products.stream().filter(s -> s.findElement(By.cssSelector("b")).getText().equals(productName))
                .findFirst().orElse(null);
        // CODE TO CLICK ADD TO CART ON THE PRODUCT WEBELEMENT
        prod.findElement(By.cssSelector(".rounded  .fa-shopping-cart")).click();
        // EXPLICIT WAIT CODE
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // CODE TO WAIT FOR THE TOASTER TO VISIBLE AND DISAPPEAR
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        //CODE FOR LODER TO DISAPPER
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
        // CODE TO CLICK ON CART
        driver.findElement(By.xpath("//button[contains(@routerlink,'/dashboard/cart')]")).click();
        // FETCH ALL THE PRODUCTS ADDED IN THE CHECKOUT PAGE AND
        // VERIFY IF IT MATCHED WITH PRODUCT USER WANTED TO SELECT
        List<WebElement> productCheckout = driver.findElements(By.cssSelector(".cartSection h3"));
        Assert.assertTrue(productCheckout.stream().anyMatch(items -> items.getText().equals(productName)));
        driver.findElement(By.xpath("//button[text()=\"Checkout\"]")).click();
        // CODE TO ENTER THE COUNTRY NAME IN THE TAB USING MOUSE ACTION CLASS
        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector(".form-group")), "IND").build().perform();
        // WAIT TILL THE DROPDOWN TABLE IS DISPLAYED AFTER SEARCH
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        // CODE TO CLICK ON THE COUNTRY FROM THE DROPDOWN
        driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
        // CODE TO CLICK ON PLACE ORDER
        driver.findElement(By.cssSelector(".action__submit")).click();
        // CODE TO FETCH THE ORDER NUMBER FROM THE ORDER PLACED PAGE
        System.out.println(" order number is   " + driver.findElement(By.cssSelector(".em-spacer-1 .ng-star-inserted")).getText());


    }
}


// Description :
// Testcase to login,
// select an item ,
// click on cart,
// Checkout ,
// select country ,
// place Order
// fetch the order id