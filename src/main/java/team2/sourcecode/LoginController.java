package team2.sourcecode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.FinderSystem;

import java.io.IOException;

public class LoginController {
    private static FinderSystem finderSystem = new FinderSystem();

    @FXML private Label enterEmailAndPassword;
    @FXML private TextField email;
    @FXML private PasswordField password;

    public void changeScene(String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JobFinderApplication.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = JobFinderApplication.getStage();
        stage.setScene(scene);
        stage.show();
    }

    public void setLoginJobSeekerButton() throws IOException{
        if(finderSystem.login(email.getText(), password.getText(), "s")){
            changeScene("JobSeeker.fxml");
        }
        else
        {
            enterEmailAndPassword.setText("Wrong Email or Password, try again");
        }
    }
    public void setLoginJobPosterButton() throws IOException{
        if(finderSystem.login(email.getText(), password.getText(), "p")){
            changeScene("JobPoster.fxml");
        }
        else
        {
            enterEmailAndPassword.setText("Wrong Email or Password, try again");
        }
    }
    public void setLoginAdminButton() throws IOException{
        if(finderSystem.login(email.getText(), password.getText(), "a")){
            changeScene("AdminPage.fxml");
        }
        else
        {
            enterEmailAndPassword.setText("Wrong Email or Password, try again");
        }
    }

    public void onSignUpButtonClicked() throws IOException{
        changeScene("SignUp.fxml");
    }

    public static FinderSystem getFinderSystem(){
        return finderSystem;
    }
}