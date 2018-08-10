package model.hibernate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.dao.ConnectionFactory;

public class JDBCTest {

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement st = null;

        try {
            con = new ConnectionFactory().getConnection();
            System.out.println("Conectado!");

            // insert into pessoa (nome) values ('Valter Sales')
            String sql = "insert into pessoa (nome) values (?)";

            st = con.prepareStatement(sql);

            st.setString(1, "Bianca Lins");

            st.execute();

            System.out.println("Salvo com sucesso na tabela!");

        } catch (SQLException e) {
            System.out.println("Deu erro!" + e.getMessage());
        } finally {
            try {
                st.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("Não foi possível fechar a conexão" + e.getMessage());
            }
        }
    }

}
