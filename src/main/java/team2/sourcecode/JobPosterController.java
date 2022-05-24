package team2.sourcecode;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import project.FinderSystem;
import project.JobVacancy;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class JobPosterController implements Initializable {
    private FinderSystem finderSystem = LoginController.getFinderSystem();
    private static JobVacancy vacancy;

    @FXML private Label welcomeJobPoster;
    @FXML private ComboBox<JobVacancy> jobVacancyComboBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcomeJobPoster.setText("Welcome, " + finderSystem.getName() + "!");
        ObservableList<JobVacancy> jobVacancies = FXCollections.observableArrayList(finderSystem.getJobVacancies());
        jobVacancyComboBox.setItems(jobVacancies);
    }

    public void changeScene(String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JobFinderApplication.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = JobFinderApplication.getStage();
        stage.setScene(scene);
        stage.show();
    }

    public void onViewApplicationsButtonClicked() throws IOException{
        vacancy = jobVacancyComboBox.getValue();
        changeScene("ReviewApplication.fxml");
    }
    public void onAddNewJobVacancyClicked() throws IOException {
        changeScene("AddJobVacancy_JobPoster.fxml");
    }

    public void onDeleteJobVacancyClicked(){
        finderSystem.deleteJob(jobVacancyComboBox.getValue());
        jobVacancyComboBox.setItems(FXCollections.observableArrayList(finderSystem.getJobVacancies()));
    }

    public void onLogoutClicked() throws IOException{
        changeScene("LoginPage.fxml");
    }

    public static JobVacancy getVacancy(){
        return vacancy;
    }
}