import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Zhanuzak_Raiymbek_220107020 extends Application{
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage){
        try{
            File file = new File("General Folder/RememberedData.txt");
            Scanner scanner = new Scanner(file);
            String[] basic = scanner.nextLine().split(" : ");
            scanner.close();
            if(Boolean.valueOf(basic[1])){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
                Scene scene = loader.load();
                stage.setTitle("hello world!");
                stage.setScene(scene);
                stage.show();
            }
            else{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
                Scene scene = loader.load();
                stage.setTitle("hello world!");
                stage.setScene(scene);
                stage.show();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(IOException e){
            System.out.println("Error");
        }
    }
}