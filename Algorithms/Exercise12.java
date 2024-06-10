public class Exercise12 {
     public static void main(String[] args){
        Product[] arr = new Product[5];
        arr[0] = new Product("IPhone", 560000);
        arr[1] = new Product("McBook", 830000);
        arr[2] = new Product("Lenovo", 670000);
        arr[3] = new Product("Xiaomi 11T PRO", 340000);
        arr[4] = new Product("Samsung Galaxy 20", 750000);
        selection(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i].toString());
        }
    }
    public static void selection(Product[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int index = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j].price < arr[index].price){
                    index = j;
                }
            }
            Product temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
} 
class Product{
    String name;
    int price;
    Product(String name, int price){
        this.name = name;
        this.price = price;
    }
    @Override
    public String toString(){
        return name + ": " + String.valueOf(price);
    }
}