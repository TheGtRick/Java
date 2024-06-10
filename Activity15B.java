public class Activity15B{
    public static void main(String[] args) {
        Animal[] animals = {new Lion("Simba", 10, 150), new Tiger("Rajah", 8, 200), new Bear("Baloo", 5, 300), new Monkey("Abu", 2, 10)};
        for(int i = 0; i < animals.length; i++) animals[i].feedAnimal();
    }
}
class Animal{
    public String name;
    public int age;
    public int weight;
    public Animal(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    public void feedAnimal() {
        System.out.println(this.name + " ate " + this.weight + " grams of food.");
    } 
}
class Lion extends Animal{
    public Lion(String name, int age, int weight) {
        super(name, age, weight);
    }
    public void feedAnimal() {
        double amount = super.weight/7.0;
        System.out.println(super.name + " the Lion ate " + String.format("%.2f", amount) + " grams of food.");
    }
}
class Tiger extends Animal{
    public Tiger(String name, int age, int weight) {
        super(name, age, weight);
    }
    public void feedAnimal() {
        double amount = super.weight/5.0;
        System.out.println(super.name + " the Tiger ate " + String.format("%.2f", amount) + " grams of food.");
    }
}
class Bear extends Animal{
    public Bear(String name, int age, int weight) {
        super(name, age, weight);
    }
    public void feedAnimal() {
        double amount = super.weight/10.0;
        System.out.println(super.name + " the Bear ate " + String.format("%.2f", amount) + " grams of food.");
    }
}
class Monkey extends Animal{
    public Monkey(String name, int age, int weight) {
        super(name, age, weight);
    }
    public void feedAnimal() {
        double amount = super.weight/15.0;
        System.out.println(super.name + " the Monkey ate " + String.format("%.2f", amount) + " grams of food.");
    }
}