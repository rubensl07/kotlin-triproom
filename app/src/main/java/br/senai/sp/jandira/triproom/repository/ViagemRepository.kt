package br.senai.sp.jandira.triproom.repository

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.triproom.R
import br.senai.sp.jandira.viagem.model.Viagem
import java.time.LocalDate

class ViagemRepository {
    @Composable
    fun listarTodasAsViagens(context:Context): List<Viagem>{
        val viagemLondon = Viagem()
        viagemLondon.id = 0
        viagemLondon.destino = "London"
        viagemLondon.descricao = "London is the capital and largest city of  the United Kingdom, with a population of just under 9 million."
        viagemLondon.data_chegada = LocalDate.of(2019,2,18)
        viagemLondon.data_partida = LocalDate.of(2019,2,21)
        viagemLondon.imagem = painterResource(id = R.drawable.london_background)

        val viagemPorto = Viagem()
        viagemPorto.id = 1
        viagemPorto.destino = "Porto"
        viagemPorto.descricao = "Porto is the second city in Portugal, the capital of the Oporto District, and one of the Iberian Peninsula's major urban areas."
        viagemPorto.data_chegada = LocalDate.of(2022,5,15)
        viagemPorto.data_partida = LocalDate.of(2022,5,22)
        viagemPorto.imagem = painterResource(id = R.drawable.porto_background)

        val viagens = listOf(viagemLondon,viagemPorto)
        return viagens
    }
}

