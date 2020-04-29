package DBConnector;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBQuery {

    private static final Logger LOG = Logger.getLogger("DBQuery");
    private DBConnector connection;

    public DBQuery() {
        connection = new DBConnector();
    }

    public String[] makeModelYearVin() {

        List<String> resultsList = new ArrayList<>();
        try {

            Statement stmt = connection.getConnection().createStatement();

            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM car");

            while (rs.next()) {
                resultsList.add(rs.getString("make"));
                resultsList.add(rs.getString("model"));
                resultsList.add(rs.getString("vin"));
            }

        } catch (Exception e) {
            LOG.log(Level.SEVERE, e, () -> "WHYYYY");
            System.out.println(e);
        }

        String[] list = new String[resultsList.size()];
        list = resultsList.toArray(list);

        return list;
    }

    public Vehicle getVehicleByVin(String vin) {
        
        List<String> resultsList = new ArrayList<>();
        try {

            Statement stmt = connection.getConnection().createStatement();

            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM car WHERE vin = '" + vin + "'");

            if (rs.next()) {
                Vehicle vehicle = new Vehicle(rs.getString("vin"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getString("plate"),
                        rs.getString("color"));
               return vehicle; 
            }

        } catch (Exception e) {
            LOG.log(Level.SEVERE, e, () -> "WHYYYY");
            System.out.println(e);
        }
        return null;
    }

}
