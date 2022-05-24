package team2.sourcecode;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.Company;
import project.FinderSystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CompanyPageController implements Initializable {
    FinderSystem finderSystem = LoginController.getFinderSystem();
    Company selectedCompany = JobSeekerController.getSelectedCompany();

    @FXML private Label companyName;
    @FXML private Label companyDescription;
    @FXML private Label numberOfEmployees;
    @FXML private ListView<String> reviews;
    @FXML private TextField myReview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        companyName.setText(selectedCompany.getName());
        companyDescription.setText(selectedCompany.getCompanyDescription());
        numberOfEmployees.setText(String.valueOf(selectedCompany.getNumberOfEmployees()));
        reviews.setItems(FXCollections.observableArrayList(selectedCompany.getReviews()));
    }

    public void onAddReviewButtonClicked(){
        // Didn't handle (Can't add review unless has an application to that company)
        finderSystem.addReview(myReview.getText(), selectedCompany.getId());
    }

    public void onBackToMainMenuButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JobFinderApplication.class.getResource("JobSeeker.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = JobFinderApplication.getStage();
        stage.setScene(scene);
        stage.show();
    }
}
