import java.math.*;

public class Practice{
    public static void main(String[] args){
        Square a = new Square(3);
    }
}

class Shape{
    private String color;
    private boolean filled;

    public Shape(){
        this.color = "red";
        this.filled = true;
    }
    public Shape(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public boolean isFilled(){
        return filled;
    }
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    @Override
    public String toString(){
        return "Shape[color = " + color + ", filled = " + String.valueOf(filled) + "]";
    }
}
class Circle extends Shape{
    private double radius;
    public Circle(){
        this.radius = 1.0;
    }
    public Circle(double radius){
        this.radius = radius;
    }
    public Circle(double radius, String color, boolean filled){
        super(color, filled);
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public double getArea(){
        return radius * radius * Math.PI;
    }
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }
    @Override
    public String toString(){
        return "Circle[" + super.toString() + ", radius = " + String.valueof(radius) + "]";
    }
}
class Rectangle extends Shape{
    private double width;
    private double length;
    Rectangle(){
        this.width = 1.0;
        this.length = 1.0;
    }
    Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }
    Rectangle(double width, double length, String color, boolean filled){
        super(color, filled);
    }
    public double getWidth(){
        return width;
    }
    public void setWidth(double width){
        this.width = width;
    }
    public double getLength(){
        return length;
    }
    public void setLength(double length){
        this.length = length;
    }
    public double getArea(){
        return width * length;
    }
    public double getPerimeter(){
        return 2 * (width + length);
    }
    @Override
    public String toString(){
        return "Rectangle[" + super.toString() + ", width = " + String.valueOf(width) + ", length = " + String.valueOf(length) + "]";
    }
}
class Square extends Rectangle{
    Square(){
        super();
    }
    Square(double side){
        super(side, side);
    }
    Square(double side, String color, boolean filled){
        super(side, side, color, filled);
    }
    public double getSide(){
        return super.getWidth();
    }
    public void setSide(double side){
        super.setWidth(side);
        super.setLength(side);
    }
    @Override
    public void setWidth(double side){
        super.setWidth(side);
    }
    @Override
    public void setLength(double side){
        super.setLength(side);
    }
    @Override
    public String toString(){
        return "Square" + super.toString();
    }
}