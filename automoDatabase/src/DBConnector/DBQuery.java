package DBConnector;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBQuery {

    private DBConnector connection;

    public DBQuery() {
        connection = new DBConnector();
    }

    public String[] makeModelYear() {

        ArrayList<String> resultsList = new ArrayList<String>();
        try {

            Statement stmt = connection.getConnection().createStatement();

            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM car");

            while (rs.next()) {
                resultsList.add(rs.getString("make"));
                resultsList.add(rs.getString("model"));
            }

        } catch (Throwable e) {
            System.out.println(e);
        }

        String[] list = new String[resultsList.size()];
        list = resultsList.toArray(list);

        return list;
    }

}
