package ir.asta.training.contacts.services;
import ir.asta.training.contacts.entities.ActorEntity;
import ir.asta.wise.core.datamanagement.ActionResult;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/actor")
public interface ActorService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/load/{pk}")
    public ActorEntity load(@PathParam("pk") String username);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/check/{username}")
    public ActionResult<String> check(@PathParam("username") String username);

    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ActionResult<String> save(ActorEntity entity);

    @POST
    @Path("/checkpass")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ActionResult<String> checkPass(ActorEntity entity);
}
