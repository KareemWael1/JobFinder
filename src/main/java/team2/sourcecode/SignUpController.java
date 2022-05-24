package team2.sourcecode;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.FinderSystem;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    FinderSystem finderSystem = LoginController.getFinderSystem();

    @FXML TextField name;
    @FXML ComboBox<String> gender;
    @FXML TextField age;
    @FXML TextField degree;
    @FXML TextField university;
    @FXML TextField yearsOfExperience;
    @FXML TextField email;
    @FXML TextField password;
    @FXML TextField confirmPassword;
    @FXML Label error;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> genders = new ArrayList<>();
        genders.add("Male");
        genders.add("Female");
        gender.setItems(FXCollections.observableArrayList(genders));
        error.setVisible(false);
    }

    public void onSignUpButtonClicked() throws IOException {
        if(password.getText().equals(confirmPassword.getText())){
            finderSystem.addJobSeeker(name.getText(), email.getText(), gender.getValue(), password.getText(),
                    Integer.parseInt(age.getText()), degree.getText(), university.getText(),
                    Integer.parseInt(yearsOfExperience.getText()));
            FXMLLoader fxmlLoader = new FXMLLoader(JobFinderApplication.class.getResource("LoginPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = JobFinderApplication.getStage();
            stage.setScene(scene);
            stage.show();
        }
        else{
            error.setVisible(true);
        }
    }
}
