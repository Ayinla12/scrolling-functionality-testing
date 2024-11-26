package scroll;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class UpAndDown {

    @Test
    public void scrollUp() {
        // Opens  homepage

        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement consentButton =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Consent']")));
            consentButton.click();

        }catch (Exception e){
            System.out.println("Consent Button not displayed");
        }

        // Verifies homepage loaded correctly
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Automation Exercise");

        // scrolls to the "SUBSCRIPTION" section
        WebElement subscribe = driver.findElement(By.id("subscribe"));
        Actions pageDown = new Actions(driver);
        pageDown.moveToElement(subscribe).perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"scrollUp\"]"))).click();

        // Verifies "Full-Fledged practice website for Automation Engineers" text
        String message = driver.findElement(By.xpath("//body/section[@id='slider']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h2[1]")).getText();
        Assert.assertEquals(message, "Full-Fledged practice website for Automation Engineers");
        //closes browser
        driver.quit();

    }

    @Test
    public void scrollDown() {
        // Opens homepage
        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement consentButton =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Consent']")));
            consentButton.click();

        }catch (Exception e){
            System.out.println("Consent Button not displayed");
        }

        // Verifies homepage loaded correctly
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Automation Exercise");
        // scrolls to the "SUBSCRIPTION" section
        WebElement subscribe = driver.findElement(By.id("subscribe"));
        Actions pageDown = new Actions(driver);
        pageDown.moveToElement(subscribe).perform();
        WebElement image = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img"));
        pageDown.moveToElement(image).perform();
        //closes browser
        driver.quit();
    }

}
