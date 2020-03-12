package Up2.MainPage.Objects.Tasks;

import Up2.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FindTask extends BasePage {

    public FindTask(WebDriver driver) {
        super(driver);
    }


    /////////////////////////////////////////////////
    //////////// Objects ////////////////////////////

    private By searchField = By.xpath("//input[@placeholder='Поиск']");
    private By searchAscending = By.xpath("//div [@aria-label = 'Номер' and @aria-sort = 'ascending']");
    private By searchDescending = By.xpath("//div [@aria-label = 'Номер' and @aria-sort = 'descending']");
    private By SortButton = By.xpath("//div[@class='ReactVirtualized__Table__headerColumn sorting ReactVirtualized__Table__sortableHeaderColumn']//div[@class='sortable']");
    private By FirstTaskFromTheGridName = By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/div[1]/div[2]//a");
    private By FirstTaskFromTheGridNumber = By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/div[1]/div[1]//a");
    private By CreateEditTaskForm = By.xpath("//div [@class = 'up2-dialogs']//div [contains(@class, 'draggable')]");
    private By CreateNewTaskButton = By.xpath("//div [@class = 'list-type__toolbar']//button [@title = 'Создать новую запись']");

    ///////////////////////////////////////////////////
    ////////////// Actions ////////////////////////////

    public NewTaskCreation clickCreateNewTaskButton() {
        click(CreateNewTaskButton);
        return new NewTaskCreation(driver);
    }

    public String getNumberOfTheFirstTaskFromTheGrid () {
      return getText(FirstTaskFromTheGridNumber);
    }


    public void findTaskByName (String TaskName){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        writeText(searchField, TaskName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickEnter(searchField);
    }

    public void sortTasksByDescendingNumber () {
        if (!((sizeOfElements(CreateEditTaskForm)) > 0)) {
            if (sizeOfElements(searchAscending) > 0) {
                click(SortButton);
            } }
    }

    public NewTaskCreation openFirstTaskFromTheGrid () {
        click(FirstTaskFromTheGridName);
        return new NewTaskCreation(driver);
    }

    public void waitTaskWithName (String TaskName) {
        waitVisibilityText(FirstTaskFromTheGridName, TaskName);
    }

    public FindTask findAndOpenTaskByName(String TaskName){
        waitTaskWithName(TaskName);
        String number = getNumberOfTheFirstTaskFromTheGrid();
        findTaskByName(TaskName);
        sortTasksByDescendingNumber();
        waitVisibilityText(FirstTaskFromTheGridNumber, number);
        openFirstTaskFromTheGrid();
        return this;
    }

}
