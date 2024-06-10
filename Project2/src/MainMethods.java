import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainMethods{
    public boolean match = false;
    public boolean exists = false;
    public boolean larger = false;
    public void createFolder(){
        File new_folder = new File("General Folder");
        if(new_folder.mkdir()) System.out.println("Folder Created");
        else System.out.println("Folder Exists");
    }
    public void readFile(){
        try{
        File file = new File("General Folder/LoginInformation.txt");
        if(file.createNewFile()) System.out.println("File Created");
        else System.out.println("File Exists");
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(IOException e){
            System.out.println("Error");
        }
    }
    public void addData(String text){
        try{
            FileInputStream fin = new FileInputStream("General Folder/LoginInformation.txt");
            byte data[] = new byte[fin.available()];
            fin.read(data);
            fin.close();
            String available_text = new String(data);
            FileOutputStream fout = new FileOutputStream("General Folder/LoginInformation.txt");
            text = available_text + text;
            byte[] info = text.getBytes();
            fout.write(info, 0, info.length);
            fout.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(IOException e){
            System.out.println("Error");
        }
    }
    public void checkData(String username, String password, String email){
        if(username.length() > 9 || password.length() > 9) larger = true;
        try{
            FileReader file = new FileReader("General Folder/LoginInformation.txt");
            BufferedReader reader = new BufferedReader(file);
            int lines = fileLines();
            if(lines >= 5){
                String[] line = new String[lines];
                for(int i = 0; i < lines; i++) line[i] = reader.readLine();
                for(int j = 0; j < lines; j += 5){
                    String[] tar1 = line[j].split(" : ");
                    String[] tar2 = line[j + 2].split(" : ");
                    if(tar1[1].equals(username) || tar2[1].equals(email)){
                        exists = true;
                        break;
                    }
                }
                reader.close();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(IOException e){
            System.out.println("Error");
        }
    }
    public int fileLines(){
        int i = 0;
        try{
            File file = new File("General Folder/LoginInformation.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                i++;
                scanner.nextLine();
            }
            scanner.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        return i;
    }
    public void CountLines() throws Exception{
        System.out.println(fileLines());
    }
    public void logic(String username, String password, int lines, boolean remember){
        try{
            FileReader file = new FileReader("General Folder/LoginInformation.txt");
            BufferedReader reader = new BufferedReader(file);
            String[] line = new String[lines];
            for(int i = 0; i < lines; i++) line[i] = reader.readLine();
            for(int j = 0; j < lines; j += 5){
                String[] tar1 = line[j].split(" : ");
                String[] tar2 = line[j + 1].split(" : ");
                if(tar1[1].equals(username) && tar2[1].equals(password)){
                    match = true;
                    String[] tar3 = line[j + 2].split(" : ");
                    String[] tar4 = line[j + 3].split(" : ");
                    String rememberdata = "Remember me : "+remember+"\n"+"Username : " + tar1[1]+"\n"+"Password : "+tar2[1]+"\n"+"Email : "+tar3[1]+"\n"+"Gender : "+tar4[1]+"\n";
                    FileOutputStream writer = new FileOutputStream("General Folder/RememberedData.txt");
                    byte[] b = rememberdata.getBytes();
                    writer.write(b);
                    writer.close();
                    break;
                }
            }
            reader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(IOException e){
            System.out.println("Error");
        }
    }
}