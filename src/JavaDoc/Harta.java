package JavaDoc;

/**
 * Package untuk mengelola perhitungan zakat
 * @author [M.Nezal ashiddiq minangkabau]
 * @version 1.0
 */

import java.util.Scanner;

/**
 * Kelas untuk mengelola data harta dan hutang
 * Menyediakan fungsi untuk mendapatkan harta bersih setelah dikurangi hutang
 */
class Harta {
    /** Jumlah total harta yang dimiliki */
    private double jumlahHarta;

    /** Jumlah total hutang yang dimiliki */
    private double jumlahHutang;

    /**
     * Konstruktor untuk membuat objek Harta baru
     *
     * @param jumlahHarta total harta yang dimiliki
     * @param jumlahHutang total hutang yang dimiliki
     */
    public Harta(double jumlahHarta, double jumlahHutang) {
        this.jumlahHarta = jumlahHarta;
        this.jumlahHutang = jumlahHutang;
    }

    /**
     * Menghitung harta bersih dengan mengurangi jumlah hutang dari total harta
     *
     * @return harta bersih setelah dikurangi hutang
     */
    public double getHartaBersih() {
        return jumlahHarta - jumlahHutang;
    }
}

/**
 * Kelas untuk menghitung nilai nishab zakat
 * Nishab adalah batas minimum harta yang wajib dizakati
 */
class NishabCalculator {
    /** Harga emas per gram dalam Rupiah */
    private static final double HARGA_EMAS_PER_GRAM = 700000;

    /** Jumlah minimal gram emas untuk perhitungan nishab */
    private static final double JUMLAH_GRAM_EMAS = 85;

    /**
     * Menghitung nilai nishab berdasarkan harga emas
     *
     * @return nilai nishab dalam Rupiah
     */
    public double hitungNishab() {
        return JUMLAH_GRAM_EMAS * HARGA_EMAS_PER_GRAM;
    }
}

/**
 * Kelas utama untuk memproses perhitungan zakat
 * Menentukan kewajiban zakat dan menghitung jumlah yang harus dibayarkan
 */
class ZakatProcessor {
    /** Persentase zakat yang harus dibayarkan */
    private static final double ZAKAT_PERCENTAGE = 0.025;

    /** Objek Harta yang akan dihitung zakatnya */
    private final Harta harta;

    /** Calculator untuk menghitung nilai nishab */
    private final NishabCalculator nishabCalculator;

    /**
     * Konstruktor untuk membuat processor zakat baru
     *
     * @param harta objek yang berisi informasi harta dan hutang
     * @param nishabCalculator calculator untuk menghitung nilai nishab
     */
    public ZakatProcessor(Harta harta, NishabCalculator nishabCalculator) {
        this.harta = harta;
        this.nishabCalculator = nishabCalculator;
    }

    /**
     * Memeriksa apakah seseorang wajib membayar zakat
     *
     * @return true jika wajib membayar zakat, false jika tidak
     */
    public boolean isWajibZakat() {
        return harta.getHartaBersih() >= nishabCalculator.hitungNishab();
    }

    /**
     * Menghitung jumlah zakat yang harus dibayarkan
     *
     * @return jumlah zakat dalam Rupiah, 0 jika tidak wajib zakat
     */
    public double hitungZakat() {
        if (!isWajibZakat()) {
            return 0;
        }
        return harta.getHartaBersih() * ZAKAT_PERCENTAGE;
    }
}

/**
 * Kelas untuk menangani interaksi dengan pengguna
 * Menyediakan metode untuk input dan output data
 */
class UserInterface {
    /** Scanner untuk membaca input dari pengguna */
    private final Scanner scanner;

    /**
     * Konstruktor untuk membuat interface pengguna baru
     */
    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Meminta input nominal dari pengguna
     *
     * @param prompt pesan yang ditampilkan kepada pengguna
     * @return nilai nominal yang diinputkan pengguna
     */
    public double inputNominal(String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    /**
     * Menampilkan hasil perhitungan zakat
     *
     * @param jumlahZakat jumlah zakat yang harus dibayarkan
     */
    public void tampilkanHasilPerhitungan(double jumlahZakat) {
        if (jumlahZakat > 0) {
            System.out.printf("Zakat yang harus dibayar: Rp %.2f%n", jumlahZakat);
        } else {
            System.out.println("Anda tidak wajib membayar zakat");
        }
    }

    /**
     * Menutup scanner untuk membersihkan resources
     */
    public void tutupScanner() {
        scanner.close();
    }
}

/**
 * Kelas utama yang menjalankan aplikasi perhitungan zakat
 */
class ZakatCalculatorRefactored {
    /**
     * Metode utama untuk menjalankan aplikasi
     *
     * @param args argumen baris perintah (tidak digunakan)
     */
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();

        double jumlahHarta = ui.inputNominal("Masukkan jumlah harta: ");
        double jumlahHutang = ui.inputNominal("Masukkan jumlah hutang: ");

        Harta harta = new Harta(jumlahHarta, jumlahHutang);
        NishabCalculator nishabCalculator = new NishabCalculator();
        ZakatProcessor zakatProcessor = new ZakatProcessor(harta, nishabCalculator);

        double jumlahZakat = zakatProcessor.hitungZakat();
        ui.tampilkanHasilPerhitungan(jumlahZakat);

        ui.tutupScanner();
    }
}
