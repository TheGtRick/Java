import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginPageController implements Initializable{
    private Stage stage = new Stage();
    private boolean remember = false;
    @FXML private Label uEmpty;
    @FXML private Label pEmpty;
    @FXML private PasswordField password;
    @FXML private TextField username;
    @FXML private Pane pane1;
    @FXML private Pane pane2;
    @FXML private Button ForgotButton;
    @FXML private Button LoginButton;
    @FXML private Button SignButton;
    @FXML private ImageView loading1;
    @FXML private ImageView loading2;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pane1.setStyle("-fx-background-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
        pane2.setStyle("-fx-background-radius: 50; -fx-background-color: linear-gradient(to right, #454545 0%, #000 100%);");
        LoginButton.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
        SignButton.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
    }
    @FXML
    void SignClicked(ActionEvent event) throws Exception{
        loading2.setVisible(true);
        SignButton.setVisible(false);
        PauseTransition transition = new PauseTransition(Duration.seconds(1.3));
        transition.play();
        transition.setOnFinished(e->{
            loading2.setVisible(false); SignButton.setVisible(true);
            try{
                Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
                stage.setScene(FXMLLoader.load(getClass().getResource("SignPage.fxml")));
            }
            catch(IOException r){System.out.println("Error");}
        });
    }
    
    @FXML
    void LoginClicked(ActionEvent event) throws Exception{
        loading1.setVisible(true);
        LoginButton.setVisible(false);
        PauseTransition transition = new PauseTransition(Duration.seconds(1.5));
        transition.play();
        transition.setOnFinished(e->{
            loading1.setVisible(false); LoginButton.setVisible(true);
            try{
                MainMethods methods = new MainMethods();
                int lines = methods.fileLines();
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText(null);
                if(username.getText().contains(" ") || password.getText().contains(" ")){
                    alert.setContentText("Information must not have any space");
                    alert.show();
                }
                else{
                    alert.setContentText("Username or Password must not be empty");
                    if(username.getText().equals("") || password.getText().equals("")){
                        if(username.getText().equals("")) uEmpty.setVisible(true);
                        else uEmpty.setVisible(false);
                        if(password.getText().equals("")) pEmpty.setVisible(true);
                        else pEmpty.setVisible(false);
                        alert.show();
                    }
                    if(!username.getText().equals("") && !password.getText().equals("")){
                        methods.logic(username.getText(), password.getText(), lines, remember);
                        if(methods.match){
                            Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
                            stage.setScene(FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
                        }
                        else{
                            alert.setContentText("Username or Password is not correct");
                            alert.show();
                        }
                    }
                }
            }
            catch(IOException r){System.out.println("Error");}
        });
        
    }
    @FXML
    void AdminClicked(ActionEvent event) throws Exception{
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.setScene(FXMLLoader.load(getClass().getResource("AdminLoginPage.fxml")));
    }
    @FXML
    void ForgotClicked(ActionEvent event) throws Exception{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ForgotPassword.fxml"));
            Scene scene = loader.load();
            stage.setTitle("Password Change");
            stage.setScene(scene);
            stage.setX(825);
            stage.setY(700);
            stage.show();
    }
    @FXML
    void RememberMe(ActionEvent event) {
        remember = true;
    }
}
