package rahulsheetyacademy.Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import rahulsheetyacademy.pageObjects.*;
import rahulshettyacademy.TestComponents.BaseTest;

import java.io.IOException;

public class SubmitOrderTest extends BaseTest {
    @Test
    public void submitorder() throws IOException {
          //@Beforemethod in base Test class contains code for intializing driver and launching the application
        String productName = "ZARA COAT 3";// product to be selected
        String userEmail = "selenium@abc.com";
        String userPassword = "selenium";
        String countryName = "IND";
        ProductCatalogue pc = lp.loginApplication(userEmail, userPassword);
        pc.getProductList();
        pc.getProductName(productName); // get the product to be added to the cart
        Cartpage cp = pc.addToCart(productName);//product to be added to the cart and click on cart
        boolean match = cp.validateproductCheckout(productName);
        Assert.assertTrue(match);
        Paymentpage pp = cp.checkout();
        pp.enterPaymentdetails(countryName);
        Confirmationpage confirmpage = pp.placeOrder();
        confirmpage.orderdetails();
        Assert.assertEquals(confirmpage.verifyconfirmationmsg(), "THANKYOU FOR THE ORDER.");
        //Aftermethod in basetest class has code to close the driver
    }
    @Test(dependsOnMethods = {"submitorder"})
    public void orderHistoryCheck()
    {

    }
}

