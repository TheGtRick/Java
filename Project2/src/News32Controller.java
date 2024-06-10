import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class News32Controller implements Initializable{
    @FXML private Button Button1;
    @FXML private Button Button2;
    @FXML private Button Button3;
    @FXML private Pane pane1;
    @FXML private Pane pane2;
    @FXML private Pane pane3;
    @FXML private Pane pane4;
    @FXML private Pane pane5;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pane1.setStyle("-fx-background-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
        pane2.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right, #454545 0%, #000 100%);");
        pane3.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right, #454545 0%, #000 100%);");
        pane4.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right, #454545 0%, #000 100%);");
        pane5.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right, #454545 0%, #000 100%);");
        Button1.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
        Button2.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
        Button3.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
    }
    @FXML
    void Exit(ActionEvent event) throws Exception{
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.setScene(FXMLLoader.load(getClass().getResource("News3.fxml")));
    }
    @FXML
    void Next(ActionEvent event) throws Exception{
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.setScene(FXMLLoader.load(getClass().getResource("News33.fxml")));
    }
    @FXML
    void Previous(ActionEvent event) throws Exception{
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.setScene(FXMLLoader.load(getClass().getResource("News31.fxml")));
    }
}