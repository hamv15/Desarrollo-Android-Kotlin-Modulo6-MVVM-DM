package com.hamv15.mvvmdm.ui

import androidx.recyclerview.widget.RecyclerView
import com.hamv15.mvvmdm.data.remote.model.AnimeDto
import com.hamv15.mvvmdm.databinding.AnimesElementBinding

class AnimeViewHolder(
    private var binding: AnimesElementBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(anime: AnimeDto){
        binding.apply {
            tvTitulo.text = anime.titulo
            tvTipo.text = anime.tipo
            tvFecha.text = anime.fecha
        }
    }
}