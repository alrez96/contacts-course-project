package ir.asta.training.contacts.manager;

import ir.asta.training.contacts.dao.ActorDao;
import ir.asta.training.contacts.entities.ActorEntity;
import ir.asta.training.contacts.entities.CaseEntity;
import ir.asta.wise.core.datamanagement.ActionResult;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

@Named("actorManager")
public class ActorManager {

    @Inject
    ActorDao dao;

    @Transactional
    public void save(ActorEntity entity) {
        dao.save(entity);
    }

    public ActorEntity load(String username) {
        ActorEntity entity = dao.load(username);
        return entity;

    }

    public ActionResult<String> check(String username){
        if(dao.check(username))
            return new ActionResult<>(false,"username exists!",username);
        else
            return new ActionResult<>(true,"username doesn't exist",username);
    }

    public ActionResult<String> checkPass(ActorEntity s){
        String pass = dao.getPass(s.getUsername());
        if(pass.equals(s.getPass()))
            return new ActionResult<>(true,"passwords match!",s.getUsername());
        else
            return new ActionResult<>(false,"passwords don't match!",s.getUsername());
    }
}