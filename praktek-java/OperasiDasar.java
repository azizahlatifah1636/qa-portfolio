import java.util.Scanner;

public class OperasiDasar {
    public static void main(String[] args) {
        int a, b;
        

        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nilai a: ");
        a = input.nextInt();
        System.out.print("Masukkan nilai b: ");
        b = input.nextInt();
        
        
        int sum = a + b;           
        int difference = b - a;     
        int product = a * b;        
        int quotient = a / b;       
        int remainder = a % b;      
        
        System.out.println("\nHasil Operasi:");
        System.out.println("a + b = " + sum);
        System.out.println("b - a = " + difference);
        System.out.println("a * b = " + product);
        System.out.println("a / b = " + quotient);
        System.out.println("a % b = " + remainder);
        
  
        input.close();
    }
}