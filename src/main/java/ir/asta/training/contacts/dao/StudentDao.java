package ir.asta.training.contacts.dao;

import ir.asta.training.contacts.entities.StudentEntity;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Named("studentDao")
public class StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(StudentEntity entity) {

        entityManager.persist(entity);
    }

    public StudentEntity load(String username) {
        try {
            StudentEntity s = (StudentEntity) entityManager.
                    createNamedQuery("findStudentById").
                    setParameter("username",username).getSingleResult();
            return s;
        }catch (Exception e){
            return null;
        }
    }

    public boolean check(String username){
        try {
            StudentEntity s = (StudentEntity) entityManager.
                    createNamedQuery("findStudentById").
                    setParameter("username",username).getSingleResult();
            return true;

        }catch (Exception e){
            return false;
        }
    }

    public String getPass(String username){
        try {
            StudentEntity s = (StudentEntity) entityManager.
                    createNamedQuery("findStudentById").
                    setParameter("username",username).getSingleResult();
            return s.getPass();

        }catch (Exception e){
            return null;
        }
    }

    public List findALL(){
        try {
            return (List) entityManager.createNamedQuery("findAll").getResultList();
        }catch (Exception e){
            return null;
        }
    }

    public StudentEntity mergethis(StudentEntity studentEntity){
        return entityManager.merge(studentEntity);
    }

}