
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    private Connection con = null;

    public PessoaDAO() throws SQLException {
        this.con = new ConnectionFactory().getConnection();
    }

    public void insert(Pessoa pessoa) {

        PreparedStatement st = null;

        try {
            String sql = "insert into pessoa(nome, idade) values (? , ?)";

            st = con.prepareStatement(sql);

            st.setString(1, pessoa.getNome());
            st.setInt(2, pessoa.getIdade());

            st.execute();

        } catch (Exception e) {
            System.out.println("Deu erro!!!" + e.getMessage());
        } finally {

        }
    }
    
    
    
    public List<Pessoa> findAll(){
       List<Pessoa> retorno = new ArrayList<Pessoa>();
       PreparedStatement st = null;
       
       try {
            String sql = "insert into pessoa(nome, idade) values (? , ?)";
            st = con.prepareStatement(sql);
            ResultSet resultado = st.executeQuery();
            
            while(resultado.next()){
                Pessoa pessoa = new Pessoa();
                
                pessoa.setId(resultado.getInt("id"));
                pessoa.setNome(resultado.getString("nome"));
                pessoa.setIdade(resultado.getInt("idade"));
                
                retorno.add(pessoa);
            }       
        } catch (Exception e) {
            System.out.println("Deu erro!!!" + e.getMessage());
            e.printStackTrace();
        } finally {
           try{
               if(st != null)
                   st.close();
           }catch(Exception e){
               
           }
       }
       return retorno;
    }

}
