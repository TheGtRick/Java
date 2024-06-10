import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOStream{
    public static void main(String[] args) throws Exception {
        try{
            FileInputStream file1 = new FileInputStream("src/source/File1.jpg");
            BufferedInputStream is1 = new BufferedInputStream(file1);
            FileOutputStream file4 = new FileOutputStream("src/target/File4.jpg");
            BufferedOutputStream os1 = new BufferedOutputStream(file4);
            FileInputStream file2 = new FileInputStream("src/source/File2.jpg");
            BufferedInputStream is2 = new BufferedInputStream(file2);
            FileOutputStream file5 = new FileOutputStream("src/target/File5.jpg");
            BufferedOutputStream os2 = new BufferedOutputStream(file5);
            FileInputStream file3 = new FileInputStream("src/source/File3.jpg");
            BufferedInputStream is3 = new BufferedInputStream(file3);
            FileOutputStream file6 = new FileOutputStream("src/target/File6.jpg");
            BufferedOutputStream os3 = new BufferedOutputStream(file6);
            int len1 = is1.available();
            int len2 = is2.available();
            int len3 = is3.available();
            if(len1 > 0){
                byte[] b1 = new byte[len1];
                is1.read(b1);
                os1.write(b1);
                System.out.println("For File1.jpg " + b1.length + " copied");
            }
            if(len2 > 0){
                byte[] b1 = new byte[len2];
                is2.read(b1);
                os2.write(b1);
                System.out.println("For File2.jpg " + b1.length + " copied");
            }
            if(len3 > 0){
                byte[] b1 = new byte[len3];
                is3.read(b1);
                os3.write(b1);
                System.out.println("For File3.jpg " + b1.length + " copied");
            }
            is1.close();
            is2.close();
            is3.close();
            os1.close();
            os2.close();
            os3.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch(IOException e){
            System.out.println("Error!");
        }
    }
}
