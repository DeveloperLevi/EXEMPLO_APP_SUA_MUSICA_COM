package com.example.exemplo_app_sua_musica_com

import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.exemplo_app_sua_musica_com.adapter.AdapterPlaylist
import com.example.exemplo_app_sua_musica_com.databinding.ActivityMainBinding
import com.example.exemplo_app_sua_musica_com.model.ModelPlayList
import com.example.exemplo_app_sua_musica_com.pageTransformes.Pager2_ZoomInTransformer_Kotlin
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

lateinit var binding : ActivityMainBinding
var favorito = false
var play = true
var ramdom = false
var repeat = 0
    val repeat_false_const = 0
    val repeat_playlist_const = 1
    val repeat_music_const = 2
lateinit var playlist: ArrayList<ModelPlayList>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        playlist = gerarPlayist()
        val apply = binding.viewPageMain.apply {
            adapter = AdapterPlaylist(playlist)
            setPageTransformer(Pager2_ZoomInTransformer_Kotlin())
            // Register the callback to the pager.

        }
        binding.seekBarTempoMusica.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onStopTrackingTouch(p0: SeekBar?) {}

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.textView123.text = binding.seekBarTempoMusica.progress.toString()
                binding.txtTempoAuto.text =  DecimalFormat("00").format(binding.seekBarTempoMusica.progress  / 60) + ":" + DecimalFormat("00").format(binding.seekBarTempoMusica.progress  % 60)
            }
        })

        binding.viewPageMain.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                // New page becomes selected.
                SetInfoMusic(binding.viewPageMain.currentItem)
                binding.seekBarTempoMusica.setProgress(0)
            }
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                // Current page is scrolled.
            }
            override fun onPageScrollStateChanged(state: Int) {
                when(state) {
                    ViewPager2.SCROLL_STATE_DRAGGING -> {
                        // User begins dragging or a fake drag is started.
                    }
                    ViewPager2.SCROLL_STATE_IDLE -> {
                        // Pager is fully stopped/idle.
                    }
                    ViewPager2.SCROLL_STATE_SETTLING -> {
                        // Pager is automatically settling to the current page.
                    }
                }
            }
        } )


        binding.circleIndicator.apply{
            setViewPager(binding.viewPageMain)
            }

        // esse indicador esta sendo visualizado no app
        binding.wormIndicator2.attachTo(binding.viewPageMain)
        // esse não esta sendo visualizado ao iniciar o app
        binding.dotsIndicator.attachTo(binding.viewPageMain)

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

    fun playPauseClick(view: View){
        if (play) {
            binding.imgPlayPause.setImageResource(R.drawable.ic_pause)
            play = false
        }else{
            binding.imgPlayPause.setImageResource(R.drawable.ic_play)
            play = true
        }
    }

   fun ramdomClick(view: View) {
        if (ramdom){
            binding.imgRamdom.setImageResource(R.drawable.ic_ramdom_false)
            ramdom = false
        }else{
            binding.imgRamdom.setImageResource(R.drawable.ic_ramdom_true)
            ramdom = true
        }

   }

    fun repeatClick(view: View) {
        when (repeat) {
            repeat_false_const -> {
                binding.imgRepeat.setImageResource(R.drawable.ic_repeat_playlist)
                repeat = repeat_playlist_const
            }

             repeat_playlist_const -> {
                binding.imgRepeat.setImageResource(R.drawable.ic_repeat_music)
                repeat = repeat_music_const
            }

            repeat_music_const -> {
                binding.imgRepeat.setImageResource(R.drawable.ic_repeat)
                repeat = repeat_false_const

            }
        }
    }
    fun nextMusicClick(view: View){
        binding.viewPageMain.currentItem = binding.viewPageMain.currentItem + 1
    }

    fun previousMusicClick(view: View){
        binding.viewPageMain.currentItem = binding.viewPageMain.currentItem - 1
    }

    fun gerarPlayist() : ArrayList<ModelPlayList> = arrayListOf(
        ModelPlayList("Felipe Amorim","FELIPE AMORIM - NAO FAZ ISSO COMIGO NAO",133, R.drawable.img_artista_felipe_amorim  ),
        ModelPlayList("Henry Freitas","Cadê Seu Namorado Moça - Henry Freitas",176, R.drawable.img_artista_henry_freitas  ),
        ModelPlayList("Larissa Gomes","QUEM É O LOUCO ENTRE NÓS",181, R.drawable.img_artista_larissa_gomes  ),
        ModelPlayList("Nattan","VAI LA E QUEBRA A CARA",161, R.drawable.img_artista_nattan  ),
        ModelPlayList("Mari Fernandez","LOVE LOVE - Mari Fernandez",141, R.drawable.img_artista_mari_fernandez  ),
        ModelPlayList("Nadson o Ferinha","DUAS",137, R.drawable.img_artista_nadson_o_ferinha  ),
        ModelPlayList("Tarcisio do Acordeon","CHOREI NA VAQUEJADA - Tarcísio do Acordeon",190, R.drawable.img_artista_tarcisio_do_acrodeon  ),
        ModelPlayList("Toquedez","oi erro",486, R.drawable.img_artista_toquedez  ),
        ModelPlayList("Iguinho e Lulinha","Se É Amor Não Sei",159, R.drawable.img_artista_iguinho_e_lulinha  )
    )

    fun SetInfoMusic( PositionList: Int){
        binding.textNomeArtista.text = playlist.get(PositionList).nomeArtista
        binding.textNomeMusica.text  = playlist.get(PositionList).nomeMusica
        binding.txtTempoTotal.text =  DecimalFormat("00").format(playlist.get(PositionList).DuracaoEmSegundos  / 60) + ":" + DecimalFormat("00").format(playlist.get(PositionList).DuracaoEmSegundos  % 60)

        binding.seekBarTempoMusica.max = playlist.get(PositionList).DuracaoEmSegundos
        binding.textView123.text = binding.seekBarTempoMusica.progress.toString()

    }

}