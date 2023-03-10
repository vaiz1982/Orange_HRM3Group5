package Project3;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class ShtefansTC_updPicLessThan1MB extends DriverClass {

    // This might will need with a newer version of Chrome
    /*void uploading() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));*/

    @Test(description = "Test to Login to OrangeHRM as an Admin")
    public void login() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait(1);
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        username.sendKeys("Admin");
        password.sendKeys("admin123");
    }

    @Test(description = "Upload of Invalid picture format which is less than 1 MB")
    void uploadPicture() {

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        wait(1);

        WebElement myInfo = driver.findElement(By.xpath("//span[normalize-space()='My Info']"));
        myInfo.click();

        wait(1);

        WebElement profileIcon = driver.findElement(By.xpath("//img[@class='employee-image']"));
        profileIcon.click();

        wait(1);

        // copying File path to Clipboard
        String pathForPicture = "/Users/shtefanuz/Desktop/sleepy.jpeg";
        WebElement chooseFile = driver.findElement(By.cssSelector("input[type='file']"));
        chooseFile.sendKeys(pathForPicture);
        wait(2);


        WebElement saveButton = driver.findElement(By.xpath("//button[@type='submit']"));
        saveButton.click();

        wait(5);

    }
}