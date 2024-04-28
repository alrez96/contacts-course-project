package ir.asta.training.contacts.services.impl;
import ir.asta.training.contacts.entities.ActorEntity;
import ir.asta.training.contacts.manager.ActorManager;
import ir.asta.training.contacts.services.ActorService;
import ir.asta.wise.core.datamanagement.ActionResult;

import javax.inject.Inject;
import javax.inject.Named;

@Named("actorService")
public class ActorServiceImpl implements ActorService {


    @Inject
    ActorManager manager;

    @Override
    public ActionResult<String> save(ActorEntity entity) {
        manager.save(entity);
        return new ActionResult<String>(true, "New contact saved successfully.", entity.getUsername());
    }

    @Override
    public ActorEntity load(String username) {
        ActorEntity s = manager.load(username);
        return s;
    }

    @Override
    public ActionResult<String> check(String username) {
        return manager.check(username);
    }


    @Override
    public ActionResult<String> checkPass(ActorEntity entity) {
        return manager.checkPass(entity);
    }
}