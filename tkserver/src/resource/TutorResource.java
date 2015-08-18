package resource;

import com.google.gson.Gson;
import model.persons.Tutor;
import service.TutorsService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by x on 8/1/15.
 */
@Path("/tutors")
@Produces("application/json")
@Consumes("application/json")
public class TutorResource extends OptionsResource {

    private TutorsService tutorsService = new TutorsService();

    @GET
    public List<Tutor> getTutors() {
        return tutorsService.getAllTutors();
    }

    @GET
    @Path("/{tutorId}")
    public Response getTutor(@PathParam("tutorId") long tutorId) {
        return Response.status(Response.Status.ACCEPTED)
                .entity(new Gson().toJson(tutorsService.getTutor(tutorId)))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .build();
    }

    @PUT
    @Path("/{tutorId}")
    public Tutor updateTutor(Tutor tutor) {
        return tutorsService.updateTutor(tutor);
    }

    @DELETE
    @Path("/{tutorId}")
    public Tutor deleteTutor(@PathParam("tutorId") long tutorId) {
        return tutorsService.removeTutor(tutorId);
    }

}
