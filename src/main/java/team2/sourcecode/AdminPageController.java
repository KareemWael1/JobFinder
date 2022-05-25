package team2.sourcecode;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.Company;
import project.FinderSystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminPageController implements Initializable {
    private FinderSystem finderSystem = LoginController.getFinderSystem();

    @FXML ComboBox<Company> companyComboBox;
    @FXML TextField updatedCompanyDescription;
    @FXML TextField newCompanyName;
    @FXML TextField newCompanyDescription;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        companyComboBox.setItems(FXCollections.observableArrayList(FinderSystem.getCompanies()));
    }

    public void changeScene(String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JobFinderApplication.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = JobFinderApplication.getStage();
        stage.setScene(scene);
        stage.show();
    }

    public void onUpdateCompanyButtonClicked(){
        finderSystem.updateCompanyDescription(companyComboBox.getValue(), updatedCompanyDescription.getText());
        companyComboBox.setItems(FXCollections.observableArrayList(FinderSystem.getCompanies()));
    }

    public void onAddNewCompanyButtonClicked(){
        finderSystem.addCompany(new Company(newCompanyName.getText(), newCompanyDescription.getText()));
        companyComboBox.setItems(FXCollections.observableArrayList(FinderSystem.getCompanies()));
    }

    public void onAddJobPosterButtonClicked() throws IOException{
        changeScene("AddJobPoster.fxml");
    }

    public void onLogoutClicked() throws IOException {
        changeScene("LoginPage.fxml");
    }
}