import java.util.*;
import java.io.*;

public class Objects{
   public static void main(String[] args){
        Employee em = new Employee(17, "Raiymbek", "Zhanuzak", 0);
        Employee du = new Employee(40, "Qotaq", "Tasaq", 69);
        System.out.println(em);
        System.out.println(em.name());
        System.out.println(em.age());
        System.out.println(du);
        System.out.println(du.name());
        System.out.println(du.age());
   }
}
class Employee{
    int a = 0;
    String b = "";
    String c = "";
    int d = 0;
    Employee(int a, String b, String c, int d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    public String name(){
        return b + " " + c;
    }
    public int age(){
        return a + 10;
    }
    public String toString(){
        return c + " " + b + " " + a + " " + d;
    }
}