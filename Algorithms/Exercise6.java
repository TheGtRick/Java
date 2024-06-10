import java.util.ArrayList;
import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i <= 50; i++) list.add(i);
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        for(int j = 0; j < list.size(); j++) if(j == a) list.remove(j);
        for(int k = 0; k < list.size(); k++) System.out.println(list.get(k));
    }
}
