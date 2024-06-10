import java.util.ArrayList;

public class ArraySum{
    public static void main(String[] args){
        ArrayList<Number> array = new ArrayList<Number>();
        array.add(1);
        array.add(2l);
        array.add(3.0);
        array.add(4.56F);
        GenericMethod a = new GenericMethod();
        System.out.println(a.sum(array));
    }
}
class GenericMethod{
    public double sum(ArrayList<Number> a){
        double b = 0;
        for(int i = 0; i < a.size(); i++) b += a.get(i).doubleValue();
        return b;
    }
}