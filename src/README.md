# Zakat Calculator

Aplikasi perhitungan zakat mal sederhana berbasis Java yang membantu pengguna menghitung kewajiban zakat berdasarkan total harta dan hutang yang dimiliki.

## 📝 Deskripsi

Zakat Calculator adalah aplikasi command-line yang memungkinkan pengguna untuk:
- Menghitung zakat mal berdasarkan harta bersih
- Menentukan kewajiban zakat berdasarkan nilai nishab
- Mendapatkan hasil perhitungan yang akurat sesuai dengan ketentuan syariah

### Fitur Utama
- Perhitungan otomatis nilai nishab berdasarkan harga emas terkini
- Perhitungan harta bersih (total harta dikurangi hutang)
- Penentuan kewajiban zakat
- Perhitungan jumlah zakat yang harus dibayarkan (2.5% dari harta bersih)

## 🚀 Cara Menjalankan Proyek

### Prasyarat
- Java Development Kit (JDK) versi 8 atau lebih tinggi
- Java Runtime Environment (JRE)
- Command line interface atau IDE Java

### Langkah-langkah Instalasi

1. Clone repository ini:
```bash
git clone https://github.com/username/zakat-calculator.git
cd zakat-calculator
```

2. Compile program:
```bash
javac ZakatCalculatorRefactored.java
```

3. Jalankan program:
```bash
java ZakatCalculatorRefactored
```

### Cara Penggunaan

1. Masukkan jumlah total harta ketika diminta
2. Masukkan jumlah total hutang ketika diminta
3. Program akan menampilkan:
    - Status kewajiban zakat
    - Jumlah zakat yang harus dibayarkan (jika wajib zakat)

## 🏗️ Struktur Proyek

```
zakat-calculator/
├── src/
│   ├── Harta.java
│   ├── NishabCalculator.java
│   ├── ZakatProcessor.java
│   ├── UserInterface.java
│   └── ZakatCalculatorRefactored.java
├── docs/
│   └── javadoc/
├── README.md
└── LICENSE
```

## 📚 Dokumentasi

Dokumentasi lengkap dalam format JavaDoc tersedia di folder `docs/javadoc/`. Untuk menghasilkan dokumentasi, jalankan:

```bash
javadoc -d docs/javadoc src/*.java
```

## 🔄 Refactoring yang Dilakukan

1. **Extract Class Refactoring**
    - Pemisahan logika ke dalam kelas-kelas terpisah
    - Meningkatkan kohesi dan mengurangi coupling

2. **Move Field and Encapsulate Field**
    - Enkapsulasi data dengan private fields
    - Implementasi getter methods yang sesuai

3. **Extract Interface Method**
    - Pemisahan logika UI ke dalam kelas terpisah
    - Meningkatkan testability

4. **Extract Constant**
    - Konstanta untuk nilai-nilai penting
    - Meningkatkan maintainability

5. **Replace Constructor with Builder Pattern**
    - Konstruksi objek yang lebih terstruktur
    - Meningkatkan fleksibilitas

## 📐 Perhitungan yang Digunakan

- **Nishab** = 85 gram emas × harga emas per gram
- **Harta Bersih** = Total Harta - Total Hutang
- **Zakat** = 2.5% × Harta Bersih (jika Harta Bersih ≥ Nishab)

## ⚙️ Konfigurasi

Beberapa nilai yang dapat dikonfigurasi dalam `NishabCalculator.java`:
- `HARGA_EMAS_PER_GRAM`: Harga emas per gram (default: Rp 700.000)
- `JUMLAH_GRAM_EMAS`: Jumlah gram emas untuk nishab (default: 85 gram)

## 🤝 Kontribusi

Kontribusi selalu diterima dengan senang hati. Untuk berkontribusi:

1. Fork repository
2. Buat branch baru (`git checkout -b fitur-baru`)
3. Commit perubahan (`git commit -m 'Menambah fitur baru'`)
4. Push ke branch (`git push origin fitur-baru`)
5. Buat Pull Request

## 📝 Lisensi

Proyek ini dilisensikan di bawah [MIT License](LICENSE)

## 👥 Author

- [M.NEZAL ASHIDDIQ MINANGKABAU]
- Email: [ezaneza145@gmail.com]

## 🔍 Catatan Penting

- Aplikasi ini menggunakan harga emas default. Untuk hasil yang lebih akurat, sesuaikan harga emas dengan harga terkini
- Perhitungan zakat ini hanya untuk zakat mal (harta), tidak termasuk jenis zakat lainnya
- Hasil perhitungan sebaiknya dikonsultasikan dengan ahli zakat untuk memastikan keabsahan

## 📞 Dukungan

Jika Anda menemukan bug atau memiliki pertanyaan:
1. Buat issue di GitHub repository
2. Kirim email ke [email@domain.com]
3. Kunjungi [website dukungan](https://example.com/support)