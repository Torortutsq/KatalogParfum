package com.example.nephora

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var etSearch: EditText
    private lateinit var btnCari: MaterialButton
    private lateinit var btnSortAZ: MaterialButton
    private lateinit var btnSortZA: MaterialButton
    private lateinit var btnTambah: MaterialButton
    private lateinit var rvParfum: RecyclerView
    private lateinit var parfumAdapter: ParfumAdapter
    private lateinit var dataParfum: Array<Parfum>
    private val daftarTampil = ArrayList<Parfum>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etSearch = findViewById(R.id.etSearch)
        btnCari = findViewById(R.id.btnCari)
        btnSortAZ = findViewById(R.id.btnSortAZ)
        btnSortZA = findViewById(R.id.btnSortZA)
        btnTambah = findViewById(R.id.btnTambah)
        rvParfum = findViewById(R.id.rvParfum)

        dataParfum = arrayOf(
            Parfum("Dior Sauvage", "Dior", "Pria", "Fresh Spicy", "8-10 jam", 1850000),
            Parfum("Bleu de Chanel EDP", "Chanel", "Pria", "Woody Fresh", "8-10 jam", 2100000),
            Parfum("YSL Y EDP", "YSL", "Pria", "Fresh Aromatic", "7-9 jam", 1900000),
            Parfum("Prada L'Homme", "Prada", "Pria", "Powdery Woody", "7-8 jam", 1750000),
            Parfum("Acqua di Gio Profondo", "Armani", "Pria", "Marine Aromatic", "7-9 jam", 1800000),
            Parfum("Versace Eros EDT", "Versace", "Pria", "Sweet Fresh", "8-10 jam", 1600000),
            Parfum("Dylan Blue", "Versace", "Pria", "Fresh Woody", "7-9 jam", 1550000),
            Parfum("The One EDP", "Dolce & Gabbana", "Pria", "Warm Spicy", "6-8 jam", 1700000),
            Parfum("Coco Mademoiselle", "Chanel", "Wanita", "Floral Citrus", "8-10 jam", 2300000),
            Parfum("Gucci Bloom", "Gucci", "Wanita", "White Floral", "6-8 jam", 2000000),
            Parfum("Armani Si", "Armani", "Wanita", "Sweet Chypre", "7-9 jam", 1950000),
            Parfum("Burberry Her", "Burberry", "Wanita", "Fruity Sweet", "6-8 jam", 1850000),
            Parfum("Miss Dior Blooming Bouquet", "Dior", "Wanita", "Fresh Floral", "5-7 jam", 2100000),
            Parfum("Libre EDP", "YSL", "Wanita", "Floral Lavender", "8-10 jam", 2200000),
            Parfum("My Way", "Armani", "Wanita", "White Floral", "7-9 jam", 2150000),
            Parfum("Flora Gorgeous Gardenia", "Gucci", "Wanita", "Floral Sweet", "6-8 jam", 2050000),
            Parfum("Bvlgari Man Wood Essence", "Bvlgari", "Pria", "Woody Citrus", "6-8 jam", 1750000),
            Parfum("Light Blue Pour Homme", "Dolce & Gabbana", "Pria", "Fresh Citrus", "6-8 jam", 1650000)
        )

        rvParfum.layoutManager = LinearLayoutManager(this)
        parfumAdapter = ParfumAdapter(this, daftarTampil)
        rvParfum.adapter = parfumAdapter

        tampilkanSemuaData()

        btnTambah.setOnClickListener {
            val intent = Intent(this, AddParfumActivity::class.java)
            startActivity(intent)
        }

        btnCari.setOnClickListener {
            cariParfum(etSearch.text.toString())
        }

        btnSortAZ.setOnClickListener {
            bubbleSortAZ()
            parfumAdapter.notifyDataSetChanged()
        }

        btnSortZA.setOnClickListener {
            bubbleSortZA()
            parfumAdapter.notifyDataSetChanged()
        }

        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                cariParfum(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    private fun tampilkanSemuaData() {
        daftarTampil.clear()
        for (parfum in dataParfum) {
            daftarTampil.add(parfum)
        }
        parfumAdapter.notifyDataSetChanged()
    }

    private fun cariParfum(keywordInput: String) {
        val keyword = keywordInput.trim().lowercase()

        daftarTampil.clear()

        if (keyword.isEmpty()) {
            for (parfum in dataParfum) {
                daftarTampil.add(parfum)
            }
        } else {
            for (parfum in dataParfum) {
                if (
                    parfum.nama.lowercase().startsWith(keyword) ||
                    parfum.brand.lowercase().startsWith(keyword)
                ) {
                    daftarTampil.add(parfum)
                }
            }
        }

        parfumAdapter.notifyDataSetChanged()
    }

    private fun bubbleSortAZ() {
        for (i in 0 until daftarTampil.size - 1) {
            for (j in 0 until daftarTampil.size - i - 1) {
                if (daftarTampil[j].nama.lowercase() > daftarTampil[j + 1].nama.lowercase()) {
                    val temp = daftarTampil[j]
                    daftarTampil[j] = daftarTampil[j + 1]
                    daftarTampil[j + 1] = temp
                }
            }
        }
    }

    private fun bubbleSortZA() {
        for (i in 0 until daftarTampil.size - 1) {
            for (j in 0 until daftarTampil.size - i - 1) {
                if (daftarTampil[j].nama.lowercase() < daftarTampil[j + 1].nama.lowercase()) {
                    val temp = daftarTampil[j]
                    daftarTampil[j] = daftarTampil[j + 1]
                    daftarTampil[j + 1] = temp
                }
            }
        }
    }
}