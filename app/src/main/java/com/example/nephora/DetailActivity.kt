package com.example.nephora

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            setContentView(R.layout.activity_detail)

            val btnBackDetail = findViewById<MaterialButton>(R.id.btnBackDetail)
            val tvDetailNama = findViewById<TextView>(R.id.tvDetailNama)
            val tvDetailBrand = findViewById<TextView>(R.id.tvDetailBrand)
            val tvDetailGender = findViewById<TextView>(R.id.tvDetailGender)
            val tvDetailAroma = findViewById<TextView>(R.id.tvDetailAroma)
            val tvDetailKetahanan = findViewById<TextView>(R.id.tvDetailKetahanan)
            val tvDetailHarga = findViewById<TextView>(R.id.tvDetailHarga)

            val nama = intent.getStringExtra("nama") ?: "-"
            val brand = intent.getStringExtra("brand") ?: "-"
            val gender = intent.getStringExtra("gender") ?: "-"
            val aroma = intent.getStringExtra("aroma") ?: "-"
            val ketahanan = intent.getStringExtra("ketahanan") ?: "-"
            val harga = intent.getStringExtra("harga") ?: "-"

            tvDetailNama.text = nama
            tvDetailBrand.text = brand
            tvDetailGender.text = gender
            tvDetailAroma.text = aroma
            tvDetailKetahanan.text = ketahanan
            tvDetailHarga.text = harga

            Log.d("42430011", "DetailActivity dibuka untuk parfum: $nama")

            btnBackDetail.setOnClickListener {
                try {
                    Log.d("42430011", "Kembali ke MainActivity dari DetailActivity")
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: Exception) {
                    Log.e("42430011", "Gagal kembali ke MainActivity", e)
                    Toast.makeText(this, "Terjadi kesalahan saat kembali", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Exception) {
            Log.e("42430011", "Error di DetailActivity", e)
            Toast.makeText(this, "Terjadi error pada halaman detail", Toast.LENGTH_SHORT).show()
        }
    }
}