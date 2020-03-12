package Up2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;


    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    //Wait method
    public void waitVisibility (By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void waitVisibilityText (By elementBy, String text) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(elementBy, text));
    }

    public void waitInvisibilityOfTheElementLocated (By elementBy) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
    }

    //Click method
    public void click (By elementBy) {
        driver.findElement(elementBy).click();
    }

    public void clickEnter (By elementBy) {
        driver.findElement(elementBy).sendKeys(Keys.ENTER);
    }

    //Write text
    public void writeText (By elementBy, String text) {
        driver.findElement(elementBy).sendKeys(text);
    }

    //Get text
    public String getText (By elementBy) {
        return driver.findElement(elementBy).getText();
    }

    // isSelected method
    public Boolean isSelected (By elementBy) {
        return driver.findElement(elementBy).isSelected();
    }

    public Integer sizeOfElements (By elementBy) {
        return driver.findElements(elementBy).size();
    }

}
