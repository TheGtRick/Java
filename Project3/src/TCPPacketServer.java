import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPPacketServer {
    public static void main(String[] args){
        try{
            System.out.println("Opening port...");
            ServerSocket server = new ServerSocket(1024);
            Socket socket = server.accept();
            ObjectInputStream reader = new ObjectInputStream(socket.getInputStream());
            PrintStream writer = new PrintStream(socket.getOutputStream());
            while (true) {
                String[] data = reader.readObject().toString().split(" ");
                if(data[1].equalsIgnoreCase("CLOSE")) System.exit(0);
                System.out.println("Receieving from Clients Packet's serialNo#" + data[0]);
                System.out.println("And Packet's Data is " + data[1].toUpperCase());
                writer.println("Packed SerialNo#" + data[0] + " is received");
                writer.flush();
            }
        }
        catch (Exception e){
            System.out.println("Error!");
        }
    }
}
