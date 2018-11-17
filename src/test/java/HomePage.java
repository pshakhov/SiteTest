//package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Home page #1.*/
public class HomePage {
    /** Constructor.
     * @param driver */
    public HomePage(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /** Driver.*/
    public WebDriver driver;

    /** Login field.*/
    @FindBy(xpath = "//input[@name = 'userName']")
    WebElement loginField;

    /** Password field.*/
    @FindBy(xpath = "//input[@name = 'password'][@type = 'password']")
    WebElement passwordField;

    /** Sign-In button.*/
    @FindBy(xpath = "//input[@name = 'login'][@value = 'Login']")
    WebElement signInButton;

    /** Sign-In as method.
     * @param login is user login
     * @param password is user password */
    public void signInAs(final String login, final String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        signInButton.click();
    }
}
