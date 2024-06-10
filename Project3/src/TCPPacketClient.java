import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPPacketClient {
    private String[] output;
    private InetAddress host;
    public static void main(String[] args){
        try{
            Socket socket = new Socket("127.0.0.1", 1024);
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ObjectOutputStream writer = new ObjectOutputStream(socket.getOutputStream());
            int pNo = 1;
            while(true){
                System.out.println("Enter the data packet: ");
                String data = input.readLine();
                Packet packet = new Packet(pNo, data);
                writer.writeObject(packet);
                writer.flush();
                if(data.equalsIgnoreCase("close")) System.exit(0);
                System.out.println("FROM SERVER: " + reader.readLine());
                pNo++;
            }
        }
        catch(Exception e){
            System.out.println("Error!");
        }
    }
}