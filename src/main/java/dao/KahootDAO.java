package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import models.Kahoot;
import models.User;

public class KahootDAO {

    private EntityManager entityManager;

    public KahootDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void createKahoot(Kahoot kahoot){
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.persist(kahoot);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            System.err.println("Error Add kahoot");
        }
    }

    public Kahoot findKahootById(long id){
        return entityManager.find(Kahoot.class, id);
    }

    public boolean addPlayer(long id, User user){
        return entityManager.find(Kahoot.class, id).getPlayers().add(user);
    }

    public boolean removePlayer(long id, User user){
        return entityManager.find(Kahoot.class, id).getPlayers().remove(user);
    }


}
