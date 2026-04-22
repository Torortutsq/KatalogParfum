package com.example.nephora

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class AddParfumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_parfum)

        val btnBackAdd = findViewById<MaterialButton>(R.id.btnBackAdd)
        val btnSimpan = findViewById<MaterialButton>(R.id.btnSimpan)

        val etNamaParfum = findViewById<EditText>(R.id.etNamaParfum)
        val etBrand = findViewById<EditText>(R.id.etBrand)
        val etGender = findViewById<EditText>(R.id.etGender)
        val etAroma = findViewById<EditText>(R.id.etAroma)
        val etKetahanan = findViewById<EditText>(R.id.etKetahanan)
        val etHarga = findViewById<EditText>(R.id.etHarga)

        btnBackAdd.setOnClickListener {
            finish()
        }

        btnSimpan.setOnClickListener {
            val nama = etNamaParfum.text.toString().trim()
            val brand = etBrand.text.toString().trim()
            val gender = etGender.text.toString().trim()
            val aroma = etAroma.text.toString().trim()
            val ketahanan = etKetahanan.text.toString().trim()
            val hargaText = etHarga.text.toString().trim()

            if (nama.isEmpty()) {
                etNamaParfum.error = "Nama parfum wajib diisi"
            } else if (brand.isEmpty()) {
                etBrand.error = "Brand wajib diisi"
            } else if (gender.isEmpty()) {
                etGender.error = "Gender wajib diisi"
            } else if (aroma.isEmpty()) {
                etAroma.error = "Aroma wajib diisi"
            } else if (ketahanan.isEmpty()) {
                etKetahanan.error = "Ketahanan wajib diisi"
            } else if (hargaText.isEmpty()) {
                etHarga.error = "Harga wajib diisi"
            } else if (hargaText.toIntOrNull() == null) {
                etHarga.error = "Harga harus berupa angka"
            } else {
                val hargaFormat = "Rp " + String.format("%,d", hargaText.toInt()).replace(',', '.')
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("nama", nama)
                intent.putExtra("brand", brand)
                intent.putExtra("gender", gender)
                intent.putExtra("aroma", aroma)
                intent.putExtra("ketahanan", ketahanan)
                intent.putExtra("harga", hargaFormat)
                startActivity(intent)
                finish()
            }
        }
    }
}