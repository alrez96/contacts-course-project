package ir.asta.training.contacts.services.impl;


import ir.asta.training.contacts.entities.StudentEntity;
import ir.asta.training.contacts.manager.StudentManager;
import ir.asta.training.contacts.services.StudentService;
import ir.asta.wise.core.datamanagement.ActionResult;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;
import java.util.List;

@Named("studentService")
public class StudentServiceImpl implements StudentService {

    @Inject
    StudentManager manager;

    @Override
    public ActionResult<String> save(StudentEntity entity) {

        manager.save(entity);
        return new ActionResult<String>(true, "New contact saved successfully.", entity.getUsername());
    }

    @Override
    public StudentEntity load(String username) {
        StudentEntity s = manager.load(username);
        return s;
    }

    @Override
    public ActionResult<String> check(String username) {
        return manager.check(username);
    }


    @Override
    public ActionResult<String> checkPass(StudentEntity student) {
        return manager.checkPass(student);
    }

    @Override
    public List findAll() {
        return manager.findALL();
    }

}

