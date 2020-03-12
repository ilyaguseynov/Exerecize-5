package Tests;

import Up2.TestData;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;

import static Up2.TestData.*;

@RunWith(Parameterized.class)
public class TestUp2 extends BaseTestUp2{

    private static final Logger logger = LoggerFactory.getLogger(Up2.TestData.class);

    private String TestNumber;
    private String Login;
    private String Password;
    private String NewTaskName;
    private String NewTaskDescription;
    private int NewTaskPriority;
    private String NewTaskProject;
    private String TaskStateInWork;
    private String TaskStateExecuted;
    private String TaskStateCompleted;
    private String EXPECTEDTaskStateNew;
    private String EXPECTEDTaskStateInWork;
    private String EXPECTEDTaskStateExecuted;
    private String EXPECTEDTaskStateCompleted;

    public TestUp2 (String TestNumber, String Login, String Password, String NewTaskName, String NewTaskDescription,
                    int NewTaskPriority, String NewTaskProject, String TaskStateInWork, String TaskStateExecuted, String TaskStateCompleted,
                    String EXPECTEDTaskStateNew, String EXPECTEDTaskStateInWork, String EXPECTEDTaskStateExecuted, String EXPECTEDTaskStateCompleted) {
        this.TestNumber = TestNumber;
        this.Login = Login;
        this.Password = Password;
        this.NewTaskName = NewTaskName;
        this.NewTaskDescription = NewTaskDescription;
        this.NewTaskPriority = NewTaskPriority;
        this.NewTaskProject = NewTaskProject;
        this.TaskStateInWork = TaskStateInWork;
        this.TaskStateExecuted = TaskStateExecuted;
        this.TaskStateCompleted = TaskStateCompleted;
        this.EXPECTEDTaskStateNew = EXPECTEDTaskStateNew;
        this.EXPECTEDTaskStateInWork = EXPECTEDTaskStateInWork;
        this.EXPECTEDTaskStateExecuted = EXPECTEDTaskStateExecuted;
        this.EXPECTEDTaskStateCompleted = EXPECTEDTaskStateCompleted;
    }

    @Parameterized.Parameters (name = "{index}: testStateEquality")
    public static Collection<Object[]> data() throws Exception {
        return Arrays.asList(new Object[][] {
                {
                        "ТЕСТ: №1",
                        configDataTest().get("login").toString(),
                        configDataTest().get("password").toString(),
                        testDataForTheFirstTest().get("NewTaskName").toString(),
                        testDataForTheFirstTest().get("NewTaskDescription").toString(),
                        Integer.parseInt(testDataForTheFirstTest().get("NewTaskPriority").toString()),
                        testDataForTheFirstTest().get("NewTaskProject").toString(),
                        taskStates().get("InWork").toString(),
                        taskStates().get("Executed").toString(),
                        taskStates().get("Сompleted").toString(),
                        "Новый",
                        "В работе",
                        "Исполненd",
                        "Завершен",

                },
                {
                        "ТЕСТ: №2",
                        configDataTest().get("login").toString(),
                        configDataTest().get("password").toString(),
                        testDataForTheSecondTest().get("NewTaskName").toString(),
                        testDataForTheSecondTest().get("NewTaskDescription").toString(),
                        Integer.parseInt(testDataForTheSecondTest().get("NewTaskPriority").toString()),
                        testDataForTheSecondTest().get("NewTaskProject").toString(),
                        taskStates().get("InWork").toString(),
                        taskStates().get("Executed").toString(),
                        taskStates().get("Сompleted").toString(),
                        "Новый",
                        "В работе",
                        "Исполнен",
                        "Завершен",
                },
                {
                        "ТЕСТ: №3",
                        configDataTest().get("login").toString(),
                        configDataTest().get("password").toString(),
                        testDataForTheThirdTest().get("NewTaskName").toString(),
                        testDataForTheThirdTest().get("NewTaskDescription").toString(),
                        Integer.parseInt(testDataForTheThirdTest().get("NewTaskPriority").toString()),
                        testDataForTheThirdTest().get("NewTaskProject").toString(),
                        taskStates().get("InWork").toString(),
                        taskStates().get("Executed").toString(),
                        taskStates().get("Сompleted").toString(),
                        "Новый",
                        "В работе",
                        "Исполнен",
                        "Завершен",
                },
        });
    }

