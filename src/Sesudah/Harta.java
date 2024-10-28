package Sesudah;
// Program setelah refactoring
import java.util.Scanner;

class Harta {
    private double jumlahHarta;
    private double jumlahHutang;

    public Harta(double jumlahHarta, double jumlahHutang) {
        this.jumlahHarta = jumlahHarta;
        this.jumlahHutang = jumlahHutang;
    }

    public double getHartaBersih() {
        return jumlahHarta - jumlahHutang;
    }
}

class NishabCalculator {
    private static final double HARGA_EMAS_PER_GRAM = 700000;
    private static final double JUMLAH_GRAM_EMAS = 85;

    public double hitungNishab() {
        return JUMLAH_GRAM_EMAS * HARGA_EMAS_PER_GRAM;
    }
}

class ZakatProcessor {
    private static final double ZAKAT_PERCENTAGE = 0.025;
    private final Harta harta;
    private final NishabCalculator nishabCalculator;

    public ZakatProcessor(Harta harta, NishabCalculator nishabCalculator) {
        this.harta = harta;
        this.nishabCalculator = nishabCalculator;
    }

    public boolean isWajibZakat() {
        return harta.getHartaBersih() >= nishabCalculator.hitungNishab();
    }

    public double hitungZakat() {
        if (!isWajibZakat()) {
            return 0;
        }
        return harta.getHartaBersih() * ZAKAT_PERCENTAGE;
    }
}

class UserInterface {
    private final Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public double inputNominal(String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    public void tampilkanHasilPerhitungan(double jumlahZakat) {
        if (jumlahZakat > 0) {
            System.out.printf("Zakat yang harus dibayar: Rp %.2f%n", jumlahZakat);
        } else {
            System.out.println("Anda tidak wajib membayar zakat");
        }
    }

    public void tutupScanner() {
        scanner.close();
    }
}

class ZakatCalculatorRefactored {
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
