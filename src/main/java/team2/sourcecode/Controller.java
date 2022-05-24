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

public class Controller {
    FinderSystem finderSystem = new FinderSystem();
    Stage stage = JobFinderApplication.getStage();

    @FXML private Label enterEmailAndPassword;
    @FXML private TextField email;
    @FXML private PasswordField password;

    public void changeScene(String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JobFinderApplication.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    public void setLoginJobSeekerButton() throws IOException{
        if(finderSystem.login(email.getText(), password.getText(), "s")){
            changeScene(null);
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
            changeScene(null);
        }
        else
        {
            enterEmailAndPassword.setText("Wrong Email or Password, try again");
        }
    }


}