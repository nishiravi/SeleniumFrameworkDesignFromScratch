package BaseComponents.Abstractcomponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {

    WebDriver driverAbstractComponent;
    @FindBy(xpath = "//button[contains(@routerlink,'/dashboard/cart')]")
    WebElement cart;
    public AbstractComponent(WebDriver driver) {
        this.driverAbstractComponent = driver;
        PageFactory.initElements(driver,this);
    }

    public void waitforTheElementToAppear(By visibleLocator) {
        WebDriverWait wait = new WebDriverWait(driverAbstractComponent, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(visibleLocator));
    }
    public void waitforTheElementToAppear(WebElement visibleWebelement) {
        WebDriverWait wait = new WebDriverWait(driverAbstractComponent, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(visibleWebelement));
    }

    public void waitforTheElementToDisAppear(By invisibleLocator) {
        WebDriverWait wait = new WebDriverWait(driverAbstractComponent, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(invisibleLocator));
    }

    public void gotoCartpage() {
        cart.click();
    }
}
