package model.persons;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by x on 7/28/15.
 */

@XmlRootElement
public class Tutor extends Student {

    public Tutor() {
    }

    public Tutor(long studentId, long badgeNumber, String name) {
        super(studentId, badgeNumber, name);
    }
}
