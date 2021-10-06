package seedu.unify.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.unify.model.task.Person;
import seedu.unify.model.task.UniqueTaskList;

/**
 * Wraps all data at the task-list level
 * Duplicates are not allowed (by .isSameTask comparison)
 */
public class TaskList implements ReadOnlyTaskList {

    private final UniqueTaskList tasks;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        tasks = new UniqueTaskList();
    }

    public TaskList() {}

    /**
     * Creates an TaskList using the Tasks in the {@code toBeCopied}
     */
    public TaskList(ReadOnlyTaskList toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the task list with {@code tasks}.
     * {@code tasks} must not contain duplicate tasks.
     */
    public void setTasks(List<Person> tasks) {
        this.tasks.setTasks(tasks);
    }

    /**
     * Resets the existing data of this {@code TaskList} with {@code newData}.
     */
    public void resetData(ReadOnlyTaskList newData) {
        requireNonNull(newData);

        setTasks(newData.getTaskList());
    }

    //// task-level operations

    /**
     * Returns true if a task with the same identity as {@code task} exists in the task list.
     */
    public boolean hasTask(Person person) {
        requireNonNull(person);
        return tasks.contains(person);
    }

    /**
     * Adds a task to the task list.
     * The task must not already exist in the task list.
     */
    public void addTask(Person p) {
        tasks.add(p);
    }

    /**
     * Replaces the given task {@code target} in the list with {@code editedPerson}.
     * {@code target} must exist in the task list.
     * The task identity of {@code editedPerson} must not be the same as another existing task in the task list.
     */
    public void setTask(Person target, Person editedPerson) {
        requireNonNull(editedPerson);

        tasks.setTask(target, editedPerson);
    }

    /**
     * Removes {@code key} from this {@code TaskList}.
     * {@code key} must exist in the task list.
     */
    public void removeTask(Person key) {
        tasks.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return tasks.asUnmodifiableObservableList().size() + " persons";
        // TODO: refine later
    }

    @Override
    public ObservableList<Person> getTaskList() {
        return tasks.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TaskList // instanceof handles nulls
                && tasks.equals(((TaskList) other).tasks));
    }

    @Override
    public int hashCode() {
        return tasks.hashCode();
    }
}
