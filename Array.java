import java.util.*;
class Array{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int[][] c = new int[a][b];
        for(int i = 0; i < a; i++)
            for(int j = 0; j < b; j++)
                c[i][j] = s.nextInt();
                

    
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++)
                System.out.print(c[j][i] + " ");
            System.out.println();
        }
        s.close();
    }
}