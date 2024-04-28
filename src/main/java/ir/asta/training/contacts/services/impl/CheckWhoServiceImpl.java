package ir.asta.training.contacts.services.impl;

import ir.asta.training.contacts.entities.Human;
import ir.asta.training.contacts.entities.StudentEntity;
import ir.asta.training.contacts.manager.CheckWhoManager;
import ir.asta.training.contacts.services.CheckWhoService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;


@Named("checkwhoService")
public class CheckWhoServiceImpl implements CheckWhoService {

    @Inject
    CheckWhoManager manager;

    @Override
    public String check(String username) {
        return manager.check(username);
    }

    @Override
    public Human mergethis(Human human){
        return manager.mergethis(human);
    }
}
