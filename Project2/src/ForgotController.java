import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ForgotController implements Initializable{
    @FXML private Button ChangeButton;
    @FXML private TextField email;
    @FXML private PasswordField password;
    @FXML private Button ExitButton;
    @FXML private Pane pane;
    @FXML  private Scene scene;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ChangeButton.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
        ExitButton.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
        pane.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right, #454545 0%, #000 100%);");
        scene.setFill(Color.TRANSPARENT);
    }
    @FXML
    void ChangeClicked(ActionEvent event){
        MainMethods methods = new MainMethods();
        try{
            methods.checkData("", password.getText(), email.getText());
            if(methods.larger){
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Password must be maximum 9 characters long");
                alert.showAndWait();
            }
            else{
                if(!methods.exists){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Email is not exists");
                    alert.showAndWait();
                }
                else{
                    File file = new File("General Folder/LoginInformation.txt");
                    Scanner scanner = new Scanner(file);
                    int lines = methods.fileLines();
                    String[] line = new String[lines];
                    int i = 0;
                    while(scanner.hasNextLine()){
                        line[i] = scanner.nextLine();
                        i++;
                    }
                    scanner.close();
                    for(int j = 0; j < lines; j += 5){
                        String[] tar1 = line[j + 2].split(" : ");
                        String[] tar2 = line[j + 1].split(" : ");
                        if(tar1[1].equals(email.getText())){
                            line[j + 1] = tar2[0] + " : " + password.getText();
                            break;
                        }
                    }
                    String data = "";
                    for(int k = 0; k < lines; k++){
                        data += line[k] + "\n";
                    }
                    byte[] b = data.getBytes();
                    FileOutputStream writer = new FileOutputStream("General Folder/LoginInformation.txt");
                    writer.write(b);
                    writer.close();
                    System.out.println("Password Changed");
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(IOException e){
            System.out.println("Error");
        }
    }
    @FXML
    void Exit(ActionEvent event){
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }
}