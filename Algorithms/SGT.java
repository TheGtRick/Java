public class SGT{
    public static void main(String[] args){
        int[] arr = new int[]{23, 12, 63, 30, 0, -4, -78, 45, 3, 10};
        SegmentTree sgt = new SegmentTree(arr);
        System.out.println(sgt.sum(0, 3));
        System.out.println(sgt.min(3, 6));
        System.out.println(sgt.max(6, 9));
        sgt.update(0, 9);
        System.out.println(sgt.sum(0, 3));
    }
}
class SegmentTree{
    private Node root;
    class Node{
        Node left, right;
        int low, high;
        int sum, min, max;
        private Node(int low, int high, int sum, int min, int max){
            this.sum = sum;
            this.min = min;
            this.max = max;
            this.low = low;
            this.high = high;
        }
    }
    public SegmentTree(int[] arr){
        root = buildST(arr, 0, arr.length - 1);
    }
    public Node buildST(int[] arr, int low, int high){
        if(low == high) return new Node(low, high, arr[low], arr[low], arr[low]);
        int mid = (low + high) / 2;
        Node left = buildST(arr, low, mid);
        Node right = buildST(arr, mid + 1, high);
        Node parent = new Node(low, high, left.sum + right.sum, left.min <= right.min ? left.min : right.min, left.max >= right.max ? left.max : right.max);
        parent.left = left;
        parent.right = right;
        return  parent;
    }
    public int sum(int low, int high){
        return sum(root, low, high);
    }
    public int sum(Node root, int low, int high){
        if(root == null || low > root.high || high < root.low) return 0;
        if(low <= root.high && high >= root.high) return root.sum;
        int mid = root.low + (root.high - root.low) / 2;
        return sum(root.left, low, Math.min(mid, high)) + sum(root.right, Math.max(low, mid + 1), high);
    }
    public int min(int low, int high){
        return min(root, low, high);
    }
    public int min(Node root, int low, int high){
        if(root == null || low > root.high || high < root.low) return 0;
        if(low <= root.low && high >= root.high) return root.min;
        int mid = root.low + (root.high - root.low) / 2;
        return Math.min(min(root.left, low, Math.min(mid, high)), min(root.right, Math.max(low, mid + 1), high));
    }
    public int max(int low, int high){
        return max(root, low, high);
    }
    public int max(Node root, int low, int high){
        if(root == null || low > root.high || high < root.low) return 0;
        if(low <= root.low && high >= root.high) return root.max;
        int mid = root.low + (root.high - root.low) / 2;
        return Math.max(max(root.left, low, Math.min(mid, high)), max(root.right, Math.max(low, mid + 1), high));
    }
    public void update(int index, int value){
        update(root, index, value);
    }
    public void update(Node root, int index, int value){
        if(root == null || index < root.low || index > root.high) return;
        if(root.low == index && root.low == root.high){
            root.sum = value;
            root.min = value;
            root.max = value;
            return;
        }
        int mid = root.low + (root.high - root.low) / 2;
        if(index <= mid) update(root.left, index, value);
        else update(root.right, mid, value);
        root.sum = root.left.sum + root.right.sum;
        root.min = root.left.min <= root.right.min ? root.left.min : root.right.min;
        root.max = root.left.max >= root.right.max ? root.left.max : root.right.max; 
    }
}