package resource;

import com.google.gson.Gson;
import model.lists.HelpList;
import model.lists.ListEntry;
import service.HelpListService;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by x on 7/29/15.
 */
@Path("/helplist")
@Produces("application/json")
@Consumes("application/json")
public class HelpListResource extends OptionsResource{

    HelpListService helpListService = new HelpListService();

    @GET
    public Response getHelpListEntries(){
        List<ListEntry> theList = helpListService.getAllListEntries();

        System.out.println("GOT TO TEST PLACE");
        return Response.status(Response.Status.ACCEPTED)
                .entity(new Gson().toJson(theList))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .build();
    }

    @GET
    @Path("/{entryId}")
    public Response getHelpListEntry(@PathParam("entryId") long entryId){

        return Response.status(Response.Status.ACCEPTED)
                .entity(new Gson().toJson(helpListService.getListEntry(entryId)))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .build();
    }

    @POST
    public Response addListEntry(ListEntry listEntry){

        System.out.println("POST HAPPENED");
        return Response.status(Response.Status.CREATED)
                .entity(new Gson().toJson(helpListService.addListEntry(listEntry)))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .build();
    }


    @PUT
    @Path("/{entryId}")
    public Response updateListEntry(ListEntry listEntry) {

        System.out.println("PUT happened");
        ListEntry updatedEntry = helpListService.updateListEntry(listEntry);
        return Response.status(200)
                .entity(new Gson().toJson(updatedEntry))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .build();


              /*  Response.status(Response.Status.ACCEPTED)
                .entity(new Gson().toJson(helpListService.updateListEntry(listEntry)))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                .build(); */
    }

    @DELETE
    @Path("/{entryId}")
    public Response deleteListEntry(@PathParam("entryId") long entryId){
        System.out.println("WENT INTO DELETE FOR LISTENTRY: " + 1);
        ListEntry removedEntry = helpListService.removeListEntry(entryId);
        return Response.status(200)
                .entity(new Gson().toJson(removedEntry))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .build();
    }

}
