import java.util.Scanner;

public class QueInterval{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i ++){
            arr[i] = scan.nextInt();
        }
        SegmentTree st = new SegmentTree(arr);
        System.out.println("Write interval: ");
        int low = scan.nextInt();
        int high = scan.nextInt();
        System.out.println("Sum of elements between " + low + " and " + high + " is " + st.sum(low, high));
        System.out.println("Minimum of elements between " + low + " and " + high + " is " + st.min(low, high));
        System.out.println("Maximum of elements between " + low + " and " + high + " is " + st.max(low, high));
    }
}
class SegmentTree{
    Node root;
    class Node{
        int low, high, sum, min, max;
        Node left, right;
        Node(int sum, int low, int high, int min, int max){
            this.sum = sum;
            this.low = low;
            this.high = high;
            this.min = min;
            this.max = max;
        }
    }
    SegmentTree(int[] arr){
        root = buildST(arr, 0, arr.length - 1);
    }
    public Node buildST(int[] arr, int low, int high){
        if(low == high) return new Node(arr[low], low, high, arr[low], arr[low]);
        int mid = (low + high) / 2;
        Node left = buildST(arr, low, mid);
        Node right = buildST(arr, mid + 1, high);
        Node parent = new Node(left.sum + right.sum, low, high, Math.min(left.min, right.min), Math.max(left.max, right.max));
        parent.left = left;
        parent.right = right;
        return parent;
    }
    public int sum(int queryLow, int queryHigh){
        return sum(root, queryLow, queryHigh);
    }
    public int sum(Node root, int queryLow, int queryHigh){
        if(root == null || queryLow > root.high || queryHigh < root.low){
            return 0;
        }
        if(queryLow <= root.low && queryHigh >= root.high){
            return root.sum;
        }
        int mid = root.low + (root.high - root.low) / 2;
        return sum(root.left, queryLow, Math.min(queryHigh, mid)) + sum(root.right, Math.max(queryLow, mid + 1), queryHigh);
    }
    public int min(int queryLow, int queryHigh){
        return min(root, queryLow, queryHigh);
    }
    public int min(Node root, int queryLow, int queryHigh){
        if(root == null || queryLow > root.high || queryHigh < root.low){
            return 20000;
        }
        if(queryLow <= root.low && queryHigh >= root.high) return root.min;
        int mid = root.low + (root.high - root.low) / 2;
        int leftmin = min(root.left, queryLow, Math.min(queryHigh, mid));
        int rightmin = min(root.right, Math.max(mid + 1, queryLow), queryHigh);
        return leftmin <= rightmin ? leftmin : rightmin;
    }
    public int max(int queryLow, int queryHigh){
        return max(root, queryLow, queryHigh);
    }
    public int max(Node root, int queryLow, int queryHigh){
        if(root == null || queryLow > root.high || queryHigh < root.low){
            return 0;
        }
        if(queryLow <= root.low && queryHigh >= root.high) return root.max;
        int mid = root.low + (root.high - root.low) / 2;
        int leftmin = max(root.left, queryLow, Math.min(queryHigh, mid));
        int rightmin = max(root.right, Math.max(mid + 1, queryLow), queryHigh);
        return leftmin >= rightmin ? leftmin : rightmin;
    }
}