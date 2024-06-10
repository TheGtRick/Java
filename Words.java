import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Words{
    public static void main(String[] args){
        try{
            File file = new File("C:\\Users\\Rakon\\Desktop\\Java\\Words.txt");
            Scanner scan = new Scanner(file);
            int i = 0;
            while(scan.hasNext()){
                scan.next();
                i++;
            }
            scan.close();
            System.out.println(i);
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        } 
    }
}