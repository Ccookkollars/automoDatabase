package DBConnector;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;

public class Test {

    public static void main(String[] args) {

        DBConnector DB = new DBConnector();
        DB.testConnection();
        JFrame testFrame = new TestFrame();

        testFrame.setVisible(true);

        try {
            Statement stmt = DB.getConnection().createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM car");
            while (rs.next()) {
                String lastName = rs.getString("make");
                System.out.println(lastName);
            }
        } catch (Throwable e) {
            System.out.println(e);
        }

        DB.closeConnection();

    }

}
