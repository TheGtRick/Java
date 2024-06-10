import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Activity14A1 extends Application{
    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage stage) throws Exception{
        Pane pane = new Pane();
        TextArea text = new TextArea();
        pane.getChildren().add(text);
        Scene scene = new Scene(pane, 400, 400);
        stage.setScene(scene);
        stage.show();
        new Thread(){
            @Override
            public void run(){
                try{
                    ServerSocket server = new ServerSocket(7777);
                    Socket socket = server.accept();
                    System.out.println("Client connected!");
                    Scanner scanner = new Scanner(socket.getInputStream());
                    PrintWriter writer = new PrintWriter(socket.getOutputStream());
                    new Thread(){
                        @Override
                        public void run(){
                            while(true){
                                String data = scanner.nextLine();
                                String[] a = data.split(" ");
                                double annualInterestRate = Double.parseDouble(a[0]);
                                int numberOfYears = Integer.parseInt(a[1]);
                                double loanAmount = Double.parseDouble(a[2]);
                                double monthlyInterestRate = annualInterestRate / 1200;
                                double monthlyPayment = loanAmount * monthlyInterestRate / (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
                                double totalPayment = monthlyPayment * numberOfYears * 12;
                                text.clear();
                                text.appendText("Annual Interest Rate: " + annualInterestRate + "\nNumber Of Years: " + numberOfYears +"\nLoan Amount: " + loanAmount + "\nMonthly Payment: " + monthlyPayment + "\nTotal Payment: " + totalPayment);
                                writer.println(annualInterestRate + " " + numberOfYears + " " + loanAmount + " " + monthlyPayment + " " + totalPayment);
                                writer.flush();
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