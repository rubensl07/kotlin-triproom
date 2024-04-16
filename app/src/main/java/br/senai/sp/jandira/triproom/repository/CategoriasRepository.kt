package br.senai.sp.jandira.triproom.repository

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.triproom.R
import br.senai.sp.jandira.viagem.model.Categoria
import java.time.LocalDate

class CategoriasRepository {
    @Composable
    fun listarTodasAsCategorias(context:Context): List<Categoria>{
        val mountain = Categoria()
        mountain.id = 0
        mountain.nome = "Mountain"
        mountain.icon = "",
        mountain.cor = ""

        val snow = Categoria()
        snow.id = 1
        snow.nome = "Snow"
        snow.icon = "",
        snow.cor = ""

        val beach = Categoria()
        beach.id = 2
        beach.nome = "Beach"
        beach.icon = "",
        beach.cor = ""

        val categorias = listOf(mountain,snow,beach)
        return categorias
    }
}

