import java.util.Scanner;

public class Absolutes{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int[][] c = new int[a][b];
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                c[i][j] = scan.nextInt();
            }
        }
        int d = b - 1;
        int e = 0;
        int lr = 0;
        int rl = 0;
        for(int i = 0; i < a; i++){
            lr += c[i][e];
            rl += c[i][d];
            d--;
            e++;
        }
        System.out.println(Math.abs(lr - rl));
    }
}