import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args){
        int[] a = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50};
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose a number between 0 and 50");
        int b = scan.nextInt();
        for(int i = 0; i < a.length; i++) if(a[i] == b) System.out.println(i);
    }
}
