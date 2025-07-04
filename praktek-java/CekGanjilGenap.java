import java.util.Scanner;

public class CekGanjilGenap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan angka 1-10: ");
        int bilangan = input.nextInt();
        if (bilangan >= 1 && bilangan <= 10) {
            if (bilangan % 2 == 0) {
                System.out.println("Bilangan genap");
            } else {
                System.out.println("Bilangan ganjil");
            }
        } else {
            System.out.println("Bilangan diluar jangkauan");
        }   
        input.close();
    }
}   