    @Test
    public void Test_project() {
        try {
            logger.info("{} started", TestNumber);
            LoginPage.signIn(Login, Password);
            MainPageElements.clickObjectButton();
            FindTask.clickCreateNewTaskButton();
            NewTaskCreation.createTaskWithNextAttributes(NewTaskName, NewTaskDescription, NewTaskPriority, NewTaskProject);
            /////////
            /////////check state = new
            FindTask.findAndOpenTaskByName(NewTaskName);
//            Boolean equalsTaskStatesNEW = EXPECTEDTaskStateNew.equals(NewTaskCreation.getSelectedTaskStateText());
//            if (equalsTaskStatesNEW) {
//                logger.info("Cheking the 'New' state - Passed");
//            } else {
//                logger.warn("Cheking the 'New' state - Failed; actual: {}, expected: {}", EXPECTEDTaskStateNew, NewTaskCreation.getSelectedTaskStateText());
//                logger.warn("{} failed", TestNumber);
//            }
//            Assert.assertEquals(EXPECTEDTaskStateNew, NewTaskCreation.getSelectedTaskStateText());
            logger.info(EXPECTEDTaskStateNew.equals(NewTaskCreation.getSelectedTaskStateText()) ? "Cheking the 'New' state - Passed" :
                            "Cheking the 'New' state - Failed; actual: {}, expected: {}\n                                         {} failed\n ",
                    EXPECTEDTaskStateNew, NewTaskCreation.getSelectedTaskStateText(), TestNumber);
            Assert.assertTrue(EXPECTEDTaskStateNew.equals(NewTaskCreation.getSelectedTaskStateText()));

            ////////
            ////////check state = InWork
            NewTaskCreation.selectStateForTask(TaskStateInWork);
            NewTaskCreation.clickConfirmCreationOrModificationButton();
            FindTask.openFirstTaskFromTheGrid();
//            Boolean equalsTaskStatesInWork = EXPECTEDTaskStateInWork.equals(NewTaskCreation.getSelectedTaskStateText());
//            if (equalsTaskStatesInWork) {
//                logger.info("Cheking the 'InWork' state - Passed");
//            } else {
//                logger.warn("Cheking the 'InWork' state - Failed; actual: {}, expected: {}", EXPECTEDTaskStateInWork, NewTaskCreation.getSelectedTaskStateText());
//                logger.warn("{} failed", TestNumber);
//            }
//            Assert.assertEquals(EXPECTEDTaskStateInWork, NewTaskCreation.getSelectedTaskStateText());
            logger.info(EXPECTEDTaskStateInWork.equals(NewTaskCreation.getSelectedTaskStateText()) ? "Cheking the 'InWork' state - Passed" :
                            "Cheking the 'InWork' state - Failed; actual: {}, expected: {}\n                                         {} failed\n ",
                    EXPECTEDTaskStateInWork, NewTaskCreation.getSelectedTaskStateText(), TestNumber);
            Assert.assertTrue(EXPECTEDTaskStateInWork.equals(NewTaskCreation.getSelectedTaskStateText()));

            ////////
            ////////check state = Executed
            NewTaskCreation.selectStateForTask(TaskStateExecuted);
            NewTaskCreation.clickConfirmCreationOrModificationButton();
            FindTask.openFirstTaskFromTheGrid();
//            Boolean equalsTaskStatesExecuted = EXPECTEDTaskStateExecuted.equals(NewTaskCreation.getSelectedTaskStateText());
//            if (equalsTaskStatesExecuted) {
//                logger.info("Cheking the 'Executed' state - Passed");
//            } else {
//                logger.warn("Cheking the 'Executed' state - Failed; actual: {}, expected: {}", EXPECTEDTaskStateExecuted, NewTaskCreation.getSelectedTaskStateText());
//                logger.warn("{} failed", TestNumber);
//            }
//            Assert.assertEquals(EXPECTEDTaskStateExecuted, NewTaskCreation.getSelectedTaskStateText());

            logger.info(EXPECTEDTaskStateExecuted.equals(NewTaskCreation.getSelectedTaskStateText()) ? "Cheking the 'Executed' state - Passed" :
                            "Cheking the 'Executed' state - Failed; actual: {}, expected: {}\n                                         {} failed\n ",
                    EXPECTEDTaskStateExecuted, NewTaskCreation.getSelectedTaskStateText(), TestNumber);
            Assert.assertTrue(EXPECTEDTaskStateExecuted.equals(NewTaskCreation.getSelectedTaskStateText()));

            ////////
            ////////check state = Completed
            NewTaskCreation.selectStateForTask(TaskStateCompleted);
            NewTaskCreation.clickConfirmCreationOrModificationButton();
            FindTask.openFirstTaskFromTheGrid();
//            Boolean equalsTaskStatesCompleted = EXPECTEDTaskStateCompleted.equals(NewTaskCreation.getSelectedTaskStateText());
//            if (equalsTaskStatesCompleted) {
//                logger.info("Cheking the 'Completed' state - Passed");
//            } else {
//                logger.warn("Cheking the 'Completed' state - Failed; actual: {}, expected: {}", EXPECTEDTaskStateCompleted, NewTaskCreation.getSelectedTaskStateText());
//                logger.warn("{} failed", TestNumber);
//            }
//            Assert.assertEquals(EXPECTEDTaskStateCompleted, NewTaskCreation.getSelectedTaskStateText());

            logger.info(EXPECTEDTaskStateCompleted.equals(NewTaskCreation.getSelectedTaskStateText()) ? "Cheking the 'Completed' state - Passed" :
                    "Cheking the 'Completed' state - Failed; actual: {}, expected: {}\n                                         {} failed\n ",
                    EXPECTEDTaskStateCompleted, NewTaskCreation.getSelectedTaskStateText(), TestNumber);
            Assert.assertTrue(EXPECTEDTaskStateCompleted.equals(NewTaskCreation.getSelectedTaskStateText()));

            NewTaskCreation.clickConfirmCreationOrModificationButton();
            MainPageElements.logOut();
            logger.info("{} passed\n ", TestNumber);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("TEST WAS FAILED bcs {}", e);
            Assert.fail();
        }
    }
}
