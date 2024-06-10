import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AdminLoginPageController implements Initializable{
    private Stage stage = new Stage();
    @FXML private Button LoginButton;
    @FXML private TextField email;
    @FXML private PasswordField password;
    @FXML private Pane pane1;
    @FXML private Pane pane2;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pane1.setStyle("-fx-background-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
        pane2.setStyle("-fx-background-radius: 50; -fx-background-color: linear-gradient(to right, #454545 0%, #000 100%);");
        LoginButton.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
    }
    @FXML
    void Login(ActionEvent event) throws Exception{
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.setScene(FXMLLoader.load(getClass().getResource("LoginPage.fxml")));
    }
    @FXML
    void LoginClicked(ActionEvent event) throws Exception{
        Alert alert = new Alert(AlertType.ERROR);
        alert.setHeaderText(null);
        Scanner scanner = new Scanner(new File("General Folder/AdminInformation.txt"));
        String email1 = "";
        String password1 = "";
        while(scanner.hasNextLine()){
            String a = scanner.nextLine();
            String[] b = a.split(" : ");
            if(b[0].equals("Password")) password1 = b[1];
            if(b[0].equals("Email")) email1 = b[1];
        }
        if(password.getText().contains(" ") || email.getText().contains(" ")){
            alert.setContentText("Email and password must not have space");
            alert.showAndWait();
        }
        else if(password.getText().equals("") || email.getText().equals("")){
            alert.setContentText("Email and password must not be empty");
            alert.showAndWait();
        }
        else{
            if(password1.equals(password.getText()) && email1.equals(email.getText())){
                System.out.println("Login Successful");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("NewsPage.fxml"));
                Scene scene = loader.load();
                stage.setTitle(null);
                stage.setScene(scene);
                stage.show();
            }
            else{
                alert.setContentText("Username or password is not coorect");
                alert.showAndWait();
            }
        }
    }
}
