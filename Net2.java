import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class Net2{
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost", 8000);
        Scanner scanner = new Scanner(socket.getInputStream());
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        writer.println("Client connected");
        writer.flush();
        Scanner send = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            System.out.println("Server: " + s);
            String data = send.nextLine();
            writer.println(data);
            writer.flush();
        }
        writer.close();
        send.close();
        socket.close();
        scanner.close();
    }
}