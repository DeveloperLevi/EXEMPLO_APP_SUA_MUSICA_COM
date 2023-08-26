package com.example.exemplo_app_sua_musica_com.adapter

import android.opengl.GLES30
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.exemplo_app_sua_musica_com.R
import com.example.exemplo_app_sua_musica_com.model.ModelPlayList


class AdapterPlaylist(val playlist: ArrayList<ModelPlayList>): RecyclerView.Adapter<ViewHolderPlaylist>() {

    // Retorna a quantidade de Registros
    override fun getItemCount(): Int = playlist.size

    //cria a visualização do card para cada page do pageview2
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPlaylist {
        return ViewHolderPlaylist(
            LayoutInflater.from(parent.context).inflate(R.layout.card_image_artista, parent, false)
        )
    }

    // liga cada registro do Arraylist a cada ViewHolder  = vizualização de cada page do pageview2
    override fun onBindViewHolder(holder: ViewHolderPlaylist, position: Int) {
        holder.imagemArtista.setImageResource(playlist[position].ImagemArtista)
    }
    // aqui instacia as views apra variaveis para serem usadas no metodo onBindViewHolder

}
    class ViewHolderPlaylist(view: View): RecyclerView.ViewHolder(view) {
        val imagemArtista = view.findViewById<ImageView>(R.id.imgArtista)
    }
