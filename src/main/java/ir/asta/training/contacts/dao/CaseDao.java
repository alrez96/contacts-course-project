package ir.asta.training.contacts.dao;

import ir.asta.training.contacts.entities.CaseEntity;

import javax.inject.Named;
import javax.persistence.*;

@Named("caseDao")
public class CaseDao {

    @PersistenceContext
    private EntityManager entityManager;


    public CaseEntity save(CaseEntity entity) {
        return entityManager.merge(entity);
    }

    public CaseEntity load(String title) {
        try {
            CaseEntity c = (CaseEntity) entityManager.
                    createNamedQuery("findCaseById").
                    setParameter("title",title).getSingleResult();
            return c;
        }catch (Exception e){
            return null;
        }
    }
}