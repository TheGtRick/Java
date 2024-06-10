    import java.util.Scanner;
    public class STree{
        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            int m = scan.nextInt();
            int[] rooms = new int[n];
            int[] groups = new int[m];
            for(int i = 0; i < n; i++){
                rooms[i] = scan.nextInt();
            }
            for(int i = 0; i < m; i++){
                groups[i] = scan.nextInt();
            }
            SegmentTree st = new SegmentTree(rooms);
            for(int i = 0; i < m; i++){
                System.out.print(st.place(groups[i]) + " ");
            }
        }
    }
    class SegmentTree{
        Node root;
        class Node{
            int low, high, room;
            Node left, right;
            Node(int low, int high, int room){
                this.low = low;
                this.high = high;
                this.room = room;
                this.left = null;
                this.right = null;
            }
        }
        SegmentTree(int[] arr){
            root = buildST(arr, 0, arr.length - 1);
        }
        public Node buildST(int[] arr, int low, int high){
            if(low == high) return new Node(low, high, arr[low]);
            int mid = (low + high) / 2;
            Node left = buildST(arr, low, mid);
            Node right = buildST(arr, mid + 1, high);
            Node parent = new Node(low, high, left.room + right.room);
            parent.left = left;
            parent.right = right;
            return parent;
        }
        public void update(int index, int value){
            update(root, index, value);
        }
        public void update(Node root, int index, int value){
            if(root == null || index < root.low || index > root.high) return;
            if(root.low == root.high && index == root.low) root.room -= value;
            int mid = root.low + (root.high - root.low) / 2;
            if(index <= mid) update(root.left, index, value);
            else update(root.right, index, value);
            if(root.left != null || root.right != null) 
            root.room = (root.left != null ? root.left.room : 0) + (root.right != null ? root.right.room : 0);
        }
        public int place(int group){
            int index = search(root, group);
            if(index == -1) return 0;
            update(index, group);
            return index + 1;
        }
        public int search(Node root, int group){
            int index = -1;
            if (root == null || root.room < group) return -1;
            if(root.low == root.high && root.room >= group) return root.low;
            if(group <= root.left.room) index = search(root.left, group);
            if(group <= root.right.room && index == -1) index = search(root.right, group);
            return index;
        }
    }