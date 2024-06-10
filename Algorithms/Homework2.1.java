import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        String[] rows = new String[m];
        for (int i = 0; i < n; i++) {
            rows[i] = scanner.nextLine();
        }
        System.out.println(solve(rows));
    }
    public static int distance(String row1, String row2) {
        int max = 0;
        for (int i = 0; i < row1.length(); i++) {
            int distance = Math.abs(row1.charAt(i) - row2.charAt(i));
            if (distance > max) {
                max = distance;
            }
        }
        return max;
    }
    public static int solve(String[] rows) {
        int n = rows.length;
        int[] costs = new int[n];
        costs[0] = 0;
        for (int i = 1; i < n; i++) {
            int max = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                int distance = distance(rows[i], rows[j]);
                if (distance < max) {
                    max = distance;
                }
            }
            costs[i] = max;
        }
        
        int maxCost = 0;
        for (int cost : costs) {
            if (cost > maxCost) {
                maxCost = cost;
            }
        }
        return maxCost;
    }
}
