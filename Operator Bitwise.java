package dklsa;

public class Main{
    public static void main(String[] args) {
        byte a,b,c;
        String a_bits, b_bits, c_bits;
        a = 24;
        // shift left
        
        System.out.println("============= SHIFT LEFT (<<)");
        b = (byte)(a<<1);
        a_bits = String.format("%8s", Integer.toBinaryString(a)).replace(' ', '0');
        b_bits = String.format("%8s", Integer.toBinaryString(b)).replace(' ', '0');
        System.out.printf("a => %s = %d \n",a_bits, a);
        System.out.printf("b => %s = %d \n",b_bits, b);

        System.out.println("\n============= SHIFT RIGHT (>>)");
        b = (byte)(a>>1);
        a_bits = String.format("%8s", Integer.toBinaryString(a)).replace(' ', '0');
        b_bits = String.format("%8s", Integer.toBinaryString(b)).replace(' ', '0');
        System.out.printf("a => %s = %d \n",a_bits, a);
        System.out.printf("b => %s = %d \n",b_bits, b);

        System.out.println("\n============= AND (&)");
        b = 12;
        c = (byte)(a&b);
        a_bits = String.format("%8s", Integer.toBinaryString(a)).replace(' ', '0');
        b_bits = String.format("%8s", Integer.toBinaryString(b)).replace(' ', '0');
        c_bits = String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0');
        System.out.printf("a => %s = %d \n",a_bits, a);
        System.out.printf("b => %s = %d \n",b_bits, b);
        System.out.printf("c => %s = %d \n",c_bits, c);

        System.out.println("\n============= OR (|)");
        c = (byte)(a|b);
        a_bits = String.format("%8s", Integer.toBinaryString(a)).replace(' ', '0');
        b_bits = String.format("%8s", Integer.toBinaryString(b)).replace(' ', '0');
        c_bits = String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0');
        System.out.printf("a => %s = %d \n",a_bits, a);
        System.out.printf("b => %s = %d \n",b_bits, b);
        System.out.printf("c => %s = %d \n",c_bits, c);

        System.out.println("\n============= XOR (^)");
        c = (byte)(a^b);
        a_bits = String.format("%8s", Integer.toBinaryString(a)).replace(' ', '0');
        b_bits = String.format("%8s", Integer.toBinaryString(b)).replace(' ', '0');
        c_bits = String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0');
        System.out.printf("a => %s = %d \n",a_bits, a);
        System.out.printf("b => %s = %d \n",b_bits, b);
        System.out.printf("c => %s = %d \n",c_bits, c);

        System.out.println("\n============= NOT (~)");
        c = (byte)~a;
        a_bits = String.format("%8s", Integer.toBinaryString(a)).replace(' ', '0');
        c_bits = String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0').substring(24);
        System.out.printf("a => %s = %d \n",a_bits, a);
        System.out.printf("c => %s = %d \n",c_bits, c);


    }
}