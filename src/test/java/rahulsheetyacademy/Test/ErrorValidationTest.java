package rahulsheetyacademy.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import rahulsheetyacademy.pageObjects.ProductCatalogue;
import rahulshettyacademy.TestComponents.BaseTest;

import java.util.List;

public class ErrorValidationTest extends BaseTest {

    @Test
    public void loginErrorValidation() {
        String userEmail = "selenium@abc.com";
        String userPassword = "selenium****";
        lp.loginApplication(userEmail, userPassword);
        System.out.println(lp.loginErrorMessage());
        Assert.assertEquals(lp.loginErrorMessage(), "Incorrect email or password.");
    }
    @Test
    public void productIncorrecterror(){
        String product="ZARA COAT 3";
        String userEmail = "selenium@abc.com";
        String userPassword = "selenium****";
        ProductCatalogue p=lp.loginApplication(userEmail, userPassword);
    WebElement prod=p.getProductName(product);
   Assert.assertEquals(prod.getText(),"ZARA COAT 33");
    }


}
