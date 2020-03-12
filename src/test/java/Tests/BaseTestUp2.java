package Tests;

import Up2.DatabaseTest;
import Up2.LoginPage;
import Up2.MainPage.MainPageElements;
import Up2.MainPage.Objects.Tasks.FindTask;
import Up2.MainPage.Objects.Tasks.NewTaskCreation;
import Up2.TestData;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class BaseTestUp2 {

    private static final Logger logger = LoggerFactory.getLogger(BaseTestUp2.class);

    WebDriver driver;
    Up2.LoginPage LoginPage;
    Up2.TestData TestData;
    NewTaskCreation NewTaskCreation;
    MainPageElements MainPageElements;
    FindTask FindTask;
    DatabaseTest DatabaseTest;


    @BeforeClass
    public static void setUpBeforeClass() {
            logger.info("TESTS WERE STARTED\n ");
    }
    @Before
    public  void setUp() throws Exception{
        //////// config
        System.setProperty(TestData.configDataTest().get("DriverName").toString(), TestData.configDataTest().get("DriverPath").toString());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(TestData.configDataTest().get("ImplicitlyWait").toString()), TimeUnit.SECONDS);
        driver.get(TestData.configDataTest().get("MainPageURL").toString());

        ///page instantiations
        LoginPage = new LoginPage(driver);
        TestData = new TestData(driver);
        FindTask = new FindTask(driver);
        NewTaskCreation = new NewTaskCreation(driver);
        MainPageElements = new MainPageElements(driver);
        DatabaseTest = new DatabaseTest(driver);

    }

    @After
        public void tearDown() throws Exception {
        DatabaseTest.disconnectFromDB();
        driver.quit();
    }

    @AfterClass
    public static void tearDownFBeforeClass() {
        logger.info("TESTS WERE FINISHED\n ");
    }

}
