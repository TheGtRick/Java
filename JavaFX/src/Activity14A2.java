import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Activity14A2 extends Application{
    public static void main(String[] args) throws Exception{
        launch(args);
    }
    Socket socket;
    Scanner scanner;
    PrintWriter writer;
    public void start(Stage stage){
        Pane pane = new Pane();
        Button bt = new Button("Submit");
        bt.setTranslateX(340);
        bt.setTranslateY(60);
        Text t1 = new Text("Annual Interest Rate:");
        t1.setTranslateX(10);
        t1.setTranslateY(35);
        Text t2 = new Text("Number Of Years:");
        t2.setTranslateX(10);
        t2.setTranslateY(75);
        Text t3 = new Text("Loan Amount:");
        t3.setTranslateX(10);
        t3.setTranslateY(115);
        TextField txt1 = new TextField();
        txt1.setTranslateX(150);
        txt1.setTranslateY(20);
        TextField txt2 = new TextField();
        txt2.setTranslateX(150);
        txt2.setTranslateY(60);
        TextField txt3 = new TextField();
        txt3.setTranslateX(150);
        txt3.setTranslateY(100);
        TextArea text = new TextArea();
        text.setMaxHeight(150);
        text.setTranslateX(0);
        text.setTranslateY(150);
        bt.setOnAction(event ->{
            new Thread(){
                @Override
                public void run(){
                    try{
                        text.clear();
                        String data = txt1.getText() + " " + txt2.getText() + " " + txt3.getText();
                        writer.println(data);
                        writer.flush();
                        String[] s = scanner.nextLine().split(" ");
                        text.appendText("Annual Interest Rate: " + s[0] + "\nNumber Of Years: " + s[1] + "\nLoan Amount: " + s[2] + "\nMonthly Payment: " + s[3] + "\nTotal Payment: " + s[4]);
                    }
                    catch(Exception e){
                        System.out.println("Error!");
                    }
                }
            }.start();
        });
        pane.getChildren().addAll(text, txt1, txt2, txt3, t1, t2, t3, bt);
        Scene scene = new Scene(pane, 430, 300);
        stage.setScene(scene);
        stage.show();
        new Thread(){
            @Override
            public void run(){
                try {
                    socket = new Socket("localhost", 7777);
                    scanner = new Scanner(socket.getInputStream());
                    writer = new PrintWriter(socket.getOutputStream());
                }
                catch (Exception e) {
                    System.out.println("Error!");
                }
            }
        }.start();
    }
}