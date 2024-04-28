package ir.asta.training.contacts.services.impl;


import ir.asta.training.contacts.entities.CaseEntity;
import ir.asta.training.contacts.entities.StudentEntity;
import ir.asta.training.contacts.manager.CaseManager;
import ir.asta.training.contacts.services.CaseService;
import ir.asta.wise.core.datamanagement.ActionResult;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;

@Named("caseService")
public class CaseServiceImpl implements CaseService {

    @Inject
    CaseManager manager;

    @Override
    public ActionResult<String> save(CaseEntity entity) {

        entity = manager.save(entity);
        return new ActionResult<String>(true, "New contact saved successfully.", entity.getTitle());
    }

    @Override
    public CaseEntity load(String title) {
        return manager.load(title);
    }

}