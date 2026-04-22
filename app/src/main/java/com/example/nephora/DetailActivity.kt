package com.example.nephora

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val btnBackDetail = findViewById<MaterialButton>(R.id.btnBackDetail)
        val tvDetailNama = findViewById<TextView>(R.id.tvDetailNama)
        val tvDetailBrand = findViewById<TextView>(R.id.tvDetailBrand)
        val tvDetailGender = findViewById<TextView>(R.id.tvDetailGender)
        val tvDetailAroma = findViewById<TextView>(R.id.tvDetailAroma)
        val tvDetailKetahanan = findViewById<TextView>(R.id.tvDetailKetahanan)
        val tvDetailHarga = findViewById<TextView>(R.id.tvDetailHarga)

        tvDetailNama.text = intent.getStringExtra("nama")
        tvDetailBrand.text = intent.getStringExtra("brand")
        tvDetailGender.text = intent.getStringExtra("gender")
        tvDetailAroma.text = intent.getStringExtra("aroma")
        tvDetailKetahanan.text = intent.getStringExtra("ketahanan")
        tvDetailHarga.text = intent.getStringExtra("harga")

        btnBackDetail.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}