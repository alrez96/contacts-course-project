package ir.asta.training.contacts.manager;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ir.asta.training.contacts.dao.StudentDao;
import ir.asta.training.contacts.entities.CaseEntity;
import ir.asta.training.contacts.entities.StudentEntity;
import ir.asta.wise.core.datamanagement.ActionResult;
import org.springframework.transaction.annotation.Transactional;


@Named("studentManager")
public class StudentManager {

    @Inject
    StudentDao dao;

    @Transactional
    public void save(StudentEntity entity) {
        dao.save(entity);
    }

    public StudentEntity load(String username) {
        StudentEntity entity = dao.load(username);
        return entity;
    }

    public ActionResult<String>  check(String username){
        if(dao.check(username))
            return new ActionResult<>(false,"username exists!",username);
        else
            return new ActionResult<>(true,"username doesn't exist",username);
    }

    public ActionResult<String> checkPass(StudentEntity s){
        String pass = dao.getPass(s.getUsername());
        if(pass.equals(s.getPass()))
            return new ActionResult<>(true,"passwords match!",s.getUsername());
        else
            return new ActionResult<>(false,"passwords don't match!",s.getUsername());
    }

    public List findALL(){
        return dao.findALL();
    }



}
