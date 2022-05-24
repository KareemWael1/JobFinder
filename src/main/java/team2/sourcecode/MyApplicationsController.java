package team2.sourcecode;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.FinderSystem;
import project.JobApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MyApplicationsController implements Initializable {
    FinderSystem finderSystem = LoginController.getFinderSystem();

    @FXML private ComboBox<JobApplication> applicationComboBox;
    @FXML private TextField info;
    @FXML private Button updateApplication;
    @FXML private Button deleteApplication;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        applicationComboBox.setItems(FXCollections.observableArrayList(finderSystem.viewMyApplications()));
        info.setDisable(true);
        updateApplication.setDisable(true);
        deleteApplication.setDisable(true);
    }

    public void onJobApplicationSelected(){
        info.setDisable(false);
        updateApplication.setDisable(false);
        deleteApplication.setDisable(false);
    }

    public void onUpdateApplicationClicked(){
        finderSystem.updateApplication(applicationComboBox.getValue(), info.getText());
    }

    public void onDeleteApplicationClicked(){
        finderSystem.deleteApplication(applicationComboBox.getValue());
    }

    public void onBackToMainMenuButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JobFinderApplication.class.getResource("JobSeeker.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = JobFinderApplication.getStage();
        stage.setScene(scene);
        stage.show();
    }
}
