import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Copy{
    public static void main(String[] args){
        try{
            FileInputStream file1 = new FileInputStream("Target.txt");
            FileOutputStream file2 = new FileOutputStream("Copy.txt");
            BufferedInputStream is = new BufferedInputStream(file1);
            BufferedOutputStream os = new BufferedOutputStream(file2);
            int a = is.read();
            os.write(is.read());
            os.flush();
            System.out.println(a);
        }
        catch(Exception e){
            System.out.println("File not found!");
        }
    }
}