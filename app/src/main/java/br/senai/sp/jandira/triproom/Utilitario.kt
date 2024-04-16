package br.senai.sp.jandira.triproom

import java.time.LocalDate

fun simplificarData(chegadaExtenso: LocalDate, partidaExtenso: LocalDate): String{
    return "${chegadaExtenso.dayOfMonth.toString()} ${chegadaExtenso.month.toString().substring(0..2)} - ${partidaExtenso.dayOfMonth.toString()} ${partidaExtenso.month.toString().substring(0..2)}"
}