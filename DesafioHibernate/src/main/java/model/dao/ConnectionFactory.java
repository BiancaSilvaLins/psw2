package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {

        Connection con = null;

        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/desafiohibernatebd?useTimezone=true&amp;serverTimezone=UTC",
                    "root",
                    "root");
        } catch (SQLException e) {
            System.out.println("Não foi possível obter uma conexão com o BD" + e.getMessage());
        }

        return con;

    }

}
