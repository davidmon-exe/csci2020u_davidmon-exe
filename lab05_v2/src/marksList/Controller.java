package marksList;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Controller {
    @FXML private TableColumn idCol;
    @FXML private TableView<StudentRecord> tableView;
    @FXML private TextField studentIdField;
    @FXML private TextField assignmentMarkField;
    @FXML private TextField midtermMarkField;
    @FXML private TextField examMarkField;
    private ObservableList<StudentRecord> data;
    @FXML
    public void initialize(){
        System.out.println("App is running...");
        tableView.setItems(DataSource.getAllMarks());
    }

    @FXML
    public void addStudentRecord() {
        data = tableView.getItems();
        try {
            data.add(new StudentRecord(studentIdField.getText(),
                    Double.parseDouble(assignmentMarkField.getText()),
                    Double.parseDouble(midtermMarkField.getText()),
                    Double.parseDouble(examMarkField.getText())
            ));
        }catch (NumberFormatException e){
            System.err.println("NumberFormatException was thrown: " + e.toString());
        }
        studentIdField.setText("");
        assignmentMarkField.setText("");
        midtermMarkField.setText("");
        examMarkField.setText("");
    }
}
