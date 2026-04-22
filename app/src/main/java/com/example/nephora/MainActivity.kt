package com.example.nephora

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var rvParfum: RecyclerView
    private lateinit var btnTambah: MaterialButton
    private lateinit var parfumAdapter: ParfumAdapter
    private val daftarParfum = arrayListOf(
        Parfum("Dior Sauvage", "Dior", "Pria", "Fresh Spicy", "8-10 jam", 1850000),
        Parfum("Bleu de Chanel EDP", "Chanel", "Pria", "Woody Fresh", "8-10 jam", 2100000),
        Parfum("YSL Y EDP", "YSL", "Pria", "Fresh Aromatic", "7-9 jam", 1900000),
        Parfum("Prada L'Homme", "Prada", "Pria", "Powdery Woody", "7-8 jam", 1750000),
        Parfum("Acqua di Gio Profondo", "Armani", "Pria", "Marine Aromatic", "7-9 jam", 1800000),
        Parfum("Versace Eros EDT", "Versace", "Pria", "Sweet Fresh", "8-10 jam", 1600000),
        Parfum("Coco Mademoiselle", "Chanel", "Wanita", "Floral Citrus", "8-10 jam", 2300000),
        Parfum("Gucci Bloom", "Gucci", "Wanita", "White Floral", "6-8 jam", 2000000),
        Parfum("Armani Si", "Armani", "Wanita", "Sweet Chypre", "7-9 jam", 1950000),
        Parfum("Burberry Her", "Burberry", "Wanita", "Fruity Sweet", "6-8 jam", 1850000),
        Parfum("Miss Dior Blooming Bouquet", "Dior", "Wanita", "Fresh Floral", "5-7 jam", 2100000),
        Parfum("Libre EDP", "YSL", "Wanita", "Floral Lavender", "8-10 jam", 2200000)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvParfum = findViewById(R.id.rvParfum)
        btnTambah = findViewById(R.id.btnTambah)

        rvParfum.layoutManager = LinearLayoutManager(this)
        parfumAdapter = ParfumAdapter(this, daftarParfum)
        rvParfum.adapter = parfumAdapter

        btnTambah.setOnClickListener {
            val intent = Intent(this, AddParfumActivity::class.java)
            startActivity(intent)
        }
    }
}