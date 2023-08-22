package com.example.exemplo_app_sua_musica_com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.exemplo_app_sua_musica_com.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
lateinit var binding : ActivityMainBinding
var favorito = false
var play = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun favoritar(view: View){
        if (favorito) {
            binding.imgFavorito.setImageResource(R.drawable.ic_favorite_border)
            favorito = false
        } else {
            binding.imgFavorito.setImageResource(R.drawable.ic_favorite)
            favorito = true
        }
    }

    fun playPause(view: View){
        if (play) {
            binding.imgPlayPause.setImageResource(R.drawable.ic_pause)
            play = false
        }else{
            binding.imgPlayPause.setImageResource(R.drawable.ic_play)
            play = true
        }
    }
}