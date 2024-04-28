package ir.asta.training.contacts.services;

import ir.asta.training.contacts.entities.StudentEntity;
import ir.asta.wise.core.datamanagement.ActionResult;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/student")
public interface StudentService {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/load/{pk}")
    public StudentEntity load(@PathParam("pk") String username);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/check/{username}")
    public ActionResult<String> check(@PathParam("username") String username);

    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ActionResult<String> save(StudentEntity entity);

    @POST
    @Path("/checkpass")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ActionResult<String> checkPass(StudentEntity entity);

    @GET
    @Path("/findAllStudents")
    @Produces(MediaType.APPLICATION_JSON)
    public List findAll();

}
