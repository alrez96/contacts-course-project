package ir.asta.training.contacts.services;


import ir.asta.training.contacts.entities.Human;
import ir.asta.training.contacts.entities.StudentEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("checkwho")
public interface CheckWhoService {
    @GET
    @Produces("text/plain")
    @Path("/check/{username}")
    public String check(@PathParam("username") String username);

    @POST
    @Path("/merge")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Human mergethis(Human human);
}
