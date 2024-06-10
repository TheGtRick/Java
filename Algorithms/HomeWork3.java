import java.util.Scanner;

public class HomeWork3 {
    public static void main(String[] args){
        String[] colors = new String[]{"red", "green", "yellow"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of occurance in one loop: ");
        int rk = scanner.nextInt();
        int[] ex = new int[colors.length];
        for(int i = 0; i < ex.length; i++){
            System.out.println("Enter the number of execution for " + colors[i] + ":");
            ex[i] = scanner.nextInt();
        }
        int[] extime = new int[colors.length];
        for(int i = 0; i < extime.length; i++){
            System.out.println("Enter the number of execution time for " + colors[i] + ":");
            extime[i] = scanner.nextInt();
        }
        int[] wtime = new int[colors.length];
        int[] exd = new int[colors.length];
        for(int i = 0; i < wtime.length; i++){
            wtime[i] = 0;
            exd[i] = 0;
        }
        while(true){
            int que = 0;
            int a = 0;
            for(int i = 0; i < wtime.length; i++){
                if(wtime[i] > a){
                    a = wtime[i];
                    que = i;
                }
            }
            for(int i = 0; i < colors.length; i++){
                if(i == que){
                    for(int j = 0; j < rk && exd[i] <= ex[i]; j++){
                        System.out.println(colors[j]);
                        exd[i] += 1;
                        for(int k = 0; k < wtime.length; k++){
                            if(k != i) wtime[k]++;
                        
                        }
                    }
                    wtime[i] = 0;
                }
            }
            int c = 0;
            for(int i = 0; i < exd.length; i++) if(exd[i] == extime[i]) c++;
            if(c == colors.length) break;
        }
    }
}
