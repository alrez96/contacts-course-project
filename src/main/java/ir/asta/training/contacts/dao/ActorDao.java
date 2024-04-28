package ir.asta.training.contacts.dao;

import ir.asta.training.contacts.entities.ActorEntity;
import ir.asta.training.contacts.entities.StudentEntity;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named("actorDao")
public class ActorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(ActorEntity entity) {
        entityManager.persist(entity);
    }

    public ActorEntity load(String username) {
        try {
            ActorEntity s = (ActorEntity) entityManager.
                    createNamedQuery("findActorById").
                    setParameter("username",username).getSingleResult();
            return s;
        }catch (Exception e){
            return null;
        }
    }

    public boolean check(String username){
        try {
            ActorEntity s = (ActorEntity) entityManager.
                    createNamedQuery("findActorById").
                    setParameter("username",username).getSingleResult();
            return true;

        }catch (Exception e){
            return false;
        }
    }

    public String getPass(String username){
        try {
            ActorEntity s = (ActorEntity) entityManager.
                    createNamedQuery("findActorById").
                    setParameter("username",username).getSingleResult();
            return s.getPass();

        }catch (Exception e){
            return null;
        }
    }

    public ActorEntity mergethis(ActorEntity actorEntity){
        return entityManager.merge(actorEntity);
    }

/*    public void update(ActorEntity actorEntity){
        entityManager.merge(actorEntity);
    }*/

}