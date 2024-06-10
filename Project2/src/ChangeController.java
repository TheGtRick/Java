import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChangeController implements Initializable{
    @FXML private TextField newInfo;
    @FXML private TextField target;
    @FXML private Button ChangeButton;
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
    void Change(ActionEvent event) throws Exception{
        MainMethods methods = new MainMethods();
        String tar1 = target.getText();
        String tar2 = newInfo.getText();
        Alert alert = new Alert(AlertType.ERROR);
        alert.setHeaderText(null);
        if(tar1.contains(" ") || tar2.contains(" ")){
            alert.setContentText("Information must not have any space");
        }
        else{
            if(tar1.equalsIgnoreCase("Username")){
                methods.checkData(tar1, tar2, "");
                if(methods.larger){
                    alert.setContentText("Username must be maximum 9 characters long");
                    alert.showAndWait();
                }
                else{
                    File file = new File("General Folder/RememberedData.txt");
                    Scanner scanner = new Scanner(file);
                    String[] data = new String[6];
                    int i = 0;
                    while(scanner.hasNextLine()){
                        data[i] = scanner.nextLine();
                        i++;
                    }
                    scanner.close();
                    String[] username = data[1].split(" : ");
                    File mainFile = new File("General Folder/LoginInformation.txt");
                    Scanner scanner2 = new Scanner(mainFile);
                    String[] mainData = new String[methods.fileLines()];
                    int k = 0;
                    while(scanner2.hasNextLine()){
                        mainData[k] = scanner2.nextLine();
                        k++;
                    }
                    scanner2.close();
                    for(int m = 0; m < methods.fileLines(); m += 5){
                        if(mainData[m].equals(username[0] + " : " + username[1])){
                            String[] mainUsername = mainData[m].split(" : ");
                            mainUsername[1] = tar2;
                            mainData[m] = mainUsername[0] + " : " + mainUsername[1];
                            break;
                        }
                    }
                    String mainNewData = "";
                    for(int n = 0; n < methods.fileLines(); n++) mainNewData += mainData[n] + "\n";
                    username[1] = tar2;
                    data[1] = username[0] + " : " + username[1];
                    String newData = "";
                    for(int j = 0; j < 5; j++){
                        newData += data[j] + "\n";
                    }
                    FileOutputStream out = new FileOutputStream(file);
                    out.write(newData.getBytes());
                    out.close();
                    FileOutputStream mainOut = new FileOutputStream(mainFile);
                    mainOut.write(mainNewData.getBytes());
                    mainOut.close();
                    System.out.println("Info Changed");
                }
            }
            else if(tar1.equalsIgnoreCase("Password")){
                File file = new File("General Folder/RememberedData.txt");
                Scanner scanner = new Scanner(file);
                String[] data = new String[6];
                int i = 0;
                while(scanner.hasNextLine()){
                    data[i] = scanner.nextLine();
                    i++;
                }
                scanner.close();
                String[] email = data[3].split(" : ");
                methods.checkData("", tar2, email[1]);
                if(methods.larger){
                    alert.setContentText("Password must be maximum 9 characters long");
                    alert.showAndWait();
                }
                else{
                        File file1 = new File("General Folder/LoginInformation.txt");
                        Scanner scanner1 = new Scanner(file1);
                        int lines = methods.fileLines();
                        String[] targets = new String[lines];
                        int m = 0;
                        while(scanner1.hasNextLine()){
                            targets[m] = scanner1.nextLine();
                            m++;
                        }
                        scanner1.close();
                        for(int j = 0; j < lines; j += 5){
                            String[] emailt = targets[j + 2].split(" : ");
                            if(emailt[1].equals(email[1])){
                                targets[j + 1] = "Password : " + tar2;
                                break;
                            }
                        }
                        String mainData = "";
                        for(int k = 0; k < lines; k++) mainData += targets[k] + "\n";
                        byte[] b = mainData.getBytes();
                        FileOutputStream writer = new FileOutputStream("General Folder/LoginInformation.txt");
                        writer.write(b);
                        writer.close();
                        String newData = "";
                        data[2] = "Password : " + tar2;
                        for(int n = 0; n < 5; n++) newData += data[n] + "\n";
                        byte[] b1 = newData.getBytes();
                        FileOutputStream write = new FileOutputStream("General Folder/RememberedData.txt");
                        write.write(b1);
                        write.close();
                        System.out.println("Info Changed");
                }
            }
            else if(tar1.equalsIgnoreCase("Gender") || tar1.equalsIgnoreCase("Email")){
                alert.setContentText("You can not change gender and email");
                alert.showAndWait();
            }
            else{
                alert.setContentText("Wrong Input");
                alert.showAndWait();
            }
        }
    }
    @FXML
    void Exit(ActionEvent event){
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }
}
