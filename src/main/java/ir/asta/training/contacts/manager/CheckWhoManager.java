package ir.asta.training.contacts.manager;

import ir.asta.training.contacts.dao.ActorDao;
import ir.asta.training.contacts.dao.StudentDao;
import ir.asta.training.contacts.entities.ActorEntity;
import ir.asta.training.contacts.entities.Human;
import ir.asta.training.contacts.entities.StudentEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

@Named("checkwhoManager")
public class CheckWhoManager {

    @Inject
    StudentDao studentDao;
    @Inject
    ActorDao actorDao;

    public String check(String username){
        if(actorDao.check(username)){
            return "actor";
        }else if(studentDao.check(username)){
            return "student";
        }else
            return "none";
    }

    @Transactional
    public Human mergethis(Human human){
        Human h;
        if( check(human.getUsername()) == "actor")
            h = actorDao.load(human.getUsername());
        else
            h = studentDao.load(human.getUsername());
        if(human.getPass()!=null)
            h.setPass(human.getPass());
        if(human.getEmailAddress()!=null)
            h.setEmailAddress(human.getEmailAddress());
        if(human.getName()!=null)
            h.setName(human.getName());
        if( check(human.getUsername()) == "actor")
            return actorDao.mergethis((ActorEntity) h);
        else
            return studentDao.mergethis((StudentEntity) h);
    }
}
