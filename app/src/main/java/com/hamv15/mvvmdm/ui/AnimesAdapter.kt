package com.hamv15.mvvmdm.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hamv15.mvvmdm.data.remote.model.AnimeDto
import com.hamv15.mvvmdm.databinding.AnimesElementBinding

class AnimesAdapter(
    private val animes: MutableList<AnimeDto>,
    private val onAnimeClicked: (AnimeDto) -> Unit //Para manejar los clicks
):RecyclerView.Adapter<AnimeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val bindin = AnimesElementBinding.inflate(LayoutInflater.from(parent.context))
        return AnimeViewHolder(bindin)
    }

    override fun getItemCount(): Int {
        return animes.size
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val anime = animes[position]
        holder.bind(anime)

        holder.itemView.setOnClickListener {
            onAnimeClicked(anime)
        }
    }

}