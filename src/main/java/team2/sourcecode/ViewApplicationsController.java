package team2.sourcecode;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import project.FinderSystem;
import project.JobApplication;
import project.JobVacancy;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewApplicationsController implements Initializable {
    FinderSystem finderSystem = LoginController.getFinderSystem();
    JobVacancy vacancy = JobPosterController.getVacancy();

    @FXML ComboBox<JobApplication> jobApplicationComboBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        jobApplicationComboBox.setItems(FXCollections.observableArrayList(vacancy.getApplications()));
    }

    public void onAcceptButtonClicked(){
        finderSystem.setApplicationStatus("Accepted", jobApplicationComboBox.getValue());
    }

    public void onRejectedButtonClicked(){
        finderSystem.setApplicationStatus("Rejected", jobApplicationComboBox.getValue());
    }

    public void onBackToMainMenuButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JobFinderApplication.class.getResource("JobPoster.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = JobFinderApplication.getStage();
        stage.setScene(scene);
        stage.show();
    }
}