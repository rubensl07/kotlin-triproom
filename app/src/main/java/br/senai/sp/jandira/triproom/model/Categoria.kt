package br.senai.sp.jandira.viagem.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class Categoria(
    var id:Int=0,
    var nome: String="",
    var icon: ImageVector? = null,
    var cor: Color? = null
);
