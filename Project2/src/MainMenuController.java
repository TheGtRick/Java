import java.io.File;
import java.io.FileOutputStream;
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
import javafx.stage.Stage;

public class MainMenuController implements Initializable{
    private Stage stage = new Stage();
    @FXML private Button InfoButton;
    @FXML private Button ChangeButton;
    @FXML private Button NewsButton;
    @FXML private Button OutButton;
    @FXML private Pane pane1;
    @FXML private Pane pane2;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pane1.setStyle("-fx-background-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
        pane2.setStyle("-fx-background-radius: 50; -fx-background-color: linear-gradient(to right, #454545 0%, #000 100%);");
        InfoButton.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
        ChangeButton.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
        NewsButton.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
        OutButton.setStyle("-fx-background-radius: 20; -fx-background-color: linear-gradient(to right bottom, darkviolet 0%, cyan 100%);");
    }
    @FXML
    void InfoClicked(ActionEvent event) throws Exception{
        Scanner scanner = new Scanner(new File("General Folder/RememberedData.txt"));
        scanner.nextLine();
        while(scanner.hasNextLine()) System.out.println(scanner.nextLine());
        System.out.println();
    }
    @FXML
    void NewsClicked(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewsPage.fxml"));
        Scene scene = loader.load();
        stage.setTitle(null);
        stage.setScene(scene);
        stage.setX(700);
        stage.setY(160);
        stage.show();
    }
    @FXML
    void OutClicked(ActionEvent event) throws Exception{
        String rememberdata = "Remember me : false\n"+"Username : \n"+"Password : \n"+"Email : \n"+"Gender : \n";
        FileOutputStream writer = new FileOutputStream("General Folder/RememberedData.txt");
        byte[] b = rememberdata.getBytes();
        writer.write(b);
        writer.close();
        Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.setScene(FXMLLoader.load(getClass().getResource("LoginPage.fxml")));
    }
    
    @FXML
    void ChangeClicked(ActionEvent event) throws Exception{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Change.fxml"));
            Scene scene = loader.load();
            stage.setTitle("Password Change");
            stage.setScene(scene);
            stage.setX(810);
            stage.setY(650);
            stage.show();
    }
}
