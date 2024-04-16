package br.senai.sp.jandira.viagem.model

import androidx.compose.ui.graphics.painter.Painter

data class Categoria(
    var id:Int=0,
    var nome: String="",
    var icon: ,
    var cor: ,
    var imagem: Painter? = null
);
