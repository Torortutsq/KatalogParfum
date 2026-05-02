# Nephora

Nephora adalah aplikasi katalog dan pencarian parfum designer berbasis Android yang dibuat menggunakan Kotlin di Android Studio.

## Identitas
- Nama: I Gede Nada Arsana
- NIM: 42430011

## Deskripsi Aplikasi
Aplikasi ini dirancang untuk menampilkan katalog parfum designer dengan tampilan yang rapi dan elegan. Pengguna dapat melihat daftar parfum, membuka detail parfum, melakukan pencarian data, serta mengurutkan data parfum berdasarkan nama.

## Fitur Utama
- Menampilkan katalog parfum designer
- Menampilkan detail parfum
- Navigasi antar halaman menggunakan Intent
- Validasi input pada halaman tambah parfum
- Pencarian data menggunakan Linear Search
- Pengurutan data A-Z dan Z-A menggunakan Bubble Sort
- Penanganan error menggunakan try-catch
- Pencatatan aktivitas aplikasi menggunakan Logcat dengan tag `42430011`

## Struktur Halaman
- MainActivity
- DetailActivity
- AddParfumActivity

## Struktur Data
Data parfum yang digunakan dalam aplikasi terdiri dari:
- Nama parfum
- Brand
- Gender
- Aroma
- Ketahanan
- Harga

## Algoritma yang Digunakan

### Linear Search
Digunakan untuk mencari parfum berdasarkan nama atau brand sesuai input pengguna pada kolom pencarian.

### Bubble Sort
Digunakan untuk mengurutkan data parfum berdasarkan nama:
- A-Z
- Z-A

## Tools
- Android Studio
- Kotlin
- RecyclerView
- Material Design

## Cara Menjalankan Aplikasi
1. Buka project di Android Studio
2. Jalankan emulator atau hubungkan perangkat Android
3. Klik tombol Run

## Screenshot Aplikasi

### 1. Halaman Utama
Menampilkan katalog parfum designer, kolom pencarian, tombol sorting, dan tombol tambah data.

<img width="200" height="500" alt="halaman_utama" src="https://github.com/user-attachments/assets/434efcb2-6364-47b8-86d7-10e1b2ab46be" />

### 2. Halaman Utama dengan Sort A-Z
Menampilkan data parfum yang telah diurutkan dari A-Z menggunakan Bubble Sort.

<img width="200" height="500" alt="Screenshot_20260502_170706" src="https://github.com/user-attachments/assets/40e47e3c-58df-46ce-ba8d-df08e9a7f8c5" />

### 3. Halaman Utama dengan Sort Z-A
Menampilkan data parfum yang telah diurutkan dari Z-A menggunakan Bubble Sort.

<img width="200" height="500" alt="Screenshot_20260502_170651" src="https://github.com/user-attachments/assets/26f4e2d7-7b5c-4ece-bfa7-6bd4dfa6c857" />

### 4. Halaman Tambah Parfum
Menampilkan form input data parfum dengan validasi isian.

<img width="200" height="500" alt="Screenshot_20260502_170255" src="https://github.com/user-attachments/assets/f7485516-71be-4400-b0dd-48607b01e8ef" />

### 5. Halaman Detail Parfum
Menampilkan detail parfum yang dipilih dari katalog.

<img width="200" height="500" alt="Screenshot_20260502_170204" src="https://github.com/user-attachments/assets/562b31f7-be10-43ca-bfb8-1687081f6ebf" />
