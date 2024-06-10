public class Practice3{
    public static void main(String[] args){
        Fish d = new Fish();
        Cat c = new Cat("Fluffy");
        Animal a = new Fish();
        Animal e = new Spider();
        Pet p = new Cat();
        
    }
}
abstract class Animal{
    protected int legs;
    protected Animal(int legs){
        this.legs = legs;
    }
    public abstract void eat();
    public void walk(){
        for(int i = 0; i < legs; i++){
            System.out.print("top ");
        }
    }
}
class Spider extends Animal{
    Spider(){
        super(8);
    }
    public void eat(){
        System.out.println("psss, pssss");
    }
}
public interface Pet{
    public abstract String getName();
    public abstract void setName();
    public abstract void play();
}
class Cat extends Animal implements Pet{
    String name;
    Cat(String name){
        super(4);
        this.name = name;
    }
    Cat(){
        super(4);
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void play(){
        System.out.println("MEOOOOOOW");
    }
    public void eat(){
        System.out.println("Chomp-Chomp");
    }
}
class Fish extends Animal implements Pet{
    String name;
    Fish(){
        super(0);
        name = "Doesn't have name";
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void play(){
        System.out.println("bloop-bloop");
    }
    @Override
    public void walk(){
        System.out.println("It doesn't walk!");
    }
    public void eat(){
        System.out.println("Nom-Nom");
    }
}
