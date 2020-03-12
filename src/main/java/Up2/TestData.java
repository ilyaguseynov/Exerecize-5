package Up2;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import static Up2.DatabaseTest.*;

public class TestData extends BasePage {

    public TestData(WebDriver driver) {
        super(driver);
    }

    private static HashMap<String, String> Test1;
    private static HashMap<String, String> Test2;
    private static HashMap<String, String> Test3;
    private static HashMap<String, String> configData;
    private static HashMap<String, String> TaskStates;

    public static XSSFCell getCell (String Sheet, Integer Row, Integer Cell) throws Exception {
        File TestDataFromXlsx = new File("./TestData.xlsx");
        FileInputStream TestDataXlsx = new FileInputStream(TestDataFromXlsx);
        XSSFWorkbook Xlsx = new XSSFWorkbook(TestDataXlsx);
        XSSFSheet TestDataSheet = Xlsx.getSheet(Sheet);
        TestDataSheet.getRow(Row).getCell(Cell);
        return TestDataSheet.getRow(Row).getCell(Cell);
    }

    public static HashMap configDataTest () throws Exception {
        DataFormatter formatter = new DataFormatter();
        configData = new HashMap<String, String>();
        String login = formatter.formatCellValue(getCell("Configuration",1,0));
        configData.put("login", login);
        String password = formatter.formatCellValue(getCell("Configuration",1,1));
        configData.put("password", password);
        String DriverName = formatter.formatCellValue(getCell("Configuration",1,2));
        configData.put("DriverName", DriverName);
        String DriverPath = formatter.formatCellValue(getCell("Configuration",1,3));
        configData.put("DriverPath", DriverPath);
        String ImplicitlyWait = formatter.formatCellValue(getCell("Configuration",1,4));
        configData.put("ImplicitlyWait", ImplicitlyWait);
        String MainPageURL = formatter.formatCellValue(getCell("Configuration",1,5));
        configData.put("MainPageURL", MainPageURL);

        return configData;
    }

    public static HashMap testDataForTheFirstTest() throws Exception {
        if (connection == null) {
            connectToDBtest1();
        }
        String SQLQuery = "SELECT * FROM TestDataDB WHERE taskproject = '[Т] Общие затраты'";
        Test1 = new HashMap<String, String>();
        Test1.put("NewTaskName", getDataFromDBwoID (SQLQuery, "newtaskname"));
        Test1.put("NewTaskDescription", getDataFromDBwoID (SQLQuery, "newtaskdescription"));
        Test1.put("NewTaskDateOff", getDataFromDBwoID (SQLQuery, "newtaskdateoff"));
        Test1.put("NewTaskPriority", getDataFromDBwoID (SQLQuery, "taskpriority"));
        Test1.put("NewTaskProject", getDataFromDBwoID (SQLQuery, "taskproject"));
        Test1.put("NewTaskFile", getDataFromDBwoID (SQLQuery, "taskfile"));

        return Test1;
    }

    public static HashMap testDataForTheSecondTest() throws Exception {
        if (connection == null) {
            connectToDBtest1();
        }
        String SQLQuery = "SELECT * FROM TestDataDB WHERE taskproject = '[Т] Больничный' and newtaskname = 'Test_Groot6'";
        Test2 = new HashMap<String, String>();
        Test2.put("NewTaskName", getDataFromDBwoID (SQLQuery, "newtaskname"));
        Test2.put("NewTaskDescription", getDataFromDBwoID (SQLQuery, "newtaskdescription"));
        Test2.put("NewTaskDateOff", getDataFromDBwoID (SQLQuery, "newtaskdateoff"));
        Test2.put("NewTaskPriority", getDataFromDBwoID (SQLQuery, "taskpriority"));
        Test2.put("NewTaskProject", getDataFromDBwoID (SQLQuery, "taskproject"));
        Test2.put("NewTaskFile", getDataFromDBwoID (SQLQuery, "taskfile"));
        return Test2;
    }

    public static HashMap testDataForTheThirdTest() throws Exception {
        if (connection == null) {
            connectToDBtest1();
        }
        String SQLQuery = "SELECT * FROM TestDataDB WHERE taskproject = '[Т] Больничный' and newtaskname = 'Test_Groot5'";
        Test3 = new HashMap<String, String>();
        Test3.put("NewTaskName", getDataFromDBwoID (SQLQuery, "newtaskname"));
        Test3.put("NewTaskDescription", getDataFromDBwoID (SQLQuery, "newtaskdescription"));
        Test3.put("NewTaskDateOff", getDataFromDBwoID (SQLQuery, "newtaskdateoff"));
        Test3.put("NewTaskPriority", getDataFromDBwoID (SQLQuery, "taskpriority"));
        Test3.put("NewTaskProject", getDataFromDBwoID (SQLQuery, "taskproject"));
        Test3.put("NewTaskFile", getDataFromDBwoID (SQLQuery, "taskfile"));
        return Test3;
    }

    public static HashMap taskStates() throws Exception {
        if (connection == null) {
            connectToDBtest1();
        }
        TaskStates = new HashMap<String, String>();

        String SQLQuery = "SELECT * FROM taskstate where states = 'Новый'";
        TaskStates.put("New", getDataFromDBwoID (SQLQuery, "states"));
        String SQLQuery2 = "SELECT * FROM taskstate where states = 'В работе'";
        TaskStates.put("InWork", getDataFromDBwoID (SQLQuery2, "states"));
        String SQLQuery3 = "SELECT * FROM taskstate where states = 'Исполнен'";
        TaskStates.put("Executed", getDataFromDBwoID (SQLQuery3, "states"));
        String SQLQuery4 = "SELECT * FROM taskstate where states = 'Завершен'";
        TaskStates.put("Сompleted", getDataFromDBwoID (SQLQuery4, "states"));

        return TaskStates;
    }

}
