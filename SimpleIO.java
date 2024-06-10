import java.io.*;
import java.util.*;
public class SimpleIO{
    public static void main(String[] args){
        try{
        File file = new File("C:\\Users\\Rakon\\Desktop\\Java\\Text.txt");
        Scanner scan = new Scanner(System.in);
        String b = "";
        while(!b.equals("Text.txt")){
            System.out.println("File name: ");
            b = scan.next();
        }
        System.out.println("Second file name: ");
        b = scan.next();
        scan.close();
        Scanner s = new Scanner(file);
        while(s.hasNextLine()){
            b = s.nextLine();
            String[] a = b.split(" ");
            int c = 0;
            for(int i = 0; i < a.length; i++)
                if(a[i].equalsIgnoreCase("the")) c++;
            System.out.println(b + " [" + c + "]");
        }
        s.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found!");
        }
    }
}