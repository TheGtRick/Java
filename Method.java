import java.util.*;
import java.io.*;
class Method{
    public static int rakon(int c){
        if(c == 1 || c == 2) return 1;
        else return rakon(c - 2) + rakon(c - 1);
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        System.out.println(rakon(a));
        s.close();
    }
}