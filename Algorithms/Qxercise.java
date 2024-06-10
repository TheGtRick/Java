import java.util.*;
public class Qxercise{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i + 1;
        }
        int m = scan.nextInt();    //nigga
        Qefir qf = new Qefir(arr);
        for(int i = 0; i < m; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            qf.combine(a, b);
            qf.information();
        }
    }
}
class Qefir{
    ArrayList<Integer>[] arr;
    Qefir(int[] array){
        this.arr = new ArrayList[array.length];
        for(int i = 0; i < arr.length; i++){
            this.arr[i] = new ArrayList<Integer>();
            this.arr[i].add(array[i]);
        }
    }
    public void combine(int a, int b){
        if(!arr[a - 1].contains(b))
            arr[a - 1].add(b);
    }
    public void information(){
        int largest = 0;
        int roadl = 0;
        int components = arr.length;
        ArrayList<Integer> digits = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++){
            if(digits.contains(i + 1)) components --;
            for(int j = 0; j < arr[i].size(); j++){
                roadl++;
                if(!digits.contains(arr[i].get(j))){
                    digits.add(arr[i].get(j));
                }
            }
            if(largest < roadl) largest = roadl;
            roadl = 0;
        }
        System.out.println(components + " " + largest);
    }
}