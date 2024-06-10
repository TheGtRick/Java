import java.util.Scanner;

public class Exercise3 {
    public static int fact(int a){
        if(a != 1 && a != 0) return a * fact(a - 1);
        else{
            if(a == 0) return 1;
            else return a;
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = 1;
        if(a == 0){
            System.out.println(1);
        }
        else{
            for(int i = 2; i <= a; i++){
                b *= i;
            }
            System.out.println(b); 
        }
        System.out.println(fact(a));
    }
}
