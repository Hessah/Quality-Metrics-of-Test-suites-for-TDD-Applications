package functional.forms;

import functional.BaseTestPage;

import java.util.List;
import java.util.LinkedList;
import java.util.Collection;

import wheel.annotations.Persist;
import wheel.components.ISelectModel;
import wheel.components.IEnhancingSelectModel;
import wheel.components.RenderableComponent;

public class RadioGroup extends BaseTestPage {
    private List<Person> persons;
    @Persist
    private Person selectedPerson;
    @Persist
    private Person selectedPerson2;

    @Override
    public void preBuild() {
        persons = new LinkedList<Person>();
        persons.add(new Person("Hasse", "Walli", 1));
        persons.add(new Person("Albert", "Järvinen", 2));
        persons.add(new Person("Paavo", "Maijanen", 3));
        persons.add(new Person("Remu", "Aaltonen", 4));
    }

    public void buildComponent() {
        form("form1").
                radioGroup("radioGroup1", selectModel().collection("persons").value("id").label("firstName"), el("selectedPerson")).end().
                radioGroup("radioGroup2", enhancingSelectModel(), el("selectedPerson2"));

        if (selectedPerson != null)
            h1(selectedPerson.getFirstName());

        if (selectedPerson2 != null)
            h2(selectedPerson2.getFirstName());
    }

    public ISelectModel enhancingSelectModel() {
        return new IEnhancingSelectModel() {
            public boolean enhanceComponent(RenderableComponent component, int index, boolean selected) {
                Person person = persons.get(index);

                if (selected)
                    component.renderHint("selected");

                component.addRenderAfter(create().br());
                component.addRenderBefore(create().p(person.getFirstName() + " " + person.getLastName()));

                return true;
            }

            public int getOptionCount() {
                return persons.size();
            }

            public String getLabel(int index) {
                return persons.get(index).getFirstName() + persons.get(index).getLastName();
            }

            public String getValue(int index) {
                return ""+ persons.get(index).getId();
            }

            public Object translateValue(String value) {
                long id = Long.parseLong(value);

                for (Person person : persons) {
                    if (person.getId() == id)
                        return person;
                }

                return null;
            }

            //TODO
            public Collection getObjects() {
                return persons;
            }
        };
    }
}
