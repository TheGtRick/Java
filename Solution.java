import java.util.*;
class Solution {    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));    }
    public static boolean isPowerOfFour(int n) {
        double a = Math.log(n)/Math.log(4);
        int s = (int)a;
        return n%(int)Math.pow(4, s) == 0;    }
}
