public class Exercise17{
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(6);
        tree.insert(1);
        tree.insert(8);
        tree.insert(7);
        tree.insert(9);
        System.out.println(tree.check());
        System.out.println(tree.inOrder());
        System.out.println(tree.preOrder());
        System.out.println(tree.postOrder());
    }
}
class BinarySearchTree{
    class Node{
        int key;
        Node left;
        Node right;
        Node(int key){
            this.key = key;
        }
    }
    Node root;
    public void insert(int key){
        root = insertRes(root, key);
    }
    private Node insertRes(Node root, int key){
        if(root == null){
            root = new Node(key);
            return root;
        }
        else{
            if(key > root.key) root.right = insertRes(root.right, key);
            else root.left = insertRes(root.left, key);
            return root;
        }
    }
    public boolean check(){
        return checkRes(root);
    }
    private boolean checkRes(Node root){
        if(root == null) return true;
        else if(root.left == null && root.right == null) return true;
        else if(root.left == null) return root.key <= root.right.key && checkRes(root.right);
        else if(root.right == null) return root.key >= root.left.key && checkRes(root.left);
        else return checkRes(root.left) && checkRes(root.right) && (root.key >= root.left.key && root.key <= root.right.key);
    }
    public String inOrder(){
        if(root == null) return "";
        else return inOrderRes(root.left) + String.valueOf(root.key) + inOrderRes(root.right);
    }
    public String inOrderRes(Node root){
        if(root == null) return "";
        else return inOrderRes(root.left) + String.valueOf(root.key) + inOrderRes(root.right);
    }
    public String preOrder(){
        if(root == null) return "";
        else return  String.valueOf(root.key) + preOrderRes(root.left) + preOrderRes(root.right);
    }
    public String preOrderRes(Node root){
        if(root == null) return "";
        else return  String.valueOf(root.key) + preOrderRes(root.left) + preOrderRes(root.right);
    }
    public String postOrder(){
        if(root == null) return "";
        else return preOrderRes(root.left) + preOrderRes(root.right) + String.valueOf(root.key);
    }
    public String postOrderRes(Node root){
        if(root == null) return "";
        else return preOrderRes(root.left) + preOrderRes(root.right) + String.valueOf(root.key);
    }
}