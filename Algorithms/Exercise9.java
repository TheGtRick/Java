import java.util.Arrays;
import java.util.Scanner;
public class Exercise9 {
    public static void main(String[] args){
        Stack stack = new Stack();
        Scanner scanner = new Scanner(System.in);
        String expr[] = scanner.nextLine().split("");
        System.out.println("Postfix: " + stack.postfix(expr));
        System.out.println("Prefix: " + stack.prefix(expr));

    }
}
class Stack{
    String[] array = new String[2];
    int index = -1;
    int brackets = 0;
    String[] symbols = new String[]{"+", "-", "*", "/", "(", ")"};
    public void push(String data){
        if(index == array.length - 1){
            String[] narray = new String[array.length*2];
            for(int i = 0; i < array.length; i++) narray[i] = array[i];
            array = narray;
            index += 1;
            array[index] = data;
        }
        else if(index == -1) array[++index] = data;
        else{
            index += 1;
            array[index] = data;
        }
    }
    public String pop(){
        String poped = "";
        if(index == -1) System.out.println("Stack is empty");
        else{
            if(array[index].equals(")")){
                array[index] = null;
                index--;
                while(!array[index].equals("(")){
                    poped += array[index];
                    array[index] = null;
                    index--;
                }
                array[index] = null;
                index--;
                brackets--;
                String[] dop = poped.split("");
                for(int i = 0; i < dop.length - 1; i++){
                    for(int j = i + 1; j < dop.length; j++){
                        if(getPriority(dop[i]) > getPriority(dop[j])){
                            poped = dop[i];
                            dop[i] = dop[j];
                            dop[j] = poped;
                        }
                    }
                }
                poped = String.join("", dop);
                if(!isEmpty() && !array[index].equals("(")) poped += pop();
            }
            else if(index > 0 && getPriority(array[index - 1]) > getPriority(array[index]) && brackets == 0){
                poped = array[index - 1];
                array[index - 1] = array[index];
                array[index] = null;
                index--;
            }
            else{
                poped = array[index];
                array[index] = null;
                index--;
            }
        }
        return poped;
    }
    public String peek(){
        return array[index];
    }
    public String toString(){
        String result = "(";
        for(int i = 0; i < index; i++) result += array[i] + ", ";
        result += array[index] + ")";
        return result;
    }
    public int getPriority(String a){
        int b = 0;
        for(int i = 0; i < symbols.length; i++) if(symbols[i].equals(a)) b = i/2;
        return b;
    }
    public boolean isEmpty(){
        return index == -1;
    }
    public String postfix(String[] array){
        String result = "";
        int a = 0;
        for(int i = 0; i < array.length; i++){
            if(Arrays.asList(symbols).contains(array[i])){
                push(array[i]);
                if(array[i].equals(")")){
                    result += pop();
                }
                else if(array[i].equals("(")){
                    brackets++;
                }
            }
            else{
                if(a == 1 && brackets == 0 && getPriority(array[i - 1]) == 1){
                    result += array[i] + pop();
                    a = 0;
                }
                else if(a == 2 && brackets == 0 && getPriority(array[i - 1]) > getPriority(array[i - 3])){
                    result += array[i] + pop() + pop();
                    a = 0;
                }
                else if(brackets == 0){
                    result += array[i];
                    a++;
                }
                else result += array[i];
            }
        }
        if(!isEmpty()){
            while(!isEmpty()) result += pop();
        }
        return result;
    }
    public String prefix(String[] array){
        String[] b = new String[array.length];
        int j = 0;
        for(int i = array.length - 1; i >= 0; i--){
            if(array[i].equals(")")) b[j] = "(";
            else if(array[i].equals("(")) b[j] = ")";
            else b[j] = array[i];
            j++;
        }
        String c = postfix(b);
        String[] a = c.split("");
        String result = "";
        for(int i = a.length - 1; i >= 0; i--) result += a[i];
        return result;
    }
}