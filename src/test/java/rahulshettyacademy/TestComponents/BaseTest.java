package rahulshettyacademy.TestComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import rahulsheetyacademy.pageObjects.LoginPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public LoginPage lp;

    public WebDriver intializeDriver() throws IOException {
        Properties p = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\rnish\\Development\\workspcae2024\\SeleniumFrameworkDesign\\src\\main\\java\\BaseComponents\\Resources\\GlobalData.properties");
        p.load(fis);
        String browserName = p.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        return driver;
    }
@BeforeMethod
    public LoginPage launchApplication() throws IOException {
        driver = intializeDriver();
        lp = new LoginPage(driver);
        lp.gotoURL();
        return lp;
    }
    @AfterMethod
    public void closeBrowser()
    {
        driver.close();
    }
}
