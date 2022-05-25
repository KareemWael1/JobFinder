package team2.sourcecode;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import project.Company;
import project.FinderSystem;
import project.JobVacancy;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class JobSeekerController implements Initializable {
    FinderSystem finderSystem = LoginController.getFinderSystem();
    static Company selectedCompany;

    @FXML private Label welcomeJobSeeker;
    @FXML private TextField search;
    @FXML private RadioButton searchJobs;
    @FXML private RadioButton searchCompanies;
    @FXML private Label searchType;
    @FXML private ComboBox<JobVacancy> jobSearchResults;
    @FXML private ComboBox<Company> companySearchResults;
    @FXML private Button action;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcomeJobSeeker.setText("Welcome, " + finderSystem.getName() + "!");
        searchJobs.setSelected(true);
        searchCompanies.setSelected(false);
        searchType.setVisible(false);
        jobSearchResults.setVisible(false);
        companySearchResults.setVisible(false);
        action.setVisible(false);
    }

    public void changeScene(String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JobFinderApplication.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = JobFinderApplication.getStage();
        stage.setScene(scene);
        stage.show();
    }

    public void onSearchJobsSelected(){
        searchCompanies.setSelected(!searchCompanies.isSelected());
    }
    public void onSearchCompaniesSelected(){
        searchJobs.setSelected(!searchCompanies.isSelected());
    }

    public void onGoButtonClicked(){
        if(searchJobs.isSelected()){
            ObservableList<JobVacancy> jobVacancies;
            if(search.getText().equals("")){
                 jobVacancies = FXCollections.observableArrayList(finderSystem.browseJobs());
            }
            else
            {
                jobVacancies = FXCollections.observableArrayList(finderSystem.browseJobs(search.getText()));
            }
            searchType.setText("Available Jobs:");
            searchType.setVisible(true);
            jobSearchResults.setItems(jobVacancies);
            jobSearchResults.setVisible(true);
            companySearchResults.setVisible(false);
            action.setText("Apply for Job");
            action.setVisible(true);
        }
        else
        {
            ObservableList<Company> companies;
            if(search.getText().equals("")){
                companies = FXCollections.observableArrayList(finderSystem.browseCompanies());
            }
            else
            {
                companies = FXCollections.observableArrayList(finderSystem.browseCompanies(search.getText()));
            }
            searchType.setText("Companies:");
            searchType.setVisible(true);
            companySearchResults.setItems(companies);
            companySearchResults.setVisible(true);
            jobSearchResults.setVisible(false);
            action.setText("View Company");
            action.setVisible(true);
        }
    }

    public void onActionButtonClicked() throws IOException{
        if(action.getText().equals("Apply for Job")){
            finderSystem.addApplication(jobSearchResults.getValue());
            changeScene("MyApplication_JobSeeker.fxml");
        }
        else
        {
            selectedCompany = companySearchResults.getValue();
            changeScene("CompanyPage.fxml");
        }
    }

    public void onViewMyApplicationsClicked() throws IOException{
        changeScene("MyApplication_JobSeeker.fxml");
    }

    public void onMyInfoButtonClicked() throws IOException{
        changeScene("UpdateMyInfo-JobSeeker.fxml");
    }

    public void onLogoutClicked() throws IOException{
        changeScene("LoginPage.fxml");
    }

    public static Company getSelectedCompany(){
        return selectedCompany;
    }
}
