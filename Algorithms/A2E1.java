import java.util.ArrayList;
import java.util.Scanner;

public class A2E1{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int con = scanner.nextInt();
        int[] computers = new int[n];
        for(int i = 0; i < n; i++){
            computers[i] = i;
        }
        Connect network = new Connect(computers);
        for(int i = 0; i < con; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            network.connect(a, b);
        }
        System.out.println("Changes needed: " + network.changes());
    }
   
}
class Connect{
    int possibles = 0;
    int nets = 0;
    int[] computers;
    int[] id;
    ArrayList<Integer> f = new ArrayList<Integer>();
    public Connect(int[] computers){
        this.computers = computers;
        this.id = computers;
    }
    public boolean connected(int a, int b){
        return id[a] == id[b];
    }
    public void connect(int a, int b){
        if(connected(a, b)){
            possibles++;
        }
        else{
            int g = id[a];
            for(int i = 0; i < computers.length; i++){
                if(id[i] == g) id[i] = b;
            }
        }
    }
    public void check(){
        for(int i = 0; i < id.length; i++){
            if(!f.contains(id[i])){
                nets++;
                f.add(id[i]);
            }
        }
    }
    public int changes(){
        check();
        if(nets == 1) return 0;
        else if(possibles < nets - 1) return -1;
        else return nets - 1;
    }
}