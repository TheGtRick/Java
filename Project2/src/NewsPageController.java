import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class NewsPageController implements Initializable{
    Stage stage = new Stage();
    @FXML private Button Busy;
    @FXML private Button Button0;
    @FXML private Button Eco;
    @FXML private Button Sport;
    @FXML private Button Tech;
    @FXML private Button exit;
    @FXML private Pane pane;
    @FXML private Pane pane0;
    @FXML private Pane pane1;
    @FXML private Pane pane2;
    @FXML private Pane pane3;
    @FXML private Pane pane4;
    @FXML private Line line;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pane.setStyle("-fx-background-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
        pane0.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right, #454545 0%, #000 100%);");
        pane1.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right, #454545 0%, #000 100%);");
        pane2.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right, #454545 0%, #000 100%);");
        pane3.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right, #454545 0%, #000 100%);");
        pane4.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right, #454545 0%, #000 100%);");
        Busy.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
        Eco.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
        Sport.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
        Tech.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
        Button0.setStyle("-fx-background-color: transparent; -fx-text-fill: linear-gradient(to right bottom, darkviolet 0%, cyan 100%); -fx-border-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
        exit.setStyle("-fx-background-color: transparent; -fx-text-fill: linear-gradient(to right bottom, darkviolet 0%, cyan 100%); -fx-border-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
    }
    @FXML
    void Button1(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("News1.fxml"));
        Scene scene = loader.load();
        stage.setTitle(null);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void Button2(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("News2.fxml"));
        Scene scene = loader.load();
        stage.setTitle(null);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void Button3(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("News3.fxml"));
        Scene scene = loader.load();
        stage.setTitle(null);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void Button4(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("News4.fxml"));
        Scene scene = loader.load();
        stage.setTitle(null);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void Contact(ActionEvent event) throws Exception{
        Scanner scanner = new Scanner(new File("General Folder/AdminInformation.txt"));
        System.out.println("Contact Info");
        scanner.nextLine();
        scanner.nextLine();
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
        System.out.println();
        scanner.close();
    }
    @FXML
    void Exit(ActionEvent event){
        Stage stage1 = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage1.close();
    }
}
