public interface PersonInterface{
    public abstract void SetName(String Name);
    public abstract void SetAge(int Myage);
}
public interface SportInterface{
    public abstract String getMyFavoriteSport();
    public abstract void setMyFavourtieSport(String sportName);
    public abstract int howMuchItCostToPlayThisSport();
}
public interface HobbyInterface{
    public abstract String whatsMyHobby();
    public abstract void setMyHobby();
}
class SportAndHobbyImpl implements PersonInterface, SportInterface, HobbyInterface{
    private String name;
    private int Myage;
    private String sportName;
    private String hobby;
    SportAndHobbyImpl(){
        this.name = "Raiymbek";
        this.Myage = 17;
        this.sportName = "workout";
        this.hobby = "sculpting";
    }
    SportAndHobbyImpl(String name, int Myage, String sportName, String hobby){
        this.name = name;
        this.Myage = Myage;
        this.sportName = sportName;
        this.hobby = hobby;
    }
    public int howMuchItCostToPlayThisSport(){
        return Myage * 10;
    }
    public String getMyFavoriteSport(){
        return sportName;
    }
    public void setMyFavourtieSport(String sportName){
        this.sportName = sportName;
    }
    public String whatsMyHobby(){
        return hobby;

    }
    public void setMyHobby(String hobby){
        this.hobby = hobby;
    }
    @Override
    public String toString(){
        return "Name = " + name + ", age = " + String.valueOf(Myage) + ", sport = " + sportName + ", hobby = " + hobby;
    }
}
public class Practice2{
    public static void main(String[] args){
        SportAndHobbyImpl a = new SportAndHobbyImpl();
        System.out.println(a);
    }
}