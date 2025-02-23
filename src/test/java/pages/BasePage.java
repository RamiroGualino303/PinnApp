package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BasePage {

   
    protected static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    static{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    public static void closeBrowser(){
        driver.quit();
    }

    /// FUNCIONES PARA  INTERACTUAR CON ELEMENTOS
    
    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator){
        Find(locator).click();
    }

    public void write(String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public void sendKeys(String locator, String textToWrite){
        Find(locator).sendKeys(textToWrite);
    }

    public String textFromElement(String locator){ 
        return Find(locator).getText();
    }

    public boolean elementIsDisplayed(String locator){ 
        return Find(locator).isDisplayed();
    }
   
    public boolean elementEnabled(String locator){
        return Find(locator).isEnabled();
    }

    
}
