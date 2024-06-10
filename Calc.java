class Calculator{
    private int a;
    private int b;
    Calculator(int a, int b) throws Exception{
        this.a = a;
        this.b = b;
    }
    public int Add() throws Exception{
        if(a >= 0 && b >= 0) return a + b;
        else throw new ArithmeticException("Numbers must be positive!");
    }
    public int Subtract() throws Exception{
        if(a >= 0 && b >= 0) return a - b;
        else throw new ArithmeticException("Numbers must be positive!");
    }
    public int Multiplication() throws Exception{
        if(a != 0 && b != 0) return a * b;
        else throw new ArithmeticException("Numbers must not be zero!");
    }
    public double Division() throws Exception{
        if(a != 0 && b != 0) return a / Double.valueOf(b);
        else throw new ArithmeticException("Numbers must not be zero!");
    }
}

public class Calc{
    public static void main(String[] args){
        try{
            Calculator a = new Calculator(1, Integer.parseInt("4000"));
            Calculator b = new Calculator(1, 2);
            Calculator c = new Calculator(1, 3);
            Calculator d = new Calculator(1, 10);
            int result1 = a.Add();
            int result2 = b.Subtract();
            int result3 = c.Multiplication();
            double result4 = d.Division();
            System.out.println(result1);
            System.out.println(result2);
            System.out.println(result3);
            System.out.println(result4);
        }
        catch(NumberFormatException ex){
            System.out.println(ex.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}