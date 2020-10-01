package edu.ucdenver.app;
import edu.ucdenver.university.Course;
import edu.ucdenver.university.Student;
import edu.ucdenver.university.University;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.stage.Stage;
public class Controller {
    public TextField txtStudentName;
    public DatePicker dtpStudentDOB;
    public Button btnAddUndergraduate;

    public TextField txtPhdDissertation;
    public TextField txtCourseNumber;
    public ComboBox<String> selCourseSubject;
    public TextField txtCourseTitle;
    public ListView<Student> lstStudent;
    public ListView<Course> lstCourses;
    public Button btnExit;
    public Tab tabListCourses;
    public Tab tabListStudents;

    private University university;
    public Controller(){
        university = new University();
        this.selCourseSubject = new ComboBox<>();
        this.lstStudent = new ListView<>();
        this.lstCourses = new ListView<>();
    }
    public void initialize(){
        this.selCourseSubject.setItems(FXCollections.observableArrayList("CSCI","MATH"));
        this.lstStudent.setItems(FXCollections.observableArrayList(university.getStudents()));
        this.lstCourses.setItems(FXCollections.observableArrayList(university.getCourses()));
        this.lstCourses.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Course>() {
            @Override
            public void changed(ObservableValue<? extends Course> observable, Course oldValue, Course newValue) {
                for(int i =0; i<university.getCourses().size();i++)
                {
                    if (university.getCourses().get(i).getSubject().toUpperCase().equals(oldValue.getSubject().toUpperCase()) && oldValue.getNumber() == oldValue.getNumber()){
                        university.getCourses().set(i,newValue);
                        break;
                    }
                }
                //I am unsure if this function needs to be called. Test it and if it doesnt work uncomment
                //the following line.
                //listCoursesUpdate(Event.F5);
            }
        });
    }
    private void cleanAddStudent(){
        this.txtStudentName.setText("");
        this.dtpStudentDOB.setValue(null);
        this.txtPhdDissertation.setText("");
    }
    public void addUndergraduate(ActionEvent actionEvent){
        university.addUndergrad(this.txtStudentName.getText(),this.dtpStudentDOB.getValue());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"User added Successfully");
        alert.show();
        System.out.println(university);
        cleanAddStudent();
    }
    public void addPhDStudent(ActionEvent actionEvent){
        university.addPhD(this.txtStudentName.getText(),this.dtpStudentDOB.getValue(),
                this.txtPhdDissertation.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"User added Successfully");
        alert.show();
        System.out.println(university);
        cleanAddStudent();
    }
    public void addMasterStudent(ActionEvent actionEvent){
        university.addMaster(this.txtStudentName.getText(),this.dtpStudentDOB.getValue());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"User added Successfully");
        alert.show();
        System.out.println(university);
        cleanAddStudent();
    }
    public void addCourse(ActionEvent actionEvent){
        try {
            university.addCourse(this.selCourseSubject.getValue(),Integer.parseInt(this.txtCourseNumber.getText()),
                    this.txtCourseTitle.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Course added Successfully");
            alert.show();
            System.out.println(university);
        }
        catch(IllegalArgumentException iae){
            Alert alert = new Alert(Alert.AlertType.ERROR,iae.getMessage());
            alert.show();
        }
    }
    public void exitApplication(ActionEvent actionEvent){
        Stage stage = (Stage)this.btnExit.getScene().getWindow();
        stage.close();
    }
    public void listCoursesUpdate(Event event){
        if(this.tabListCourses.isSelected()){
            this.lstCourses.setItems(FXCollections.observableArrayList(university.getCourses()));
        }
    }
    public void listStudentsUpdate(Event event){
        if(this.tabListStudents.isSelected()) {
            this.lstStudent.setItems(FXCollections.observableArrayList(university.getStudents()));
        }
    }
    public void saveToFile(ActionEvent actionEvent){
        university.saveToFile();
    }
    public void loadFromFile(ActionEvent actionEvent){
        this.university = University.loadFromFile();
        this.initialize();
    }

}
