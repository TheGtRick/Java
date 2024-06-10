import java.util.HashMap;
import java.util.Scanner;

public class Character{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        a=a.replaceAll(" ", "");
        countCharacters(a);
        s.close();
    }
    public static void countCharacters(String a){
        int d = a.length();
        char[] b = a.toCharArray();
        HashMap m = new HashMap();
        int j = 0;
        System.out.print("char[] {'" + b[0] + "',");
        for(int v = 1; v < d - 1; v++) System.out.print("'" + b[v] + "',");
        System.out.print("'" + b[d - 1] + "''}");
        System.out.println();
        for(int i = 0; i < b.length; i++){
            m.put(i, b[i]);
        }
        for(int k = 0; k < d; k++){
            Object c = m.get(k);
            for(int l = 0; l < d; l++){
                if(c == m.get(l)){
                    j++;
                    m.remove(l);
                }
            }
            if(c != null){
                System.out.println(c + ":" + j);
                j = 0;
            }
        }
    }
}
