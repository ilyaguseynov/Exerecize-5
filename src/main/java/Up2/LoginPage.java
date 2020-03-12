package Up2;

import Up2.MainPage.MainPageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    ///////////////////////////////////////////////////
    ////////////// Objects ////////////////////////////
    private By LoginField = By.xpath("//input[@placeholder='Логин']");
    private By PasswordField = By.xpath("//input[@placeholder='Пароль']");
    private By LoginButton = By.xpath("//button[@class='ant-btn ant-btn-primary']");


    ///////////////////////////////////////////////////
    ////////////// Actions ////////////////////////////
    public LoginPage writeLogin (String Login) {
        writeText(LoginField, Login);
        return this;
    }

    public LoginPage writePassword (String Password) {
        writeText(PasswordField, Password);
        return this;
    }

    public LoginPage clickLoginButton() {
        click(LoginButton);
        return new LoginPage(driver);
    }

    public MainPageElements signIn(String Login, String Password) {
        writeLogin(Login);
        writePassword(Password);
        clickLoginButton();
        return new MainPageElements(driver);
    }
}
