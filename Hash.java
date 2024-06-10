import java.util.LinkedHashSet;
import java.util.Iterator;

public class Hash{
    public static void main(String[] args){
        LinkedHashSet set1 = new LinkedHashSet();
        set1.add("George");
        set1.add("Jim");
        set1.add("Jonh");
        set1.add("Blake");
        set1.add("Kevin");
        set1.add("Michael");
        LinkedHashSet set2 = new LinkedHashSet();
        set2.add("George");
        set2.add("Katie");
        set2.add("Michelle");
        set2.add("Ryan");
        set2.add("Kevin");
        LinkedHashset cop1 = new LinkedHashSet(set1);
        LinkedHashSet cop2 = new LinkedHashSet(set2);
        LinkedHashSet cop11 = new LinkedHashSet(cop1);
        set1.removeAll(set2);
        LinkedHashSet dif1 = new LinkedHashSet(set1);
        set2.removeAll(set1);
        LinkedHashSet dif2 = new LinkedHashSet(set2);
        dif1.addAll(dif2);
        LinkedHashSet dif = new LinkedHashSet(dif1);
        cop1.removeAll(dif1);
        LinkedHashSet ins = new LinkedHashSet(cop1);
        cop11.addAll(cop2);
        LinkedHashSet uni = new LinkedHashSet(cop11);
        System.out.println("Union: " + uni);
        System.out.println("Differrence: " + dif);
        System.out.println("Intersection: " + ins);
    }
}