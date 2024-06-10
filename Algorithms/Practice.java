public class Practice{
    public static void main(String[] args){
        RedBlackBST rb = new RedBlackBST();
        rb.insert(9, 12);
        rb.insert(9, 33);
        rb.insert(1, 77);
        rb.insert(2, 20);
        rb.insert(8, 80);
        rb.insert(4, 10);
        rb.insert(6, 10);
        rb.insert(4, 30);
        System.out.println(rb.inOrder());
        System.out.println(rb.root().key);
    }
}
class RedBlackBST{
    private final boolean RED = true;
    private final boolean BLACK = false;
    Node root;
    class Node{
        Node left;
        Node right;
        int key;
        int value;
        boolean color = RED;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    public void insert(int key, int value){
        Node node = new Node(key, value);
        if(root == null){
            root = node;
        }
        if(key < root.key)root.left = insertRec(root.left, key, value);
        else if(key > root.key)root.right = insertRec(root.right, key, value);
        else root.value = value;
        if(root.right != null && root.right.color == RED && (root.left == null || root.left.color == BLACK)){
            root = leftRotate(root);
        }
        if(root.left != null && root.left.left != null && root.left.color == RED && root.left.left.color == RED){
            root = rightRotate(root);
        }
        if(root.left != null && root.right != null && root.left.color == RED && root.right.color == RED){
            flipColor(root);
        }
        root.color = BLACK;
    }
    private Node insertRec(Node root, int key, int value){
        Node node = new Node(key, value);
        if(root == null){
            root = node;
            return root;
        }
        if(key < root.key)root.left = insertRec(root.left, key, value);
        else if(key > root.key)root.right = insertRec(root.right, key, value);
        else root.value = value;
        if(root.right != null && root.right.color == RED && (root.left == null || root.left.color == BLACK)){
            root = leftRotate(root);
        }
        if(root.left != null && root.left.left != null && root.left.color == RED && root.left.left.color == RED){
            root = rightRotate(root);
        }
        if(root.left != null && root.right != null && root.left.color == RED && root.right.color == RED){
            flipColor(root);
        }
        return root;
    }
    public String inOrder(){
        if(root == null) return "";
        return inOrderRec(root);
    }
    private String inOrderRec(Node root){
        if(root == null) return "";
        return inOrderRec(root.left) + String.valueOf(root.key) + ":" + String.valueOf(root.color) + inOrderRec(root.right);
    }
    private void flipColor(Node root){
        root.color = RED;
        root.left.color = BLACK;
        root.right.color = BLACK;
    }
    private Node leftRotate(Node root){
        Node x = root.right;
        root.right = x.left;
        x.left = root;
        x.color = root.color;
        root.color = RED;
        return x;
    }
    private Node rightRotate(Node root){
        Node x = root.left;
	    root.left = x.right;
	    x.right = root;
	    x.color = root.color;
	    root.color = RED;
	    return x;

    }
    public Node root(){
        return root;
    }
}