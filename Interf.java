
public class Interf{
    public static void main(String[] args){
        MovablePoint a = new MovablePoint(0, 0, 3, 3);
        MovableCircle b = new MovableCircle(1, 1, 4, 4, 5);
        System.out.println(a);
        System.out.println(b);
        a.moveUp();
        b.moveRight();
        System.out.println(a);
        System.out.println(b);
    }
}

public interface Movable{
    public abstract void moveUp();
    public abstract void moveDown();
    public abstract void moveLeft();
    public abstract void moveRight();
}

class MovablePoint implements Movable{
    int x;
    int y;
    int xSpeed;
    int ySpeed;
    public MovablePoint(int x, int y, int xSpeed, int ySpeed){
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    @Override
    public String toString(){
        return "(" + String.valueOf(x) + ", " + String.valueOf(y) + "), speed = (" + String.valueOf(xSpeed) + ", " + String.valueOf(ySpeed) + ")";
    }
    @Override
    public void moveUp(){
        this.y += ySpeed;
    }
    @Override
    public void moveDown(){
        this.y -= ySpeed;
    }
    @Override
    public void moveLeft(){
        this.x -= xSpeed;
    }
    @Override
    public void moveRight(){
        this.x += xSpeed;
    }
}

class MovableCircle implements Movable{
    private int radius;
    private MovablePoint center;
    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius){
        this.radius = radius;
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
    }
    @Override
    public String toString(){
        return center + ", radius = " + String.valueOf(radius);
    }
    @Override
    public void moveUp(){
        center.y += center.ySpeed;
    }
    @Override
    public void moveDown(){
        center.y -= center.ySpeed;
    }
    @Override
    public void moveLeft(){
        center.x -= center.ySpeed;
    }
    @Override
    public void moveRight(){
        center.x += center.ySpeed;
    }
}