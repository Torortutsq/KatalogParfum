package com.example.nephora

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ParfumAdapter(
    private val context: Context,
    private val listParfum: ArrayList<Parfum>
) : RecyclerView.Adapter<ParfumAdapter.ParfumViewHolder>() {

    class ParfumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNamaParfum: TextView = itemView.findViewById(R.id.tvNamaParfum)
        val tvBrandParfum: TextView = itemView.findViewById(R.id.tvBrandParfum)
        val tvAromaParfum: TextView = itemView.findViewById(R.id.tvAromaParfum)
        val tvKetahananParfum: TextView = itemView.findViewById(R.id.tvKetahananParfum)
        val tvHargaParfum: TextView = itemView.findViewById(R.id.tvHargaParfum)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParfumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_parfum, parent, false)
        return ParfumViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParfumViewHolder, position: Int) {
        val parfum = listParfum[position]

        holder.tvNamaParfum.text = parfum.nama
        holder.tvBrandParfum.text = parfum.brand
        holder.tvAromaParfum.text = parfum.aroma
        holder.tvKetahananParfum.text = "Ketahanan: ${parfum.ketahanan}"
        holder.tvHargaParfum.text = "Rp " + String.format("%,d", parfum.harga).replace(',', '.')

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("nama", parfum.nama)
            intent.putExtra("brand", parfum.brand)
            intent.putExtra("gender", parfum.gender)
            intent.putExtra("aroma", parfum.aroma)
            intent.putExtra("ketahanan", parfum.ketahanan)
            intent.putExtra("harga", "Rp " + String.format("%,d", parfum.harga).replace(',', '.'))
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listParfum.size
}