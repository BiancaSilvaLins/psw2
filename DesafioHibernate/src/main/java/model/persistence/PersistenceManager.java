package model.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

    private static PersistenceManager instance = null;
    private EntityManagerFactory emf = null;

    public static PersistenceManager getInstance() {
        if (instance == null) {
            instance = new PersistenceManager();
        }

        return instance;
    }

    public void initializeContext() {
        getEntityManagerFactory();
    }

    public void destroyContext() {
        closeEntityManagerFactory();
    }

    private void closeEntityManagerFactory() {
        if (emf != null) {
            emf.close();
            emf = null;
        }
    }

    private EntityManagerFactory getEntityManagerFactory() {

        if (emf == null) {
            synchronized (PersistenceManager.class) {
                try {
                    emf = Persistence.createEntityManagerFactory(
                            "desafio-hibernate");
                } catch (Exception e) {
                    throw new RuntimeException("Não foi possível "
                            + "carregar o unidade de persistência");
                }
            }
        }

        return emf;
    }

    public EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    public static class getInstance {

        public getInstance() {
        }
    }
}
