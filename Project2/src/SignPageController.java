import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SignPageController implements Initializable{
    @FXML private Button LoginButton;
    @FXML private Button SignButton;
    @FXML private TextField email;
    @FXML private ToggleGroup genders;
    @FXML private PasswordField password;
    @FXML private RadioButton r1;
    @FXML private RadioButton r2;
    @FXML private RadioButton r3;
    @FXML private TextField username;
    @FXML private Pane pane1;
    @FXML private Pane pane2;
    @FXML private ImageView loading1;
    @FXML private ImageView loading2;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoginButton.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
        SignButton.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
        pane1.setStyle("-fx-background-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
        pane2.setStyle("-fx-background-radius: 50; -fx-background-color: linear-gradient(to right, #454545 0%, #000 100%);");
    }
    @FXML private void LoginClicked(ActionEvent event) throws Exception{
        loading2.setVisible(true);
        LoginButton.setVisible(false);
        PauseTransition transition = new PauseTransition(Duration.seconds(1.3));
        transition.play();
        transition.setOnFinished(e->{
            loading2.setVisible(false); LoginButton.setVisible(true);
            try{
                Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
                stage.setScene(FXMLLoader.load(getClass().getResource("LoginPage.fxml")));
            }
            catch(IOException r){System.out.println("Error");}
        });
        
    }
    @FXML private void SignClicked(ActionEvent event){
        loading1.setVisible(true);
        SignButton.setVisible(false);
        PauseTransition transition = new PauseTransition(Duration.seconds(1.3));
        transition.play();
        transition.setOnFinished(e->{
            loading1.setVisible(false); SignButton.setVisible(true);
            MainMethods methods = new MainMethods();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText(null);
            String toggle = "";
            if(r1.isSelected()) toggle += r1.getText();
            if(r2.isSelected()) toggle += r2.getText();
            if(r3.isSelected()) toggle += r3.getText();
            if(username.getText().contains(" ") || password.getText().contains(" ") || email.getText().contains(" ")){
                alert.setContentText("Information must not have any space");
                alert.show();
            }
            else{
                if(toggle.equals("") || username.getText().equals("") || password.getText().equals("") || email.getText().equals("")){
                    alert.setContentText("Fields must not be empty");
                    alert.show();
                }
                else{
                    methods.checkData(username.getText(), password.getText(), email.getText());
                    if(methods.larger){
                        alert.setContentText("Username and password must be maximum 9 characters long");
                        alert.show();
                    }
                    else{
                        if(methods.exists){
                            alert.setContentText("Username or email is already exists");
                            alert.show();
                        }
                        else{
                            String l1 = "Username : " + username.getText();
                            String l2 = "Password : " + password.getText();
                            String l3 = "Email : " + email.getText();
                            String l4 = "Gender : " + toggle;
                            String text = l1 + "\n" + l2 + "\n" + l3 + "\n" + l4 + "\n" + "\n";
                            methods.addData(text);
                            System.out.println("SignUp Successful");
                        }
                    }
                }
            }
        });
        
    }
    public String getGender(){
        String gender = "";
        if(r1.isSelected()) gender = r1.getText();
        if(r2.isSelected()) gender = r2.getText();
        if(r3.isSelected()) gender = r3.getText();
        return gender;
    }
}