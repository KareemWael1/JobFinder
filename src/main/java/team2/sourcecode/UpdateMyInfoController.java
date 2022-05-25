package team2.sourcecode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.FinderSystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateMyInfoController implements Initializable {
    FinderSystem finderSystem = LoginController.getFinderSystem();

    @FXML TextField age;
    @FXML TextField degree;
    @FXML TextField university;
    @FXML TextField yearsOfExperience;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        age.setText(String.valueOf(finderSystem.getAge()));
        degree.setText(finderSystem.getDegree());
        university.setText(finderSystem.getUniversity());
        yearsOfExperience.setText(String.valueOf(finderSystem.getYearsOfExperience()));
    }

    public void onDoneButtonClicked() throws IOException, YearsOfExperienceException, AgeHandling {
        finderSystem.updateInfo(Integer.parseInt(age.getText()), degree.getText(), university.getText(),
                Integer.parseInt(yearsOfExperience.getText()));
        FXMLLoader fxmlLoader = new FXMLLoader(JobFinderApplication.class.getResource("JobSeeker.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = JobFinderApplication.getStage();
        stage.setScene(scene);
        stage.show();
    }
}
