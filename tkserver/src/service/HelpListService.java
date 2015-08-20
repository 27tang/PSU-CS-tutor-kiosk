package service;

import model.lists.HelpList;
import model.lists.ListEntry;
import model.persons.Student;
import model.persons.Tutor;
import testFakeDatabase.DatabaseClass;

import java.util.*;

/**
 * Created by x on 7/29/15.
 */
public class HelpListService {
    private Map<Long, ListEntry> listEntryMap = DatabaseClass.getListEntries();

    public HelpListService() {
        //adding test entries
      //  listEntryMap.put(999999992L, new ListEntry(1, 999999992, "CS202", 4, 900996708));
      //  listEntryMap.put(999999996L, new ListEntry(2, 999999996, "CS300", 1, 000000000));
        System.out.println(new Date());
    }

    public List<ListEntry> getAllListEntries() {
        return new ArrayList<ListEntry>(listEntryMap.values());
    }

    public ListEntry getListEntry(long id) {
        return listEntryMap.get(id);
    }

    public ListEntry addListEntry(ListEntry listEntry){
        listEntry.setEntryId(listEntryMap.size() + 1);

        System.out.println(listEntry.getCourse());

        System.out.println("SIZE BEFORE:" + listEntryMap.size());
        listEntryMap.put(listEntry.getTuteeId(), listEntry);
        System.out.println("SIZE AFTER:" + listEntryMap.size());
        return listEntry;
    }

    public ListEntry updateListEntry(ListEntry listEntry) {
        if(listEntry.getEntryId() < 0) {
           // System.out.println("GOT IN THE NULL" + listEntry.getEntryId());
            return null;
        }
        System.out.println(listEntry.getTutorId());
        listEntry.setDate(listEntryMap.get(listEntry.getTuteeId()).getDate());
        ListEntry updatedEntry = listEntryMap.put(listEntry.getTuteeId(), listEntry);
       // System.out.println(listEntry.getEntryId());
       // System.out.println(listEntry.getTutorId());
        return updatedEntry;
    }

    public ListEntry removeListEntry(long id) {
        return listEntryMap.remove(id);
    }

    public static void main(String [] args){
        HelpListService helpListService = new HelpListService();
        System.out.println(helpListService.getAllListEntries());
        System.out.println(helpListService.getListEntry(1).getTutorId());
        System.out.println(helpListService.getListEntry(1).getTuteeId());
        System.out.println(helpListService.getListEntry(1).getCourse());

        System.out.println(" ");
        System.out.println(helpListService.getListEntry(2).getTuteeId());
        System.out.println(helpListService.getListEntry(2).getTutorId());
        System.out.println(helpListService.getListEntry(2).getCourse());

    }

}
