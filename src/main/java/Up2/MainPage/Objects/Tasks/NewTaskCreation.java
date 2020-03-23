package Up2.MainPage.Objects.Tasks;

import Up2.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NewTaskCreation extends BasePage {

    public NewTaskCreation(WebDriver driver) {
        super(driver);
    }



    ///////////////////////////////////////////////////
    ////////////// Objects ////////////////////////////

    private By NameField = By.xpath("//input[@id='title']");
    private By HelloTab = By.xpath("//div [@class = 'tabs']//div [contains(text(),'Привет')]");
    private By AttachmentsTab = By.xpath("//div [@class = 'tabs']//div [contains(text(),'Вложения')]");
    private By HistoryTab = By.xpath("//div [@class = 'tabs']//div [contains(text(),'История')]");
    private By DescriptionTabTextField = By.xpath("//textarea [@name = 'description']");
    private By HelloTabInputDateOffField = By.xpath("//div [@class=\"ant-row ant-form-item custom-attributes__form__item\"]" +
            "//span [@class=\"Дата окончания (план)  ant-calendar-picker ant-calendar-picker-default\"]//input");
    private By HelloTabInputDateOffPanelTextField = By.xpath("//div [@class = 'ant-calendar']//input");
    private By HelloTabInputPriorityList = By.xpath("//div [@class = 'Приоритет  ant-select ant-select-enabled']//span[@class = 'ant-select-arrow']");
    private By HelloTabInputProjectList = By.xpath("//div [@class = 'Проект  ant-select ant-select-enabled']//span[@class = 'ant-select-arrow']");
    private By AttachmentsTabAddNewAttachmentButton = By.xpath("//div[@class = 'attachments']//i [@title = 'Добавить']");
    private By AttachmentsTabAddNewAttachmentButton_SelectFile = By.xpath("//span[@class='ant-upload']//input");
    private By AttachmentsTabDoneUploadFileButton = By.xpath("//div [@class = 'up2-dialog__actions']//span[text() = 'Добавить']/ancestor::button");
    private By HistoryTabTimeCheckbox = By.xpath("//input [@value = 'Списание времени']");
    private By HistoryTabTimeAllCheckboxes = By.xpath("//input [@type = 'checkbox']");
    private By ConfirmCreationOrModificationButton = By.xpath("//button[@class='ant-btn ant-btn-primary']");
    private By HelloTabSelectedProject = By.xpath("//div [@class = 'Проект  ant-select ant-select-enabled']//div[@class = 'ant-select-selection-selected-value']");
    private By CreateNewTaskForm = By.xpath("//div[contains(@class,'up2-dialog dialog1582884818078 up2-dialog--open up2-d");
    private By CloseButtonX = By.xpath("//button[@class='btn-close']");
    private By TaskState = By.xpath("//label[@title='Состояние']//ancestor::div[1]//following-sibling::div//div[@class='ant-select-selection-selected-value']");


    ///////////////////////////////////////////////////
    ////////////// Actions ////////////////////////////

    public String getSelectedProjectText () {
        return getText(HelloTabSelectedProject);
    }

    public String getSelectedTaskStateText () {
        return getText(TaskState);
    }

    public FindTask clickCloseButton () {
        click(CloseButtonX);
        waitInvisibilityOfTheElementLocated(CreateNewTaskForm);
        return new FindTask(driver);
    }

    public NewTaskCreation inputNewTaskName(String TaskName) {
        writeText(NameField, TaskName);
        return this;
    }
    
    public NewTaskCreation inputDescriptionTabTextField(String Decription) {
        writeText(DescriptionTabTextField, Decription);
        return this;
    }

    public NewTaskCreation goToHelloTab() {
        click(HelloTab);
        return this;
    }

    public NewTaskCreation clickHelloTabInputDateOffField() {
        click(HelloTabInputDateOffField);
        return this;
    }

    public NewTaskCreation inputHelloTabInputDateOffField(String DateOff) {
        writeText(HelloTabInputDateOffPanelTextField, DateOff);
        return this;
    }

    public void selectFromCombobox (String value) {
        click(By.xpath("//ul [@role = 'listbox']//li [text() = '" + value +"']"));
    }

    public void selectFromCombobox (Integer value) {
        click(By.xpath("//ul [@role = 'listbox']//li [text() = '" + value +"']"));
    }

//    public NewTaskCreation selectStateForTask (String state) {
//        click(TaskState);
//        click(By.xpath("//ul [@role = 'listbox']//li [text() = '" + state +"']"));
//        return this;
//        }

    public NewTaskCreation selectStateForTask (String state) {
        click(TaskState);
        selectFromCombobox(state);
        return this;
    }

    public NewTaskCreation selectPriorityForNewTask(Integer Priority) {
        click(HelloTabInputPriorityList);
        selectFromCombobox(Priority);
        return this;
    }

    public NewTaskCreation selectProjectForNewTask(String Project) {
        click(HelloTabInputProjectList);
        selectFromCombobox(Project);
        return this;
    }

    public NewTaskCreation goToAttachmentsTab() {
        click(AttachmentsTab);
        return this;
    }

    public NewTaskCreation addNewAttachmentWithOutComment(String PathToTheObject) {
        click(AttachmentsTabAddNewAttachmentButton);
        writeText(AttachmentsTabAddNewAttachmentButton_SelectFile, PathToTheObject);
        click(AttachmentsTabDoneUploadFileButton);
        return this;
        }

    public NewTaskCreation goToHistoryTab() {
        click(HistoryTab);
        return this;
    }

    public NewTaskCreation uncheckAllCheckboxesIfTimeCheckboxIsChecked() {
        List<WebElement> checkboxes = driver.findElements(HistoryTabTimeAllCheckboxes);
        if (isSelected(HistoryTabTimeCheckbox)) {
            for (WebElement checkbox : checkboxes) {
                checkbox.click();
            }
        }
        return this;
    }

    public FindTask clickConfirmCreationOrModificationButton() {
        click(ConfirmCreationOrModificationButton);
        waitInvisibilityOfTheElementLocated(CreateNewTaskForm);
        return new FindTask(driver);
    }

    public FindTask createTaskWithNextAttributes (String TaskName, String Decription, Integer Priority, String Project) {
        inputNewTaskName(TaskName);
        inputDescriptionTabTextField(Decription);
        goToHelloTab();
        selectPriorityForNewTask(Priority);
        selectProjectForNewTask(Project);
        clickConfirmCreationOrModificationButton();
        return new FindTask(driver);
    }

}


