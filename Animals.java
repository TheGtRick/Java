class Animal{
    private String name;
    public Animal(String name){
        this.name = name;
    }
    public String toString(){
        return "Animal[name=\""+ name +"\"]";
    }
}

class Mammal extends Animal{
    public Mammal(String name){
        super(name);
    }
    @Override
    public String toString(){
        return "Mammal[" + super.toString() + "]";
    }
}

class Cat extends Mammal{
    public Cat(String name){
        super(name);
    }
    @Override
    public String toString(){
        return "Cat[" + super.toString() + "]";
    }
    public void greets(){
        System.out.println("Meow");
    }
}

class Dog extends Mammal{
    public Dog(String name){
        super(name);
    }
    @Override
    public String toString(){
        return "Dog[" + super.toString() + "]";
    }
    public void greets(){
        System.out.println("Woof");
    }
    public void greets(Dog dog){
        System.out.println("Woooof");
    }
}

public class Animals{
    public static void main(String[] args){
        Dog dog = new Dog("Dog");
        Cat cat = new Cat("Cat");
        System.out.println(dog);
        System.out.println(cat);
        cat.greets();
        dog.greets();
        dog.greets(dog);
    }
}