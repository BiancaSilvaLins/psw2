package model.hibernate;


import model.persistence.PersistenceManager;

public class HibernateJPATest {

    public static void main(String[] args) {
        try{
            PersistenceManager.getInstance().initializeContext();
            
        }catch(Exception e){
           throw e;

        } finally {
            PersistenceManager.getInstance().destroyContext();
        }

    }
}
