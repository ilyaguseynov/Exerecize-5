package Up2.MainPage;

import Up2.BasePage;
import Up2.MainPage.Objects.Tasks.NewTaskCreation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageElements extends BasePage {

    public MainPageElements(WebDriver driver) {
        super(driver);
    }

    ///////////////////////////////////////////////////
    ////////////// Objects ////////////////////////////

    private By ObjectButton = By.xpath("//div [@class = 'left-menu__top']//a [@href = '/objects']");
    private By EllipsisButton = By.xpath("//div[@class='top-menu__right']//button[2]");
    private By LogOutButton = By.xpath("//a [@href = '/logout']");

    ///////////////////////////////////////////////////
    ////////////// Actions ////////////////////////////

    public NewTaskCreation clickObjectButton () {
        click(ObjectButton);
        return new NewTaskCreation(driver);
    }

    public MainPageElements clickEllipsisButton () {
        click(EllipsisButton);
        return this;
    }

    public void clickLogOutButton () {
        click(LogOutButton);
    }

    public void logOut () {
        clickEllipsisButton();
        clickLogOutButton();
    }
}
