package com.example.nephora

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class AddParfumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            setContentView(R.layout.activity_add_parfum)

            val btnBackAdd = findViewById<MaterialButton>(R.id.btnBackAdd)
            val btnSimpan = findViewById<MaterialButton>(R.id.btnSimpan)

            val etNamaParfum = findViewById<EditText>(R.id.etNamaParfum)
            val etBrand = findViewById<EditText>(R.id.etBrand)
            val etGender = findViewById<EditText>(R.id.etGender)
            val etAroma = findViewById<EditText>(R.id.etAroma)
            val etKetahanan = findViewById<EditText>(R.id.etKetahanan)
            val etHarga = findViewById<EditText>(R.id.etHarga)

            Log.d("42430011", "AddParfumActivity berhasil dibuka")

            btnBackAdd.setOnClickListener {
                try {
                    Log.d("42430011", "Kembali ke MainActivity dari AddParfumActivity")
                    finish()
                } catch (e: Exception) {
                    Log.e("42430011", "Gagal kembali dari AddParfumActivity", e)
                }
            }

            btnSimpan.setOnClickListener {
                try {
                    val nama = etNamaParfum.text.toString().trim()
                    val brand = etBrand.text.toString().trim()
                    val gender = etGender.text.toString().trim()
                    val aroma = etAroma.text.toString().trim()
                    val ketahanan = etKetahanan.text.toString().trim()
                    val hargaText = etHarga.text.toString().trim()

                    if (nama.isEmpty()) {
                        etNamaParfum.error = "Nama parfum wajib diisi"
                        Log.d("42430011", "Validasi gagal pada nama parfum")
                    } else if (brand.isEmpty()) {
                        etBrand.error = "Brand wajib diisi"
                        Log.d("42430011", "Validasi gagal pada brand")
                    } else if (gender.isEmpty()) {
                        etGender.error = "Gender wajib diisi"
                        Log.d("42430011", "Validasi gagal pada gender")
                    } else if (aroma.isEmpty()) {
                        etAroma.error = "Aroma wajib diisi"
                        Log.d("42430011", "Validasi gagal pada aroma")
                    } else if (ketahanan.isEmpty()) {
                        etKetahanan.error = "Ketahanan wajib diisi"
                        Log.d("42430011", "Validasi gagal pada ketahanan")
                    } else if (hargaText.isEmpty()) {
                        etHarga.error = "Harga wajib diisi"
                        Log.d("42430011", "Validasi gagal pada harga kosong")
                    } else if (hargaText.toIntOrNull() == null) {
                        etHarga.error = "Harga harus berupa angka"
                        Log.d("42430011", "Validasi gagal karena harga bukan angka")
                    } else {
                        val hargaFormat = "Rp " + String.format("%,d", hargaText.toInt()).replace(',', '.')
                        val intent = Intent(this, DetailActivity::class.java)
                        intent.putExtra("nama", nama)
                        intent.putExtra("brand", brand)
                        intent.putExtra("gender", gender)
                        intent.putExtra("aroma", aroma)
                        intent.putExtra("ketahanan", ketahanan)
                        intent.putExtra("harga", hargaFormat)
                        Log.d("42430011", "Data valid, pindah ke DetailActivity")
                        startActivity(intent)
                        finish()
                    }
                } catch (e: Exception) {
                    Log.e("42430011", "Error saat menyimpan data parfum", e)
                    Toast.makeText(this, "Terjadi kesalahan saat memproses data", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Exception) {
            Log.e("42430011", "Error di AddParfumActivity", e)
            Toast.makeText(this, "Terjadi error pada halaman tambah data", Toast.LENGTH_SHORT).show()
        }
    }
}