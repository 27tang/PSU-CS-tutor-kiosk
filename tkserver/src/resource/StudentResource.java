package resource;

import com.google.gson.Gson;
import model.persons.Student;
import service.StudentsService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by x on 7/29/15.
 */
@Path("/students")
@Produces("application/json")
@Consumes("application/json")
public class StudentResource extends OptionsResource {

    private StudentsService studentsService = new StudentsService();

    @GET
    public List<Student> getStudents() {
        return studentsService.getAllStudents();
    }



    @GET
    @Path("/{studentId}")
    public Response getStudent(@PathParam("studentId") long studentId) {

        return Response.status(Response.Status.ACCEPTED)
                .entity(new Gson().toJson(studentsService.getStudent(studentId)))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .build();

    }

    @POST
    public Student addStudent(Student student){
        return studentsService.addStudent(student);
    }

    @PUT
    @Path("/{studentId}")
    public Student updateStudent(Student student) {
        return studentsService.updateStudent(student);
    }

    @DELETE
    @Path("/{studentId}")
    public Student removeStudent(@PathParam("studentId") long studentId){
        return studentsService.removeStudent(studentId);
    }
}
