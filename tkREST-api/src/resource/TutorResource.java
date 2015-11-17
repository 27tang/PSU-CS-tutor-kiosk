package resource;

import model.persons.Tutor;
import service.TutorsService;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by x on 8/1/15.
 */
@Path("/tutors")
@Produces("application/json")
@Consumes("application/json")
public class TutorResource {

    private TutorsService tutorsService = new TutorsService();

    @GET
    public List<Tutor> getTutors() {
        return tutorsService.getAllTutors();
    }

    @GET
    @Path("/{tutorId}")
    public Tutor getTutor(@PathParam("tutorId") long tutorId) {
        return tutorsService.getTutor(tutorId);
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
