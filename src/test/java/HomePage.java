//package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/** Home page #1.*/
public class HomePage {
    /** Constructor.
     * @param driver */
    public HomePage(final WebDriver driver) {
        wait = new WebDriverWait(driver, 10,
                500);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /** Wait. */
    private Wait<WebDriver> wait;

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

    /** Waiting method. */
    public void pageWaiting() {
        wait.until(ExpectedConditions.
                titleContains("Welcome"));
    }

    /** Sign-In as method.
     * @param login is user login
     * @param password is user password */
    public void signInAs(final String login, final String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        signInButton.click();
    }
}
