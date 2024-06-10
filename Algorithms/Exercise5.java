import java.util.ArrayList;

public class Exercise5{
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i <= 50; i++) list.add(i);
        int count = 0;
        for(int j = 0; j < list.size(); j++) if(list.get(j) % 2 == 1) count++;
        System.out.println(count);
    }
}