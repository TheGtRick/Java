import java.math.*;

class Circle{
    private double radius;
    public Circle(double radius){
        this.radius = radius;
    }
    public Circle(){
        this.radius = 1;
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }
    public double getCircumference(){
        return Math.PI * radius * 2;
    }
    public String toString(){
        return "Circle[radius=" + String.valueOf(radius) + "]";
    }
}

public class Shapes{
    public static void main(String[] args){
        Circle circle = new Circle();
        System.out.println(circle.getRadius());
        circle.setRadius(2);
        System.out.println(circle.getRadius());
        System.out.println(circle.getArea());
        System.out.println(circle.getCircumference());
        System.out.println(circle);
    }
}
