import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Activity8B {
    public static void main(String[] args){
        Employee employee = new Employee(220107020, "Raiymbek", "Zhanuzak", 18, "Don't know");
        try{
        FileOutputStream file = new FileOutputStream("src/ID.ser");
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(employee);
        out.close();
        file.close();
        System.out.println("Object Serialized and saved in ID.ser");
        }
        catch(FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch(IOException e){
            System.out.println("Error");
        }
        try{
            FileInputStream file_inp = new FileInputStream("src/ID.ser");
            ObjectInputStream inp = new ObjectInputStream(file_inp);
            System.out.println(inp.readObject());
            inp.close();
        }
        catch(ClassNotFoundException e){
            System.out.println("Class not found");
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(IOException e){
            System.out.println("Error");
        }
        System.out.println(employee);
    }
}
class Employee implements Serializable{
    private int id;
    private String name;
    private String surname;
    private int age;
    private String departprop;
    public Employee(int id, String name, String surname, int age, String departprop){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.departprop = departprop;
    }
    @Override
    public String toString(){
        return "Employee[id:"+id+", name:"+name+", surname:"+surname+", age:"+age+", department properties:"+departprop+"]";
    }
}