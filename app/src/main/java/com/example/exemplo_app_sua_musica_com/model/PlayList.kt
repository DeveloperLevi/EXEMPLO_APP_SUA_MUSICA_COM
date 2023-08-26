package com.example.exemplo_app_sua_musica_com.model

import java.sql.Time

data class ModelPlayList(
    var nomeArtista: String = "",
    var nomeMusica: String = "",
    var DuracaoEmSegundos: Int = 0 ,
    var ImagemArtista: Int = 0 ) { }
