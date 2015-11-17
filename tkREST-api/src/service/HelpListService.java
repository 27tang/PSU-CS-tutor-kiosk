package service;

import model.lists.HelpList;
import model.lists.ListEntry;
import model.persons.Student;
import model.persons.Tutor;
import testFakeDatabase.DatabaseClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by x on 7/29/15.
 */
public class HelpListService {
    private Map<Long, ListEntry> listEntryMap = DatabaseClass.getListEntries();

    public HelpListService() {
        //adding test entries
        listEntryMap.put(1L, new ListEntry(1, 999999992, "CS202", 4, 900996708));
        listEntryMap.put(2L, new ListEntry(2, 999999996, "CS300", 1, 000000000));
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
        listEntryMap.put(listEntry.getEntryId(), listEntry);
        System.out.println("SIZE AFTER:" + listEntryMap.size());
        return listEntry;
    }

    public ListEntry updateListEntry(ListEntry listEntry) {
        if(listEntry.getEntryId() <= 0) {
            return null;
        }
        return listEntryMap.put(listEntry.getEntryId(), listEntry);
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
