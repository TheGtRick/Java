import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Activity14B1 extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    ServerSocket server;
    Socket socket;
    PrintStream writer;
    BufferedReader reader;
    @Override
    public void start(Stage stage) throws Exception {
        TextArea txt1 = new TextArea();
        TextArea txt2 = new TextArea();
        txt2.setTranslateY(300);
        Pane pane = new Pane();
        EventHandler<KeyEvent> handler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if(e.getCode() == KeyCode.ENTER) {
                    String data = txt1.getText().replaceAll("\n", "//");
                    writer.println(data);
                    writer.flush();
                }
            }
        };
        txt1.setOnKeyPressed(handler);
        pane.getChildren().addAll(txt1,txt2);
        Scene scene = new Scene(pane, 600, 550);
        stage.setTitle("Server");
        stage.setScene(scene);
        stage.show();
        new Thread(){
            @Override
            public void run() {
                try {
                    server = new ServerSocket(7777);
                    socket = server.accept();
                    writer = new PrintStream(socket.getOutputStream());
                    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                } 
                catch (Exception e) {
                    System.out.println("Error!");
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                try {
                    while (true) {
                        try{
                            String d = reader.readLine().replaceAll("//", "\n");
                            txt2.setText(d);
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
}