package seedu.unify.ui;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.logging.Logger;

import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.unify.commons.core.LogsCenter;
import seedu.unify.logic.Logic;
import seedu.unify.model.ReadOnlyUniFy;
import seedu.unify.model.task.Date;
import seedu.unify.model.task.Task;


public class DailyPanel extends UiPart<Region> {

    private static final String FXML = "DailyPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(DailyPanel.class);
    private ReadOnlyUniFy instance;

    @FXML
    private Label day;
    @FXML
    private ListView<Task> taskListView;

    /**
     * Creates a {@code TaskListPanel} with the given {@code ObservableList}.
     */

    public DailyPanel(LocalDate date, ObservableList<Task> dailyTaskList) {
        super(FXML);
        day.setText(date.getDayOfWeek().toString());

        // create new task list here based on date
        // add a taskList make operation
        // below is placeholder
        taskListView.setItems(dailyTaskList);
        taskListView.setCellFactory(listView -> new DailyPanel.DailyViewCell());
    }

    /**
     * Creates a {@code ObservableList} of task filtered with the given {@code Date}.
     */
    public ObservableList<Task> dateFilteredTasks(Date date) {
        FilteredList<Task> filteredTasks = new FilteredList<>(instance.getTaskList());
        filteredTasks.sort(new TaskTimeComparator());
        return filteredTasks;
    }

    class TaskTimeComparator implements Comparator<Task> {


        @Override
        public int compare(Task o1, Task o2) {
            //Integer.valueOf(o1.getTime().toString()).compareTo(Integer.valueOf(o2.getTime().toString()));

            return Integer.valueOf(o1.getTime().toString()).compareTo(Integer.valueOf(o2.getTime().toString()));
        }
    }


    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Task} using a {@code DayCard}.
     */
    class DailyViewCell extends ListCell<Task> {
        @Override
        protected void updateItem(Task task, boolean empty) {
            super.updateItem(task, empty);

            if (empty || task == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new DayCard(task).getRoot());
            }
        }
    }
}
