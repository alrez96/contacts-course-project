package ir.asta.training.contacts.manager;

import ir.asta.training.contacts.dao.CaseDao;
import ir.asta.training.contacts.entities.ActorEntity;
import ir.asta.training.contacts.entities.CaseEntity;
import ir.asta.training.contacts.entities.StudentEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Named("caseManager")
public class CaseManager {

    @Inject
    CaseDao dao;
    @Inject
    StudentManager stmanager;
    @Inject
    ActorManager actmanager;

    @Transactional
    public CaseEntity save(CaseEntity entity) {
        //adding date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String time = dtf.format(now).substring(0,10);
        entity.setDate(time);
        //adding student
        StudentEntity studentEntity = stmanager.load(entity.getStudent().getUsername());
        entity.setStudent(studentEntity);
        //adding actor
        ActorEntity actorEntity = actmanager.load(entity.getActor().getUsername());
        entity.setActor(actorEntity);
        return dao.save(entity);
    }

    public CaseEntity load(String title) {
        CaseEntity entity = dao.load(title);
        return entity;
    }

}