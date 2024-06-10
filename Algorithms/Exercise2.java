import java.util.ArrayList;
import java.util.Arrays;
public class Exercise2 {
    public static void main(String[] args){
        int solution = 0;
        ArrayList<int[]> answer = new ArrayList<int[]>();
        int[] array = {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for(int i = 0; i < array.length; i++){
            for(int j = i + 1; j < array.length; j++){
                for(int k = j + 1; k < array.length; k++){
                    if(array[i] + array[j] + array[k] == 0){
                        int[] v = {array[i], array[j], array[k]};
                        Arrays.sort(v);
                        if(!answer.contains(v)){
                            System.out.println("["+String.valueOf(v[0])+", "+String.valueOf(v[1])+", "+String.valueOf(v[2])+"]");
                            solution++;
                            answer.add(v);
                        }
                    }
                }
            }
        }
        System.out.println("They are " + String.valueOf(solution) + " solutions");
    }
}