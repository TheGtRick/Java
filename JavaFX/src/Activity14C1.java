import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Activity14C1 extends Application{
    public static void main(String[] args){
        launch(args);
    }
    ServerSocket server;
    Socket socket;
    Socket absolute;
    BufferedReader reader;
    PrintStream writer;
    String data;
    String absoluteData;
    ArrayList<Client> clients = new ArrayList<Client>();
    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        TextArea text = new TextArea();
        pane.getChildren().add(text);
        Scene scene = new Scene(pane, 600, 600);
        stage.setTitle("Server");
        stage.setScene(scene);
        stage.show();
        Thread a = new Thread(){
            @Override
            public void run() {
                try{
                    server = new ServerSocket(7777);
                    text.appendText("Server started\n");
                    socket = server.accept();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        Thread b = new Thread(){
            @Override
            public void run() {
                try{
                    absolute = new Socket("localhost", 7777);
                    writer = new PrintStream(absolute.getOutputStream());
                    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));      
                    
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        a.start(); b.start(); a.join(); b.join();
        new Thread(){
            @Override
            public void run() {
                try{
                    while(true){
                        try{
                            Client client = new Client(server);
                            clients.add(client);
                            text.appendText("New connection from " + client.toString() + "\n");
                            new Thread(){
                                @Override
                                public void run(){
                                    while(true){
                                        try{
                                            data = client.reader.readLine();
                                            while(data!= null){
                                            writer.println(data);
                                            writer.flush();
                                            data = client.reader.readLine();
                                            }
                                        }
                                        catch(Exception e){
                                            System.out.println("Error!");
                                        }
                                    }
                                }
                            }.start();
                            new Thread(){
                                @Override
                                public void run(){
                                    while(true){
                                        try{
                                            absoluteData = reader.readLine();
                                            for(int i = 0; i < clients.size(); i++){
                                                clients.get(i).writer.println(absoluteData);
                                                clients.get(i).writer.flush();
                                            }
                                        }
                                        catch(Exception e){
                                            System.out.println("Error!");
                                        }
                                    }
                                }
                            }.start();
                        }
                        catch (Exception e){
                            System.out.println("Error!");
                        }
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();
        
    }
    class Client{
        Socket socket;
        BufferedReader reader;
        PrintStream writer;
        public Client(ServerSocket server) throws Exception {
            this.socket = server.accept();
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer = new PrintStream(socket.getOutputStream());
        }
        public String toString(){
            return socket.toString();
        }
    }
}