import java.util.Scanner;

public class LatihanLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int options;
        do {
            System.out.println("\n=== MENU LATIHAN LOOP ===");
            System.out.println("1. Hitung Bilangan Genap (for loop)");
            System.out.println("2. Hitung Faktorial (while loop)");
            System.out.println("3. Validasi Input (do-while loop)");
            System.out.println("4. Tampilkan Array (for-each loop)");
            System.out.println("5. Contoh Break & Continue");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            options = input.nextInt();
            switch (options) {
                case 1:
                    hitungBilanganGenap(input);
                    break;
                case 2:
                    hitungFaktorial(input);
                    break;
                case 3:
                    validasiInput(input);
                    break;
                case 4:
                    TampilkanArray(input);
                    break;
                case 5:
                    contohbreakcontinue(input);
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }
        } while (options != 0);
        input.close();
    }

    private static void contohbreakcontinue(Scanner input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contohbreakcontinue'");
    }

    private static void TampilkanArray(Scanner input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'TampilkanArray'");
    }

    // Method untuk contoh for loop (bilangan genap)
    public static void hitungBilanganGenap(Scanner input) {
        System.out.print("\nMasukkan batas atas (N): ");
        int n = input.nextInt();
        System.out.println("Bilangan genap dari 1 hingga " + n + ":");

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // Method untuk contoh while loop (faktorial)
    public static void hitungFaktorial(Scanner input) {
        System.out.print("\nMasukkan bilangan: ");
        int num = input.nextInt();
        long faktorial = 1;
        int i = 1;

        while (i <= num) {
            faktorial *= i;
            i++;
        }
        System.out.println(num + "! = " + faktorial);
    }

    // Method untuk contoh do-while loop (validasi input)
    public static void validasiInput(Scanner input) {
        int angka;
        do {
            System.out.print("\nMasukkan angka positif: ");
            angka = input.nextInt();
            if (angka <= 0) {
                System.out.println("Input tidak valid. Coba lagi!");
            }
        } while (angka <= 0);

        System.out.println("Anda memasukkan: " + angka);
    }

    // Method untuk contoh for-each loop (array)
    public static void tampilkanArray() {
        String[] buah = { "Apel", "Mangga", "Jeruk", "Anggur" };
        System.out.println("\nDaftar Buah:");

        for (String item : buah) {
            System.out.println("- " + item);
        }
    }

    // Method untuk contoh break & continue
    public static void contohBreakContinue() {
        System.out.println("\nContoh Break (berhenti di angka 5):");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break;
            }
            System.out.print(i + " ");
        }

        System.out.println("\n\nContoh Continue (lewati angka ganjil):");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
