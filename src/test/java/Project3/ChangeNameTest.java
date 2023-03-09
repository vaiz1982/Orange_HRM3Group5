package Project3;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class ChangeNameTest extends DriverClass {

    @Test
    public void login()  {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement nameBox = driver.findElement(By.xpath("//input[@name='username']"));
       nameBox.sendKeys("Admin");
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordBox.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

    }


    @Test
    public void changeFirstName() throws InterruptedException {
       login();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='PIM'])[1]")));

WebElement PIM = driver.findElement(By.xpath("(//*[text()='PIM'])[1]"));
PIM.click();



    List<WebElement> employe = driver.findElements(By.xpath("//*[@class='oxd-table-body']"));
        for (int i = 0; i < employe.size(); i++) {
            int randomEmploy = (int)(Math.random()* employe.size());
            employe.get(randomEmploy).click();

        }


        Actions action=new Actions(driver);
        Thread.sleep(5000);
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
        action.doubleClick(firstName).perform();


        Thread.sleep(5000);
        firstName.sendKeys(Keys.DELETE);
       Thread.sleep(5000);
        firstName.sendKeys("Ariel");

        WebElement saveButton = driver.findElement(By.xpath("//button[@type='submit']"));
        saveButton.click();
         driver.navigate().refresh();

        Assert.assertTrue(firstName.getText().equals("Ariel"),"test is failed");



    }


}
