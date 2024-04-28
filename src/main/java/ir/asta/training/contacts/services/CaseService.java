package ir.asta.training.contacts.services;


import ir.asta.training.contacts.entities.CaseEntity;
import ir.asta.wise.core.datamanagement.ActionResult;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;



@Path("/case")
public interface CaseService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/load/{pk}")
    public CaseEntity load(@PathParam("pk") String title);

    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ActionResult<String> save(CaseEntity entity);


}
