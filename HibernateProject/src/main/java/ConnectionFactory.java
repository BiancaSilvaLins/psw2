
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() throws SQLException {

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mavendb?zeroDateTimeBehavior=convertToNull",
                "root",
                "uniceub");

        System.out.print("Conectado!");

        return con;
    }

}
