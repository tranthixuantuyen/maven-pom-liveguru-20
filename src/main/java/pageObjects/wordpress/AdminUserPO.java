package pageObjects.wordpress;

import commons.BasePage;
import jdbcTest.MySQLTestConnection;
import org.openqa.selenium.WebDriver;
import pageUIs.wordpress.AdminDashboardPageUI;
import pageUIs.wordpress.AdminUserPageUI;
import utilities.MySQLConnUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminUserPO extends BasePage {
    WebDriver driver;
    public AdminUserPO(WebDriver driver) {
        this.driver = driver;
    }

    public int getUserNumberAtUI(){
        waitForElementVisible(driver, AdminUserPageUI.TOTAL_NUMBER_TEXT);
        String totalNumber =  getElementText(driver, AdminUserPageUI.TOTAL_NUMBER_TEXT);
        return Integer.parseInt(totalNumber.split(" ")[0]);
    }

    public int getUserNumberAtDB() {
        Connection conn = MySQLConnUtils.getMySQLConnections();
        Statement statement;
        List<Integer> totalUsers = new ArrayList<Integer>();
        try {
            statement = conn.createStatement();
            String sql = "SELECT * FROM wp_users;";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
               totalUsers.add(rs.getInt(1));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return totalUsers.size();
    }
}
