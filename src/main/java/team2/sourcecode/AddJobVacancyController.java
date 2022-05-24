package team2.sourcecode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.FinderSystem;

import java.io.IOException;

public class AddJobVacancyController {
    FinderSystem finderSystem = LoginController.getFinderSystem();

    @FXML private TextField jobTitle;
    @FXML private TextField jobDescription;

    public void onAddJobVacancyClicked() throws IOException {
        finderSystem.addJobVacancy(jobTitle.getText(), jobDescription.getText());
        FXMLLoader fxmlLoader = new FXMLLoader(JobFinderApplication.class.getResource("JobPoster.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = JobFinderApplication.getStage();
        stage.setScene(scene);
        stage.show();
    }
}
