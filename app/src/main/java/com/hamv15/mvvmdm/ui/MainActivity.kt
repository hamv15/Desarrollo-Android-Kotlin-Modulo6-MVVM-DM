package com.hamv15.mvvmdm.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamv15.mvvmdm.R
import com.hamv15.mvvmdm.data.remote.model.AnimeDto
import com.hamv15.mvvmdm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var animes = mutableListOf<AnimeDto>()

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val myAdapter = AnimesAdapter(animes){
            //Aquí va el click de los elementos
        }

        binding.rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = myAdapter
        }

        binding.btnAdd.setOnClickListener {
            mainViewModel.getAnime()

            binding.btnAdd.isEnabled = false
            binding.pbDownload.visibility = View.VISIBLE
        }

        mainViewModel.anime.observe(this, Observer {anime ->
            //Llega la notificaión de que el contenedor ha sido actualizado
            binding.btnAdd.isEnabled = true
            binding.pbDownload.visibility = View.INVISIBLE

            animes.add(anime)

            myAdapter.notifyItemInserted(animes.size-1)

        })

    }
}