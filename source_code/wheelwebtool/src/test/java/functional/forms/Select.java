package functional.forms;

import functional.BaseTestPage;
import wheel.util.StringSelectModel;
import wheel.components.ISelectModel;
import wheel.annotations.Persist;

import java.util.List;
import java.util.LinkedList;

public class Select extends BaseTestPage {
    private String basic;
    private List<Person> persons;
    @Persist
    private Person selectedPerson = new Person("", "", 0);
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
        form("selectForm").
                select("empty", new StringSelectModel(), "").end().
                select("basic", basicModel(), el("basic")).end().
                select("dynamic", selectModel().collection("persons").label("firstName").value("id"), el("selectedPerson")).end().
                multiSelect("dynamicMulti", selectModel().collection("persons").label("firstName").value("id"), el("selectedPersons")).end().
                select("enumeration", selectModel().enumeration("selectedPerson.salutation"), el("selectedPerson.salutation"));

        h1(selectedPerson.getFirstName());

        if (selectedPersons != null) {
            for (Person person : selectedPersons) {
                p(person.getFirstName());
            }
        }
    }

    private ISelectModel basicModel() {
        StringSelectModel model = new StringSelectModel();
        model.addValue("label1", "value1");
        model.addValue("label2", "value2");
        model.addValue("label3", "value3");
        model.addValue("label4", "value4");

        return model;
    }
}


