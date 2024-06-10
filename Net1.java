import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Net1{
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(8000);
        Socket socket = server.accept();
        Scanner scanner = new Scanner(socket.getInputStream());
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        Scanner send = new Scanner(System.in);
        System.out.println(scanner.nextLine());
        writer.println("Hello");
        writer.flush();
        while(scanner.hasNext()){
            System.out.println("Client: " + scanner.nextLine());
            String s = scanner.nextLine();
            writer.println(s);
            writer.flush();
        }
        writer.close();
        send.close();
        socket.close();
        scanner.close();
        server.close();
    }
}