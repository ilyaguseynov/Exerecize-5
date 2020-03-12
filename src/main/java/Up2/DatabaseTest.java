package Up2;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.WebDriver;

import java.sql.*;

public class DatabaseTest extends BasePage {

    private static String Data;
    public static Connection connection;

    public DatabaseTest(WebDriver driver) {
        super(driver);
    }

    public static void connectToDBtest1 () throws Exception {
        DataFormatter formatter = new DataFormatter();
        String userDB = formatter.formatCellValue(TestData.getCell("Configuration",1,7));
        String passwordDB = formatter.formatCellValue(TestData.getCell("Configuration",1,8));
        String urlDB = formatter.formatCellValue(TestData.getCell("Configuration",1,6));
        connection = DriverManager.getConnection(urlDB, userDB, passwordDB);
}

    public void disconnectFromDB () throws Exception {
        connection.close();
    }


    public static String getDataFromDBwoID (String SQLQuery, String ColumnName){

        try {
            try (PreparedStatement statement = connection.prepareStatement(SQLQuery)) {
                ResultSet resultSet = statement.executeQuery();

                while  (resultSet.next()) {
                    Data = resultSet.getString(ColumnName);
                }
                resultSet.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Data;
    }


}
