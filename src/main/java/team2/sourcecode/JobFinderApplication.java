package team2.sourcecode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JobFinderApplication extends Application {
    private static Stage stage;

    @Override
    public void start(Stage stage){
        JobFinderApplication.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(JobFinderApplication.class.getResource("LoginPage.fxml"));
        try{
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.setTitle("Job Finder");
        }
        catch(IOException e){
            Stage.setTitle(e.getMessage());
        }
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static Stage getStage(){
        return stage;
    }
}
