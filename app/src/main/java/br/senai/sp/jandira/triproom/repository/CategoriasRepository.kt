package br.senai.sp.jandira.triproom.repository

import android.content.Context
import android.graphics.Color
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BeachAccess
import androidx.compose.material.icons.filled.Landscape
import androidx.compose.material.icons.filled.Snowboarding
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.triproom.R
import br.senai.sp.jandira.viagem.model.Categoria
import java.time.LocalDate

class CategoriasRepository {
    @Composable
    fun listarTodasAsCategorias(context: Context): List<Categoria> {
        val mountain = Categoria(
            id = 0,
            nome = "Mountain",
            icon = Icons.Default.Landscape,
//            cor = Color(0xffCF06F0)
//            cor
        )

//        mountain.cor = ""

        val snow = Categoria(
            id = 1,
            nome = "Snow",
            icon = Icons.Default.Snowboarding,
        )


        val beach = Categoria(
            id = 2,
            nome = "Beach",
            icon = Icons.Default.BeachAccess
        )

        val categorias = listOf(mountain, snow, beach)
        return categorias
    }
}

