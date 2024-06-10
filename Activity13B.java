import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class Activity13B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        scanner.close();
        SumCalculator calculator = new SumCalculator(number);
        calculator.calculateSum();
    }
}
class SumCalculator {
    private final int number;
    private int sum;
    public SumCalculator(int number) {
        this.number = number;
    }
    public void calculateSum() {
        if(number < 5){
            for(int i = 0; i < number; i++)sum += i;
        }
        else{
            int n = number/5;
            ExecutorService executor = Executors.newFixedThreadPool(5);
            ThreadPoolExecutor pool = (ThreadPoolExecutor) executor;
            executor.submit(new SumWorker(0, n));
            executor.submit(new SumWorker(n, n*2));
            executor.submit(new SumWorker(n*2, n*3));
            executor.submit(new SumWorker(n*3, n*4));
            executor.submit(new SumWorker(n*4, number));
            
            executor.shutdown();
        }
            System.out.println("The sum of all numbers from 1 to " + number + " is " + sum);
    }
    private class SumWorker implements Runnable {
        private final int start;
        private final int end;
        public SumWorker(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public void run() {
            for(int i = start; i < end; i++){
                sum += i;
            }
        }
    }
}