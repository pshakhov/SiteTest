import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy(xpath = "//input[@name = 'userName']")
    WebElement loginField;

    @FindBy(xpath = "//input[@name = 'password'][@type = 'password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@name = 'login'][@value = 'Login']")
    WebElement signInButton;

    public void login(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        signInButton.click();
    }
}
