package Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AslanbekPOMFile {
    public AslanbekPOMFile() {
        PageFactory.initElements(DriverClass.driver,this);
    }

    @FindBy(name = "username")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(css = "button[type='submit']")
    public WebElement submitBtn;

    @FindBy(xpath = "//span[text()='My Info']")
    public WebElement myInfo;

    @FindBy(xpath = "(//img[@alt='profile picture'])[2]")
    public WebElement img;

    @FindBy(css = ".oxd-icon.bi-plus")
    public WebElement addImg;

    @FindBy(xpath = "//span[text()='Attachment Size Exceeded']")
    public WebElement docFile;
}
