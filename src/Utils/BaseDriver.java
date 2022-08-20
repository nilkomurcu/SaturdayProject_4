package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseDriver {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true) // This one is always come first
    @Parameters({"browser"})
    public void setup(String browser) {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\nile17PC\\Desktop\\nil\\CromeDriver\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            ChromeOptions options = new ChromeOptions(); // This is a extra also given a option
            options.addArguments("startmaximized");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,200)");
            driver.manage().window().maximize();
            driver.get("http://demowebshop.tricentis.com/");
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.firefox.driver", "C:\\Users\\nile17PC\\Desktop\\nil\\CromeDriver\\chromedriver.exe");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("startmaximized");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,200)");
            driver.manage().window().maximize();
            driver.get("http://demowebshop.tricentis.com");
        }
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    // Those are the method we are gonna always do
}
