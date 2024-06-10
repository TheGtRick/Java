import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
public class Raiymbek_Zhanuzak_220107020{
    public static void main(String[] args){
        MainMenu menu = new MainMenu();
        while(true){
            System.out.println("*******************************************");
            System.out.println("     Organizational Management System      ");
            System.out.println("*******************************************");
            menu.menu();
            System.out.println("Press Enter to Continue...");
            try {
                System.in.read();
            } catch (IOException e) {
                System.out.println("Error!");
            }
        }
    }
}
class MainMenu extends Raiymbek_Zhanuzak_220107020{
    Scanner scanner = new Scanner(System.in);
    public void menu(){
        System.out.println("Press 1 : Add an Employee Details");
        System.out.println("Press 2 : See an Employee Details");
        System.out.println("Press 3 : Remove an Employee");
        System.out.println("Press 4 : Update Employee Details");
        System.out.println("Press 5 : Exit the EMS portal");
        System.out.println();
        try{
            System.out.println("Please enter choice: "); String choice = scanner.next();
            switch(choice){
                case "1":
                    scanner.nextLine();
                    System.out.println("Enter Employee's name --------:"); String name = scanner.nextLine();
                    System.out.println("Enter Employee's Age ---------:"); int age = scanner.nextInt();
                    System.out.println("Enter Employee's ID ----------:"); int employ_ID = scanner.nextInt();
                    System.out.println("Enter Employee's Email ID ----:"); String email = scanner.next();
                    System.out.println("Enter Employee's Position ----:"); String position = scanner.next();
                    System.out.println("Enter Employee contact Info --:"); long employ_contact = scanner.nextLong();
                    System.out.println("Enter Employee's Salary ------:"); float employ_salary = scanner.nextFloat();
                    Employee_Add ep = new Employee_Add(name, age, employ_ID, email, position, employ_contact, employ_salary);
                    ep.createFile();
                    break;
                case "2":
                    System.out.println("Please Enter Employee's ID : "); int id_view = scanner.nextInt();
                    Employee_Show show = new Employee_Show();
                    show.viewFile(String.valueOf(id_view));
                    break;
                case "3":
                    System.out.println("Please Enter Employee's ID : "); int id_remove = scanner.nextInt();
                    Employee_Remove remove = new Employee_Remove();
                    remove.removeFile(id_remove);
                    break;
                case "4":
                    System.out.println("Please Enter ID : "); int id_change = scanner.nextInt();
                    Employee_Show change = new Employee_Show();
                    change.viewFile(String.valueOf(id_change));
                    if(change.done){
                        System.out.println("Please Enter the detail you want to Update :");
                        System.out.println("For example :");
                        System.out.println("If you want to Change the Name, then Enter Current Name and Press Enter. Then write the new Name then Press Enter. It will Update the Name");
                        scanner.nextLine();
                        System.out.println();
                        String variable1 = scanner.nextLine();
                        boolean have = false;
                        try{
                            File file = new File("file" + id_change + ".txt");
                            Scanner s = new Scanner(file);
                            String[] check = new String[7];
                            String[] detail = new String[2];
                            int i = 0;
                            while(s.hasNextLine()){
                                check[i] = s.nextLine();
                                detail = check[i].split(" : ");
                                if(detail[0].equals(variable1)) have = true;
                            }
                            s.close();
                        }
                        catch(Exception e){
                            System.out.println("Error!");
                        }
                        if(!have) System.out.println("Incorrect input!");
                        else{
                            System.out.println("Please Enter the Updated Info : "); String variable2 = scanner.nextLine();
                            Employee_Update update = new Employee_Update();
                            update.updateFile(String.valueOf(id_change), variable1, variable2);
                            if(update.done) System.out.println("File was updated");
                            System.out.println();
                        }
                    }
                    break;
                case "5":
                    CodeExit exit = new CodeExit();
                    exit.out();
                    break;
                default:
                    System.out.println("It's not correct Input!");
                    System.out.println("Try again!");
            }
        }
        catch(InputMismatchException e){
            System.out.println("It's not correct Input!");
            System.out.println("Try again!");
        }
    }
}
class EmployDetail{
    long employ_contact;
    float employ_salary;
    int employ_ID;
    String position;
    String email;
    int age;
    String name;
    public EmployDetail(String name, int age, int employ_ID, String email, String position, long employ_contact, float employ_salary){
        this.name = name;
        this.age = age;
        this.employ_ID = employ_ID;
        this.email = email;
        this.position = position;
        this.employ_contact = employ_contact;
        this.employ_salary = employ_salary;
    }
    public void employee_details(){
        System.out.println("Employee ID : "+ employ_ID);
        System.out.println("Employee Name : "+ name);
        System.out.println("Age : " + age);
        System.out.println("Email Information : " + email);
        System.out.println("Position : " + position);
        System.out.println("Employee Contact : " + employ_contact);
        System.out.println("Employee Salary : "+employ_salary);
    }
}
class Employee_Add extends EmployDetail{
    public Employee_Add(String name, int age, int employ_ID, String email, String position, long employ_contact, float employ_salary){
        super(name, age, employ_ID, email, position, employ_contact, employ_salary);
    }
    public void createFile(){
        try{
            File file = new File("file" + employ_ID + ".txt");
            if (file.createNewFile()) System.out.println("File created: " + "file" + employ_ID + ".txt");
            else System.out.println("File already exists.");
            FileWriter writer = new FileWriter("file" + employ_ID + ".txt");
            String file_text = "Employee ID : "+employ_ID+"\n"+"Employee Name : "+ name+"\n"+"Age : "+age+"\n"+"Email Information : "+email+"\n"+"Position : "+position+"\n"+"Employee Contact : "+employ_contact+"\n"+"Employee Salary : "+employ_salary;
            writer.write(file_text);
            writer.close();
          } 
          catch(IOException e){
            System.out.println("Failed to create file");
          }
    }
}
class Employee_Show{
    public boolean done = false;
    public void viewFile(String id){
        try{
            File reader = new File("file" + id + ".txt");
            Scanner s = new Scanner(reader);
            while(s.hasNextLine()){
                System.out.println(s.nextLine());
            }
            done = true;
            s.close();
        } 
        catch (Exception e) {
            System.out.println("File not found");
        }
    }
}
interface Remove{
    public void removeFile(int ID);
}
class Employee_Remove implements Remove{
    @Override
    public void removeFile(int ID){
        File file = new File("file" + ID + ".txt");
        boolean result = file.delete();
        if(result) System.out.println("File is successfully deleted");
        else System.out.println("File not found");
    }
}
class Employee_Update{
    public boolean done = false;
    public void updateFile(String s, String o, String n){
        try{
            File file = new File("file" + s + ".txt");
            Scanner scan = new Scanner(file);
            String[] file_information = new String[7];
            String[] compare;
            int i = 0;
            while(scan.hasNextLine()){
                file_information[i] = scan.nextLine();
                compare = file_information[i].split(" : ");
                if(compare[0].equals(o)){
                    if(i == 0 || i == 2){
                        compare[1] = String.valueOf(Long.valueOf(n));
                        done = true;
                    }
                    else if(i == 6){
                        compare[1] = String.valueOf(Float.parseFloat(n.replace(',', '.')));
                        done = true;
                    }
                    else{
                        compare[1] = n;
                        done = true;
                    }
                }
                file_information[i] = compare[0] + " : " + compare[1];
                i++;
            }
            scan.close();
            file.delete();
            compare = file_information[0].split(" : ");
            File new_file = new File("file" + compare[1] + ".txt");
            new_file.createNewFile();
            FileWriter writer = new FileWriter("file" + compare[1] + ".txt");
            for(int j = 0; j < 7; j++) writer.write(file_information[j] + "\n");
            writer.close();
        }
        catch(Exception e){
            System.out.println("Incorrect Input!");
        }
    }
}
class CodeExit{
    public void out(){
        System.out.println("*******************************************");
        System.out.println("Thank You for Sharing your details :)      ");
        System.out.println("*******************************************");
        System.exit(0);
    }
}