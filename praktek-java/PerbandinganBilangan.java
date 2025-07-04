import java.util.Scanner;

public class PerbandinganBilangan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

      
        System.out.print("Masukkan bilangan bulat pertama: ");
        int bilangan1 = input.nextInt();
        System.out.print("Masukkan bilangan bulat kedua: ");
        int bilangan2 = input.nextInt();

    
        System.out.println("\nHasil perbandingan:");
        System.out.printf("%d == %d: %s (sama dengan)\n", bilangan1, bilangan2, bilangan1 == bilangan2 ? "benar" : "salah");
        System.out.printf("%d != %d: %s ( tidak sama dengan)\n", bilangan1, bilangan2, bilangan1 != bilangan2 ? "benar" : "salah");
        System.out.printf("%d > %d: %s (lebih besar dari)\n", bilangan1, bilangan2, bilangan1 > bilangan2 ? "benar" : "salah");
        System.out.printf("%d >= %d: %s (lebih besar atau sama dengan)\n", bilangan1, bilangan2, bilangan1 >= bilangan2 ? "benar" : "salah");
        System.out.printf("%d < %d: %s (lebih kecil dari)\n", bilangan1, bilangan2, bilangan1 < bilangan2 ? "benar" : "salah");
        System.out.printf("%d <= %d: %s (lebih kecil atau sama dengan)\n", bilangan1, bilangan2, bilangan1 <= bilangan2 ? "benar" : "salah");

        input.close();
    }
}