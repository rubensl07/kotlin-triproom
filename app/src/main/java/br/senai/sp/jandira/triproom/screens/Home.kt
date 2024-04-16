package br.senai.sp.jandira.triproom.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Landscape
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.triproom.R
import br.senai.sp.jandira.triproom.repository.ViagemRepository
import br.senai.sp.jandira.triproom.simplificarData
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme


@Composable
fun Home(navigationController: NavHostController?) {
    val viagens = ViagemRepository().listarTodasAsViagens(LocalContext.current)
    TripRoomTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFFFFFFF)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF6F6F6))
            ) {

                Card(
                    shape = RoundedCornerShape(0),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                ) {
                    Box(modifier = Modifier.align(Alignment.End)) {
                        Image(
                            modifier = Modifier
                                .fillMaxSize(),
                            painter = painterResource(id = R.drawable.paris_background),
                            contentDescription = "Background",
                            contentScale = ContentScale.FillWidth
                        )
                        Column(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Row(modifier = Modifier.align(Alignment.End)) {
                                Column(
                                    horizontalAlignment = Alignment.End,
                                    modifier = Modifier.padding(16.dp)
                                ) {
                                    Image(painter = painterResource(id = R.drawable.ellipse),
                                        contentDescription = "",
                                        Modifier
                                            .height(80.dp)
                                            .width(80.dp)
                                            .clickable { navigationController!!.navigate("login") }
                                    )
                                    Text(text = "Susanna Hoffs", color = Color.White)
                                }
                            }
                            Column(verticalArrangement = Arrangement.Bottom) {
                                Row {
                                    Icon(
                                        imageVector = Icons.Default.LocationOn,
                                        contentDescription = "Ícone de localizacao",
                                        tint = Color.White
                                    )
                                    Text(text = "You're in Paris", color = Color.White)
                                }
                                Text(
                                    text = "My Trips",
                                    color = Color.White,
                                    fontSize = 28.sp,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            }
                        }
                    }

                }
                Column(
                ) {
                    Column(

                    ) {
                        Text(
                            modifier = Modifier.padding(16.dp), text = "Categories"
                        )
                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp)
                        ) {
                            items(3) {
                                Card(
                                    modifier = Modifier
                                        .height(74.dp)
                                        .width(135.dp)
                                        .padding(start = 20.dp)
                                        .align(Alignment.CenterHorizontally)
                                        .align(Alignment.End),
                                    colors = CardDefaults.cardColors(Color(0xffCF06F0)),
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                                        Icon(
                                            imageVector = Icons.Default.Landscape,
                                            contentDescription = "Ícone Mountains",
                                            tint = Color.White
                                        )
                                        Text(text = "Mountain", color = Color.White)
                                    }
                                }

                            }
                        }
                    }
                    Card(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            modifier = Modifier
                                .background(
                                    Color(0xFFFFFFFF),
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .fillMaxWidth(),

                            placeholder = {
                                Text(
                                    text = "Search your destiny",
                                    color = Color.Gray
                                )
                            },
                            trailingIcon = {
                                IconButton(onClick = { }) {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = "Botão Buscar",
                                        tint = Color.Gray
                                    )
                                }
                            },

                            shape = RoundedCornerShape(16.dp)
                        )
                    }


                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Past Trips", fontSize = 19.sp, color = Color(0xff565454),
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        LazyColumn {
                            items(viagens) {
                                Card(Modifier.padding(bottom = 16.dp)) {
                                    Column(
                                        modifier = Modifier
                                            .background(
                                                color = Color(0xffffffff),
                                                shape = RoundedCornerShape(16.dp)
                                            )
                                    ) {
                                        Card(
                                            modifier = Modifier
                                                .height(120.dp)
                                                .padding(6.dp)
                                        ) {
                                            Image(
                                                modifier = Modifier
                                                    .fillMaxSize(),

                                                painter = if (it.imagem == null) painterResource(id = R.drawable.no_image) else it.imagem!!,
                                                contentDescription = "Background",
                                                contentScale = ContentScale.FillWidth
                                            )
                                        }

                                        Column(
                                            modifier = Modifier.padding(
                                                start = 8.dp,
                                                end = 8.dp
                                            )
                                        ) {
                                            Text(
                                                color = Color(0xffCF06F0),
                                                fontSize = 20.sp,
                                                text = "${it.destino}, ${it.data_partida.year}"
                                            )
                                            Text(
                                                color = Color(0xFFA09C9C),
                                                fontSize = 14.sp,
                                                lineHeight = 16.sp,
                                                text = it.descricao
                                            )
                                            Row(
                                                modifier = Modifier
                                                    .align(Alignment.End)
                                                    .padding(top = 16.dp, bottom = 16.dp)
                                            ) {

                                                Text(
                                                    color = Color(0xFFCF06F0),
                                                    fontSize = 12.sp,
                                                    text = simplificarData(
                                                        it.data_chegada,
                                                        it.data_partida
                                                    )
                                                )
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun homePreview() {
    TripRoomTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFFFFFFF)
        ) {
            Home(null)
        }
    }
}