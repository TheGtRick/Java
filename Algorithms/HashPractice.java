import java.util.Scanner;

public class HashPractice {
    public static void main(String[] ags){
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();
        String a = scanner.nextLine();
        System.out.println(hash(pattern, pattern.length()));
        System.out.println(hash(a, a.length()));
    }
    private static int hash(String str, int length) {
        int hashValue = 0;
        for (int i = 0; i < length; i++) {
            hashValue += str.charAt(i) * Math.pow(101, i);
        }
        return hashValue;
    }
}
