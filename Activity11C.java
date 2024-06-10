import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class PhoneBook {
    private final Map<String, Collection<PhoneNumber>> nameToPhoneNumbersMap = new HashMap<>();
    public void addNewPhoneNumbers(String name, Collection<PhoneNumber> numbers) {
        List a = new ArrayList<>();
        if(nameToPhoneNumbersMap.containsKey(name)){
            Collection b = nameToPhoneNumbersMap.get(name);
            Iterator it2 = b.iterator();
            while(it2.hasNext()) a.add(it2.next());
        }
        Iterator it = numbers.iterator();
        while(it.hasNext()) a.add(it.next());
        nameToPhoneNumbersMap.put(name, a);
    }
    public void printPhoneBook() {
        Object[] a = nameToPhoneNumbersMap.keySet().toArray();
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i].toString());
            Object[] b = nameToPhoneNumbersMap.get(a[i].toString()).toArray();
            for(int j = 0; j < b.length; j++) System.out.println(b[j]); 
        }
        
    }
}
enum PhoneNumberType {
    MOBILE, HOME, WORK,
}
class PhoneNumber {
    private PhoneNumberType type;
    private String number;
    public PhoneNumber(PhoneNumberType type, String number) {
    this.type = type;
    this.number = number;
    }
    public PhoneNumberType getType() {
    return type;
    }
    public String getNumber() {
    return number;
    }
    public String toString(){
        return type + ": " + number;
    }
}
public class Activity11C{
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        List<PhoneNumber> claraPhoneNumbers = new ArrayList<>();
        claraPhoneNumbers.add(new PhoneNumber(PhoneNumberType.HOME, "723324324"));
        phoneBook.addNewPhoneNumbers("Clara", claraPhoneNumbers);
        List<PhoneNumber> kevinPhoneNumbers = new ArrayList<>();
        kevinPhoneNumbers.add(new PhoneNumber(PhoneNumberType.WORK, "1231"));
        phoneBook.addNewPhoneNumbers("Kevin", kevinPhoneNumbers);
        List<PhoneNumber> newNumber1 = new ArrayList<>();
        newNumber1.add(new PhoneNumber(PhoneNumberType.MOBILE, "23424279"));
        phoneBook.addNewPhoneNumbers("Clara", newNumber1);
        List<PhoneNumber> newNumber2 = new ArrayList<>();
        newNumber2.add(new PhoneNumber(PhoneNumberType.WORK, "56756335"));
        phoneBook.addNewPhoneNumbers("Paul", newNumber2);
        phoneBook.printPhoneBook();
        
    }
}