package main;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.time.Duration;

public class MobileReplenishmentTest {

    /**
     * All UI Elements:
     **/

    By phoneNumber = By.xpath("//input[@data-qa-node='phone-number']");
    By amount = By.xpath("//input[@data-qa-node='amount']");
    By cardNumber = By.xpath("//input[@data-qa-node='numberdebitSource']");
    By expiredDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
    By cvvCode = By.xpath("//input[@data-qa-node='cvvdebitSource']");
    By firstName = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
    By lastName = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
    By submitBtn = By.xpath("//button[@data-qa-node='submit']");
    By details = By.xpath("//div[@data-qa-node='details']");
    By actualCardNumber = By.xpath("//td[@data-qa-node='card']");
    By actualMobileOperator = By.xpath("//span[@data-qa-node='nameB']");
    By actualAmount = By.xpath("//div[@data-qa-node='amount']");
    /**
     * All Test Data
     **/

    String phoneNumberValue = "6326401690";
    String amountMinValue = "1";
    String amountMaxValue = "8000";
    String amountValue = "123";
    String cardNumberValue = "4004159115449003";
    String expiredDateValue = "1126";
    String cvvCodeValue = "134";
    String firstNameValue = "TEST";
    String lastNameValue = "TESTOVICH";

    WebDriver driver;


    @BeforeEach
    void openDriver(){
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://next.privat24.ua/mobile");
    }


    @AfterEach
    void closeDriver(){
       driver.quit();
    }


    @Test
    void checkMinSum(){

        // path to driver
        // System.setProperty("WebDriver driver", "src\\resources\\msedgedriver.exe");
        // Create a new object driver for the Edge browser, that contains WebDriver methods

        /**
         * Expected data
         * */
        String expectedSum = "1 UAH";
        String expectedPhoneNumber = "Поповнення телефону. На номер +380632640169";
        String expectedCardNumber = "4004 **** **** 9003";
        String expectedMobileOperator = "Lifecell Ukraine";

        driver.findElement(phoneNumber).sendKeys(phoneNumberValue);
        driver.findElement(amount).sendKeys(Keys.CONTROL, "a");
        driver.findElement(amount).sendKeys(Keys.DELETE);
        // driver.findElement(amount).clear();
        driver.findElement(amount).sendKeys(amountMinValue);
        driver.findElement(cardNumber).sendKeys(cardNumberValue);
        driver.findElement(expiredDate).sendKeys(expiredDateValue);
        driver.findElement(cvvCode).sendKeys(cvvCodeValue);
        driver.findElement(firstName).sendKeys(firstNameValue);
        driver.findElement(lastName).sendKeys(lastNameValue);
        driver.findElement(submitBtn).submit();

        // Compare ER with AR
        Assertions.assertEquals(expectedPhoneNumber, driver.findElement(details).getText());
        Assertions.assertEquals(expectedCardNumber, driver.findElement(actualCardNumber).getText());
        Assertions.assertEquals(expectedMobileOperator, driver.findElement(actualMobileOperator).getText());
        Assertions.assertEquals(expectedSum, driver.findElement(actualAmount).getText());


    }

    @Test
    void checkMaxSum(){

        /**
         * Expected data
         * */
        String expectedSum = "8 000 UAH";
        String expectedPhoneNumber = "Поповнення телефону. На номер +380632640169";
        String expectedCardNumber = "4004 **** **** 9003";
        String expectedMobileOperator = "Lifecell Ukraine";

        driver.findElement(phoneNumber).sendKeys(phoneNumberValue);
        driver.findElement(amount).sendKeys(Keys.CONTROL, "a");
        driver.findElement(amount).sendKeys(Keys.DELETE);
        driver.findElement(amount).sendKeys(amountMaxValue);
        driver.findElement(cardNumber).sendKeys(cardNumberValue);
        driver.findElement(expiredDate).sendKeys(expiredDateValue);
        driver.findElement(cvvCode).sendKeys(cvvCodeValue);
        driver.findElement(firstName).sendKeys(firstNameValue);
        driver.findElement(lastName).sendKeys(lastNameValue);
        driver.findElement(submitBtn).submit();

        // Compare ER with AR
        Assertions.assertEquals(expectedPhoneNumber, driver.findElement(details).getText());
        Assertions.assertEquals(expectedCardNumber, driver.findElement(actualCardNumber).getText());
        Assertions.assertEquals(expectedMobileOperator, driver.findElement(actualMobileOperator).getText());
        Assertions.assertEquals(expectedSum, driver.findElement(actualAmount).getText());

    }


    @Test
    void checkExceedsMaxSum(){

        /**
         * Expected data
         * */
        String expectedSum = "8 001 UAH";

        driver.findElement(phoneNumber).sendKeys(phoneNumberValue);
        driver.findElement(amount).sendKeys(Keys.CONTROL, "a");
        driver.findElement(amount).sendKeys(Keys.DELETE);
        driver.findElement(amount).sendKeys(expectedSum);
        // driver.findElement(cardNumber).sendKeys(cardNumberValue);
        // driver.findElement(expiredDate).sendKeys(expiredDateValue);
        // driver.findElement(cvvCode).sendKeys(cvvCodeValue);
        // driver.findElement(firstName).sendKeys(firstNameValue);
        // driver.findElement(lastName).sendKeys(lastNameValue);

        driver.findElement(submitBtn).submit();

        Assertions.assertFalse(driver.findElements(submitBtn).isEmpty());
        Assertions.assertTrue(driver.findElement(submitBtn).isDisplayed());
        Assertions.assertTrue(driver.findElement(submitBtn).isEnabled());
        Assertions.assertEquals("Максимальна сума поповнення 8000 UAH",
                driver.findElement(By.xpath("//div[@class='sc-hzhJZQ kOrPIp']")).getText());

    }

    @Test
    void checkExceedsExpDate(){

        /**
         * Expected data
         * */
        String expiredDateValue = "1123";

        driver.findElement(phoneNumber).sendKeys(phoneNumberValue);
        driver.findElement(amount).sendKeys(Keys.CONTROL, "a");
        driver.findElement(amount).sendKeys(Keys.DELETE);
        driver.findElement(amount).sendKeys(amountValue);
        driver.findElement(cardNumber).sendKeys(cardNumberValue);
        driver.findElement(expiredDate).sendKeys(expiredDateValue);
        driver.findElement(cvvCode).sendKeys(cvvCodeValue);
        //driver.findElement(firstName).sendKeys(firstNameValue);
        //driver.findElement(lastName).sendKeys(lastNameValue);

        driver.findElement(submitBtn).submit();

        Assertions.assertFalse(driver.findElements(submitBtn).isEmpty());
        Assertions.assertTrue(driver.findElement(submitBtn).isDisplayed());
        Assertions.assertTrue(driver.findElement(submitBtn).isEnabled());
        Assertions.assertEquals("Картка прострочена",
                driver.findElement(By.xpath("//div[@class='sc-hzhJZQ kOrPIp']")).getText());

    }
}




