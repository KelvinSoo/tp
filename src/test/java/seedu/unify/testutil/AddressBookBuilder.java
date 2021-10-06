package seedu.unify.testutil;

import seedu.unify.model.TaskList;
import seedu.unify.model.task.Person;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code TaskList ab = new AddressBookBuilder().withPerson("John", "Doe").build();}
 */
public class AddressBookBuilder {

    private TaskList taskList;

    public AddressBookBuilder() {
        taskList = new TaskList();
    }

    public AddressBookBuilder(TaskList taskList) {
        this.taskList = taskList;
    }

    /**
     * Adds a new {@code Person} to the {@code TaskList} that we are building.
     */
    public AddressBookBuilder withPerson(Person person) {
        taskList.addTask(person);
        return this;
    }

    public TaskList build() {
        return taskList;
    }
}
