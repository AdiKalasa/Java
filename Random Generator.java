package dklsa;
import java.util.Random;
public class Main{
    public static void main(String[] args) {
        Random rd = new Random();
        for(int i = 0;i<5;i++){
            int a = rd.nextInt(6);
            System.out.println(a);
        }
        
    }
}