package resource;

import model.lists.HelpList;
import model.lists.ListEntry;
import service.HelpListService;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by x on 7/29/15.
 */
@Path("/helplist")
@Produces("application/json")
@Consumes("application/json")
public class HelpListResource {

    HelpListService helpListService = new HelpListService();


/*
    @GET
    @Produces("text/plain")
    public String test(){
        return "HELLO WORLD???";
    }
*/

    @GET
    public List<ListEntry> getHelpListEntries(){
        return helpListService.getAllListEntries();
    }

    @GET
    @Path("/{entryId}")
    public ListEntry getHelpListEntry(@PathParam("entryId") long entryId){
        return helpListService.getListEntry(entryId);
    }

    @POST
    public ListEntry addListEntry(ListEntry listEntry){

        System.out.println("POST HAPPENED");
        return helpListService.addListEntry(listEntry);
    }


    //PUT function

    //DELETE

}
