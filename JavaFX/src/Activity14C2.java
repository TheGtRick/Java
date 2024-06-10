import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Activity14C2 extends Application{
    public static void main(String[] args){
        launch(args);
    }
    Socket socket;
    PrintStream writer;
    BufferedReader reader;
    String data;
    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        Text txt1 = new Text("Name");
        txt1.setTranslateX(20);
        txt1.setTranslateY(35);
        Text txt2 = new Text("Message");
        txt2.setTranslateX(20);
        txt2.setTranslateY(115);
        TextField name = new TextField();
        name.setTranslateX(100);
        name.setTranslateY(20);    
        TextField text = new TextField();
        text.setTranslateX(100);
        text.setTranslateY(100);
        TextArea chat = new TextArea();
        chat.setTranslateY(200);
        EventHandler<KeyEvent> handler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if(e.getCode() == KeyCode.ENTER) {
                    String data = name.getText() + ": " + text.getText();
                    writer.println(data);
                    writer.flush();
                }
            }
        };
        text.setOnKeyPressed(handler);
        pane.getChildren().addAll(name, text, chat, txt1, txt2);
        Scene scene = new Scene(pane, 600, 600);
        stage.setTitle("Client");
        stage.setScene(scene);
        stage.show();
        new Thread(){
            @Override
            public void run(){
                    try{
                        socket = new Socket("127.0.0.1", 7777);
                        writer = new PrintStream(socket.getOutputStream());
                        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        new Thread(){
                            @Override
                            public void run() {
                                try {
                                    while (true) {
                                        try{
                                            data = reader.readLine();
                                            chat.appendText(data + "\n");
                                        }
                                        catch (Exception e) {}
                                    }
                                } 
                                catch (Exception e) {
                                    System.out.println("Error!");
                                }
                            }
                        }.start();
                    }
                    catch(Exception e){
                        System.out.println("Error!");
                    }
            }
        }.start();
    }
}
