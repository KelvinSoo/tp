package seedu.unify.model;

import javafx.collections.ObservableList;
import seedu.unify.model.task.Person;

/**
 * Unmodifiable view of a tasks list
 */
public interface ReadOnlyTaskList {

    /**
     * Returns an unmodifiable view of the tasks list.
     * This list will not contain any duplicate tasks.
     */
    ObservableList<Person> getTaskList();

}
