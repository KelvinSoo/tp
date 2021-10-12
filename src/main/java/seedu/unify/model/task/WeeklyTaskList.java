package seedu.unify.model.task;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class WeeklyTaskList implements Iterable<Task> {

    private Integer weekNumber = 41;
    private ObservableList<Task> taskList;

    public WeeklyTaskList(ObservableList<Task> taskList) {
        this.taskList = taskList;
    }

    public ObservableList<Task> getTaskList() {
        return taskList;
    }

    public FilteredList<Task> getDailyTaskList(LocalDate date) {
        FilteredList<Task> filteredList = taskList.filtered(new TaskContainsDatePredicate(date));
        return filteredList;
    }

    public LocalDate getFirstDayOfWeek(){
        LocalDate firstDay = LocalDate.ofYearDay(2021,weekNumber * 7 - 3);
        return firstDay;
    }

    public void setWeekNumber(Integer weekNumber) {
        this.weekNumber = weekNumber;
    }

    @Override
    public Iterator<Task> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Task> action) {

    }

    @Override
    public Spliterator<Task> spliterator() {
        return null;
    }
}
