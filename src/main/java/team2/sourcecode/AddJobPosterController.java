package team2.sourcecode;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.Company;
import project.FinderSystem;
import project.JobPoster;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddJobPosterController implements Initializable {
    FinderSystem finderSystem = LoginController.getFinderSystem();

    @FXML TextField name;
    @FXML ComboBox<String> genderComboBox;
    @FXML ComboBox<Company> companyComboBox;
    @FXML TextField email;
    @FXML TextField password;
    @FXML TextField confirmPassword;
    @FXML Label error;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> genders = new ArrayList<>();
        genders.add("Male");
        genders.add("Female");
        genderComboBox.setItems(FXCollections.observableArrayList(genders));
        companyComboBox.setItems(FXCollections.observableArrayList(FinderSystem.getCompanies()));
        error.setVisible(false);
    }

    public void changeScene(String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JobFinderApplication.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = JobFinderApplication.getStage();
        stage.setScene(scene);
        stage.show();
    }

    public void onAddJobPosterClicked() throws IOException{
        if(password.getText().equals(confirmPassword.getText())){
            finderSystem.addJobPoster(new JobPoster(name.getText(), email.getText(), genderComboBox.getValue(),
                    password.getText(),companyComboBox.getValue().getId()));
            changeScene("AdminPage.fxml");
        }
        else{
            error.setVisible(true);
        }
    }

    public void onBackToMainMenuButtonClicked() throws IOException {
        changeScene("AdminPage.fxml");
    }
}
