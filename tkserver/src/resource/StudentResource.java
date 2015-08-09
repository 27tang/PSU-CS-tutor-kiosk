package resource;

import model.persons.Student;
import service.StudentsService;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by x on 7/29/15.
 */
@Path("/students")
@Produces("application/json")
@Consumes("application/json")
public class StudentResource {

    private StudentsService studentsService = new StudentsService();

    @GET
    public List<Student> getStudents() {
        return studentsService.getAllStudents();
    }



    @GET
    @Path("/{studentId}")
    public Student getStudent(@PathParam("studentId") long studentId) {
        return studentsService.getStudent(studentId);
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
