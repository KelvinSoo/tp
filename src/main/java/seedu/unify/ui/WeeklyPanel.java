package seedu.unify.ui;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.unify.commons.core.LogsCenter;
import seedu.unify.logic.Logic;
import seedu.unify.model.task.Date;
import seedu.unify.model.task.WeeklyTaskList;

public class WeeklyPanel extends UiPart<Region> {

    private static final String FXML = "WeeklyPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(WeeklyPanel.class);
    // add date to be passed down from Weekly Panel
    private Date[] dateRange;

    @FXML
    private Label weekLabel;

    @FXML
    private HBox dailyHBox;

    /**
     * Creates a {@code WeeklyPanel} with the given {@code ObservableList}.
     */
    public WeeklyPanel(WeeklyTaskList weeklyTaskList) {
        super(FXML);
        LocalDate firstDayOfWeek = weeklyTaskList.getFirstDayOfWeek();
        weekLabel.setText("Week " + firstDayOfWeek.get(ChronoField.ALIGNED_WEEK_OF_YEAR));
        // must include an increment operation to either
        // 1) Set Date for Daily Panels
        // 2) Form a date range and loop through to create Daily Panels
        LocalDate currentDay = firstDayOfWeek;
        for (int i = 0; i < 7; i++) {
            // these are just placeholders
            DailyPanel dailyPanel = new DailyPanel(currentDay, weeklyTaskList.getDailyTaskList(currentDay));
            currentDay = currentDay.plusDays(1);
            dailyHBox.getChildren().add(dailyPanel.getRoot());
            dailyPanel.getRoot().setStyle("-fx-border-style: solid inside;" + "-fx-border-width: 1;");
            dailyHBox.widthProperty().addListener(e -> dailyPanel.getRoot().setPrefWidth(dailyHBox.getWidth() / 7));
        }
    }
}
