package model.dao;

import model.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.persistence.PersistenceManager;
import model.persistence.dto.PessoaNomeEmailDTO;
import org.hibernate.HibernateException;

/**
 *
 * @author valtersales
 */
public class PessoaDAO {

    private PersistenceManager manager;

    public PessoaDAO() {
        manager = PersistenceManager.getInstance();
    }

    public void insert(Pessoa pessoa) {

        // recuperar o entity manager
        EntityManager entityManager = manager.getEntityManager();

        // recuperar o objeto que vai cuidar da transação
        final EntityTransaction transaction = entityManager.getTransaction();

        // iniciar a transação
        transaction.begin();

        entityManager.persist(pessoa);

        // commit da transação
        transaction.commit();

        // fechar o entity manager
        entityManager.close();

    }

    public List<String> findAll() {

        List<String> retorno = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            // recuperar o entity manager
            entityManager = manager.getEntityManager();

            // recuperar o objeto que vai cuidar da transação
            transaction = entityManager.getTransaction();

            // iniciar a transação
            transaction.begin();

            TypedQuery<PessoaNomeEmailDTO> query = entityManager.createQuery(""
                    + "SELECT new model.persistence.dto.PessoaNomeEmailDTO(p.nome, p.email) "
                    + "from Pessoa p "
                    + "where nome_pessoa = :nomeParametro", PessoaNomeEmailDTO.class);

            query.setParameter("nomeParametro", "José Carlos");

            final List<PessoaNomeEmailDTO> resultList = query.getResultList();

            for (PessoaNomeEmailDTO dto : resultList) {
                System.out.println("DTO.nome: " + dto.getNome());
                System.out.println("DTO.email: " + dto.getEmail());
            }

            // commit da transação
            transaction.commit();

        } catch (Exception e) {
            // rollback da transação
            if (transaction != null) {
                transaction.rollback();
            }

            throw new HibernateException("Erro do executar o método findAll de PessoaDAO", e);

        } finally {
            // fechar o entity manager
            if (entityManager != null) {
                entityManager.close();
            }
        }

        return retorno;
    }

    public List<Pessoa> findByName(String nomeFiltro) {

        List<Pessoa> retorno = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            // recuperar o entity manager
            entityManager = manager.getEntityManager();

            // recuperar o objeto que vai cuidar da transação
            transaction = entityManager.getTransaction();

            // iniciar a transação
            transaction.begin();

            Query query = entityManager.createQuery("from Pessoa where nome_pessoa = :nomeParametro");
            query.setParameter("nomeParametro", nomeFiltro);
            retorno = query.getResultList();

            // commit da transação
            transaction.commit();

        } catch (Exception e) {
            // rollback da transação
            if (transaction != null) {
                transaction.rollback();
            }

            throw new HibernateException("Erro do executar o método findAll de PessoaDAO", e);

        } finally {
            // fechar o entity manager
            if (entityManager != null) {
                entityManager.close();
            }
        }

        return retorno;
    }

    public Pessoa findById(Integer id) {

        Pessoa retorno = null;

        // recuperar o entity manager
        EntityManager entityManager = manager.getEntityManager();

        // recuperar o objeto que vai cuidar da transação
        final EntityTransaction transaction = entityManager.getTransaction();

        // iniciar a transação
        transaction.begin();

        retorno = entityManager.find(Pessoa.class, id);

        // commit da transação
        transaction.commit();

        // fechar o entity manager
        entityManager.close();

        return retorno;
    }

    public Pessoa findByIdUsingReference(Integer id) {

        Pessoa retorno = null;

        // recuperar o entity manager
        EntityManager entityManager = manager.getEntityManager();

        // recuperar o objeto que vai cuidar da transação
        final EntityTransaction transaction = entityManager.getTransaction();

        // iniciar a transação
        transaction.begin();

        retorno = entityManager.getReference(Pessoa.class, id);
        System.out.println("Não executou a consulta ainda");

        retorno.getNome();

        System.out.println("Agora sim");

        transaction.commit();

        // fechar o entity manager
        entityManager.close();

        return retorno;
    }

    public void update(Pessoa pessoa) {

        // recuperar o entity manager
        EntityManager entityManager = manager.getEntityManager();

        // recuperar o objeto que vai cuidar da transação
        EntityTransaction transaction = entityManager.getTransaction();

        // iniciar a transação
        transaction.begin();

        // recupera o objeto original no BD
        Pessoa pessoaBD = entityManager.find(Pessoa.class, pessoa.getId());
        System.out.println("Valor de pessoa: " + pessoaBD);

        // atualiza o objeto
        pessoaBD.setNome(pessoa.getNome());
        System.out.println("Novo valor de pessoa: " + pessoaBD);

        // commit da transação
        transaction.commit();

        // fechar o entity manager
        entityManager.close();

        // altera valor no objeto desanexado
        pessoaBD.setEmail("bb.lins.14@gmail.com");

        entityManager = manager.getEntityManager();
        transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.merge(pessoaBD);

        transaction.commit();
        entityManager.close();
    }

    public void remove(Pessoa pessoa) {

        // recuperar o entity manager
        EntityManager entityManager = manager.getEntityManager();

        // recuperar o objeto que vai cuidar da transação
        final EntityTransaction transaction = entityManager.getTransaction();

        // iniciar a transação
        transaction.begin();

        // recupera o objeto original no BD
        Pessoa pessoaBD = entityManager.find(Pessoa.class, pessoa.getId());

        // remove uma Pessoa do BD
        entityManager.remove(pessoaBD);

        // commit da transação
        transaction.commit();

        // fechar o entity manager
        entityManager.close();
    }
}
