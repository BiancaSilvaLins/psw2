import java.sql.Connection;
import java.sql.SQLException;



/**
 *
 * @author bianca.lins
 */
public class JDBCTestConnection {
    
    public static void main(String[] args) throws SQLException{
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Ricardo");
        pessoa.setIdade(39);
        
        PessoaDAO dao = new PessoaDAO();
        dao.insert(pessoa);
    }
}
