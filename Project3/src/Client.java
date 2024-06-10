import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1", 1024);
        System.out.println("Request send successfully");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream writer = new PrintStream(socket.getOutputStream());
        writer.println("New socket is pop up!");
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
                        writer.println("Client: " + data);
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
