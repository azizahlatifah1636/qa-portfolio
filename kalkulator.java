public class kalkulator {
    // Method sapa
    static void sapa() {
        System.out.println("Halo, dunia!");
    }

    // Method hitung luas persegi
    static int hitungLuas(int sisi) {
        return sisi * sisi;
    }

    public static void main(String[] args) {
        sapa(); // Memanggil method sapa (tanpa parameter)

        int luas = hitungLuas(5); // Memanggil method hitungLuas
        System.out.println("Luas persegi: " + luas); // Output: 25
    }
}