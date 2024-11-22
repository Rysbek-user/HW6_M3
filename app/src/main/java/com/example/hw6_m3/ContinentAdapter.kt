package com.example.hw6_m3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw6_m3.databinding.ItemContinentBinding

class ContinentAdapter(
    private val continentList: ArrayList<String>,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<ContinentAdapter.ContinentViewHolder>() {

    inner class ContinentViewHolder(private val binding: ItemContinentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(continent: String) {
            binding.tvContinent.text = continent
            binding.root.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContinentViewHolder {
        val binding = ItemContinentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContinentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContinentViewHolder, position: Int) {
        holder.bind(continentList[position])
    }

    override fun getItemCount() = continentList.size
}
