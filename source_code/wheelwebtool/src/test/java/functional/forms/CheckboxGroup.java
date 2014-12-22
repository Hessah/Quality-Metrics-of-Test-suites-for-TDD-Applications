package functional.forms;

import functional.BaseTestPage;

import java.util.List;
import java.util.LinkedList;

import wheel.annotations.Persist;

public class CheckboxGroup extends BaseTestPage {
    private List<Person> persons;
    @Persist
    private List<Person> selectedPersons;

    @Override
    public void preBuild() {
        persons = new LinkedList<Person>();
        persons.add(new Person("Hasse", "Walli", 1));
        persons.add(new Person("Albert", "Järvinen", 2));
        persons.add(new Person("Paavo", "Maijanen", 3));
        persons.add(new Person("Remu", "Aaaltonen", 4));
    }

    public void buildComponent() {
        form("form1").
                checkboxGroup("checkboxGroup1", selectModel().collection("persons").value("id").label("firstName"), el("selectedPersons"));

        if (selectedPersons != null) {
            for (Person person : selectedPersons) {
                p(person.getFirstName());
            }
        }
    }
}
