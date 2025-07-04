public class CetakWarna {
    public static void main(String[] args) {
       
        String[] warna = {"hitam", "biru", "putih", "merah", "kuning"};
        
        System.out.println("Mencetak semua warna:");
        for (String warnaItem : warna) {
            System.out.println("Warnanya adalah " + warnaItem);
        }
        
        System.out.println(); 
        
       
        System.out.println("Mencetak semua warna kecuali 'putih':");
        for (String warnaItem : warna) {
            if (warnaItem.equals("putih")) {
                continue; 
            }
            System.out.println("Warnanya adalah " + warnaItem);
        }
    }
}