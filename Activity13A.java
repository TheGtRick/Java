import java.io.IOException;
import java.util.Scanner;
public class Activity13A{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);        
        System.out.println("Press the Enter to Stop...");
        TrafficLight tfl = new TrafficLight();
        Thread thread = new Thread(tfl);
        thread.start();        
        if(scan.nextLine().isEmpty()){
        tfl.stop();
        }
    }
}
    class TrafficLight implements Runnable {
        private String colors [] = {"green","yellow","red"};
        private boolean stop = false;
        int i = 0;
        @Override
        public void run() {
            while(!stop){
                if(i == 0){
                    System.out.println(colors[0]);
                    sleep(10000);
                }
                else if(i == 1){
                    System.out.println(colors[1]);
                    sleep(2000);
                } 
                else{
                    System.out.println(colors[2]);
                    sleep(5000);
                } 
                i++;
                i = i % 3;            
            }
        }
    public void sleep(int time){
        try{
            Thread.sleep(time);        
        }
        catch(InterruptedException e){
            System.out.println("Error!");        
        }
    }
    public void stop(){
            stop = true;    
        }
}
