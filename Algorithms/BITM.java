public class BITM {
    public static void main(String[] args){
        int a = 0b101010111;
        int b = 0b111011011;
        System.out.println(a & b);
        System.out.println(a | b);
        System.out.println(a ^ b);
        System.out.println(~a);
        System.out.println(a << 1);
        System.out.println(a >> 1);
        System.out.println(a >>> 1);
    }
}