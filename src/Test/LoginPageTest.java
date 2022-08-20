package Test;

import POM.LoginPageElements;
import POM.MyAccountPageElement;
import Utils.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPageTest extends BaseDriver {

    LoginPageElements logInPageElements;
    MyAccountPageElement myAccountPageElements;

    @Test(priority = 1, dataProvider = "LogInData")
    public void loginPositiveTest(String userName, String password) {
        logInPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElement(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        logInPageElements.logIn.click();
        logInPageElements.inputEmail.sendKeys(userName);
        logInPageElements.inputPassword.sendKeys(password);
        logInPageElements.logInButton.click();
        String actualMessage= myAccountPageElements.welcomeMessage.getText();
        String expectedMessage= "Welcome to our store";
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test(priority = 2,dataProvider = "LogInData2")
    public void loginNegativeTest2(String userName, String password) {
        logInPageElements= new LoginPageElements(driver);
        myAccountPageElements= new MyAccountPageElement(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        logInPageElements.logIn.click();
        logInPageElements.inputEmail.sendKeys(userName);
        logInPageElements.inputPassword.sendKeys(password);
        logInPageElements.logInButton.click();

        String actualError= logInPageElements.errorMessage.getText();
        String expectedError="Login was unsuccessful. Please correct the errors and try again.";
        Assert.assertEquals(actualError,expectedError);
    }

    @Test(priority = 3,dataProvider = "LogInData3")
    public void loginNegativeTest3(String userName, String password) {
        logInPageElements= new LoginPageElements(driver);
        myAccountPageElements= new MyAccountPageElement(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        logInPageElements.logIn.click();
        logInPageElements.inputEmail.sendKeys(userName);
        logInPageElements.inputPassword.sendKeys(password);
        logInPageElements.logInButton.click();

        String actualError= logInPageElements.errorMessage.getText();
        String expectedError="Login was unsuccessful. Please correct the errors and try again.";
        Assert.assertEquals(actualError,expectedError);

    }

    @Test(priority = 4,dataProvider = "LogInData4")
    public void loginNegativeTest4(String userName, String password) {
        logInPageElements= new LoginPageElements(driver);
        myAccountPageElements= new MyAccountPageElement(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        logInPageElements.logIn.click();
        logInPageElements.inputEmail.sendKeys(userName);
        logInPageElements.inputPassword.sendKeys(password);
        logInPageElements.logInButton.click();

        String actualError= logInPageElements.errorMessage.getText();
        String expectedError="Login was unsuccessful. Please correct the errors and try again.";
        Assert.assertEquals(actualError,expectedError);

    }
    @DataProvider(name = "LogInData") // Enter your correct email and correct password
    public Object [][] testDataProvider() {
        return new Object[][] { {"nilkomurcu35@gmail.com","yalandünya"}};
    }
    @DataProvider(name = "LogInData2") // Enter your incorrect email and correct password
    public Object [][] testDataProvider2() {
        return new Object[][] { {"nilkomurcu@gmail.com","yalandünya"} };
    }
    @DataProvider(name = "LogInData3") // Enter your correct email and incorrect password
    public Object [][] testDataProvider3() {
        return new Object[][] { {"nilkomurcu35@gmail.com","ylndny"} };
    }
    @DataProvider(name = "LogInData4") // Enter your incorrect email and incorrect password
    public Object [][] testDataProvider4() {
        return new Object[][]{{"nlkmr353535335@gmail.com", "dünyaaa"}};
    }

}
