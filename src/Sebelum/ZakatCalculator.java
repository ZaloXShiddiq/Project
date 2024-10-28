package Sebelum;

// Program sebelum refactoring

import java.util.Scanner;

public class ZakatCalculator {

    private static double hutang;
    private static double harta;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah harta: ");
        harta = scanner.nextDouble();

        System.out.print("Masukkan jumlah hutang: ");
        hutang = scanner.nextDouble();

        double nishab = 85 * 700000;
        double hartaBersih = harta - hutang;

        if (hartaBersih >= nishab) {
            double zakat = hartaBersih * 0.025;
            System.out.println("Zakat yang harus dibayar: " + zakat);
        } else {
            System.out.println("Anda tidak wajib membayar zakat");
        }

        scanner.close();
    }
}
