public class Exercise11{
    public static void main(String[] args){
        Node[] arr = new Node[5];
        arr[0] = new Node("A", 56);
        arr[1] = new Node("B", 83);
        arr[2] = new Node("C", 67);
        arr[3] = new Node("D", 34);
        arr[4] = new Node("E", 75);
        insertion(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i].toString());
        }
    }
    public static void insertion(Node[] arr){
        for(int i = 1; i < arr.length; i++){
            Node key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j].grade > key.grade){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
} 
class Node{
    String name;
    int grade;
    Node(String name, int grade){
        this.name = name;
        this.grade = grade;
    }
    @Override
    public String toString(){
        return name + ": " + String.valueOf(grade);
    }
}