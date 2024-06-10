import java.util.Stack;

public class Hanoi {
    public static void main(String[] args){
        Stack<Integer> a = new Stack<Integer>();
        a.push(3);
        a.push(2);
        a.push(1);
        Stack<Integer> b = new Stack<Integer>();
        Stack<Integer> c = new Stack<Integer>();
        int stop = (int)(Math.pow(2, a.size()) - 1);
        int start = 0;
        solve(a, b, c, start, stop);
        System.out.println(c);
    }
    public static void solve(Stack<Integer> a, Stack<Integer> b, Stack<Integer> c, int start, int stop){
        if(start == stop) return;
        move(a, b, c, start, stop, a, c);
    }
    public static void move(Stack<Integer> a, Stack<Integer> b, Stack<Integer> c, int start, int stop, Stack<Integer> x, Stack<Integer> y){
        if(start == stop) return;

    }
}
