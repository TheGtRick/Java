import java.util.*;
public class Birbale{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a = 0;
        int b = 1;
        int c = 0;
        System.out.println(a);
        for(int i = b; i < n; i++){
            c = a + b;
            a = b;
            b = c;
            System.out.println(a);
        }
    }
}