import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Zhanuzak_Raiymbek_220107020 {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(1024);
        System.out.println("Waiting for socket requests...");
        Socket socket = server.accept();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream writer = new PrintStream(socket.getOutputStream());
        new Thread(){
            @Override
            public void run() {
                try {
                    while (true) {
                        String d = reader.readLine();
                        System.out.println(d);
                    }
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
                        String data = input.readLine();
                        writer.println("Server: " + data);
                        writer.flush();
                    }
                } 
                catch (Exception e) {
                    System.out.println("Error!");
                }
            }
        }.start();
    }
}