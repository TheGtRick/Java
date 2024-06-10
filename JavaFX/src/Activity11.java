import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Activity11 extends Application{
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage){
        String[] keywordString = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "for", "final", "finally", "float", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while", "true", "false", "null"};
        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
        FileChooser filechooser = new FileChooser();
        Button bt = new Button("Search a keyword from file:");
        bt.setTranslateX(100);
        bt.setTranslateY(200);
        TextField key = new TextField();
        key.setTranslateX(100);
        key.setTranslateY(150);
        Label lb1 = new Label("Keyword Count");
        lb1.setTranslateX(100);
        lb1.setTranslateY(100);
        Label lb2 = new Label("Enter a keyword:");
        lb2.setTranslateX(100);
        lb2.setTranslateY(125);
        Text txt1 = new Text();
        txt1.setTranslateX(300);
        txt1.setTranslateY(220);
        Text txt2 = new Text();
        txt2.setTranslateX(100);
        txt2.setTranslateY(250);
        Text txt3 = new Text();
        txt3.setTranslateX(100);
        txt3.setTranslateY(275);
        bt.setOnAction(e ->{
            if(keywordSet.contains(key.getText())){
                try{
                    File file = filechooser.showOpenDialog(stage);
                    Scanner scanner = new Scanner(file);
                    int i = 0;
                    int j = 0;
                    while(scanner.hasNext()){
                        String a = scanner.next();
                        if(a.equals(key.getText())) i++;
                        if(keywordSet.contains(a)) j++;
                    }
                    scanner.close();
                    txt1.setText(file.getName() + " file choosen");
                    txt2.setText("Number of the keywords in file: " + file.getName() + " is: " + j);
                    txt3.setText("Number of keyword: " + key.getText() + " is: " + i);
                }
                catch(FileNotFoundException ex){
                    System.out.println("File not found");
                }
                
            }
            else{
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Enter the keyword");
                alert.show();
            }
        });
        Pane pane = new Pane();
        pane.getChildren().addAll(bt, key, lb1, lb2, txt1, txt2, txt3);
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}
