import java.util.*;

public class Exercise1{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int temp = 0;
        int[] array = new int[len];
        for(int k = 0; k < len; k++){
            array[k] = scan.nextInt();
        }
        for(int i = 0; i < len - 1; i++){
            for(int  j = i + 1; j < len; j++){
                if(array[j] < array[i]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        for(int m = 0; m < len; m++){
            System.out.print(array[m] + " ");
        }
    }
}