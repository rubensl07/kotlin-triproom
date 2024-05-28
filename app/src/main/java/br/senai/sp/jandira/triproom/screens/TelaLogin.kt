package br.senai.sp.jandira.triproom.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.triproom.R
import br.senai.sp.jandira.triproom.repository.UsuarioRepository
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme


@Composable
fun TelaLogin(navigationController: NavHostController?) {

    var ur= UsuarioRepository(LocalContext.current)

    var email = remember {
        mutableStateOf("")
    }
    var senha = remember {
        mutableStateOf("")
    }
    var isErrorState = remember {
        mutableStateOf(false)
    }

    var mensagemErroState = remember {
        mutableStateOf("")
    }

    TripRoomTheme{
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFFFFFFF)
        ){
            Column (
                modifier = Modifier.fillMaxSize(),
            ){
                Row (
                    modifier = Modifier
                        .height(40.dp)
                        .width(120.dp)
                        .background(
                            color = Color(0xFFCF06F0),
                            shape = RoundedCornerShape(bottomStart = 16.dp)
                        )
                        .align(Alignment.End)
                ){}
                Column {
                    Spacer(
                        modifier = Modifier
                            .height(100.dp))
                    Row {
                        Spacer(modifier = Modifier
                            .width(20.dp)
                        )
                        Column (){
                            Text(text = "Login", fontSize = 54.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFFCF06F0))
                            Text(text = "Please sign in to continue.", color = Color(0xFFA09C9C))
                        }
                    }
                    Column {
                        OutlinedTextField(
                            value = email.value,
                            onValueChange = {
                                email.value = it
                            },
                            shape = RoundedCornerShape(16.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                            label={ Text(text = "E-mail")},
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .fillMaxWidth()
                                .padding(16.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = Color(0xFFCF06F0),
                                focusedBorderColor = Color(0xFFCF06F0)
                            ),
                            leadingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription = "", tint = Color(0xFFCF06F0)) }
                        )
                        OutlinedTextField(
                            value = senha.value,
                            shape = RoundedCornerShape(16.dp),
                            onValueChange = {
                                senha.value = it
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            visualTransformation = PasswordVisualTransformation('*'),
                            label = {Text(text = "Password")},
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .fillMaxWidth()
                                .padding(16.dp)
                            ,colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = Color(0xFFCF06F0),
                                focusedBorderColor = Color(0xFFCF06F0)
                            ),

                            leadingIcon = {
                                Icon(imageVector = Icons.Filled.Lock, contentDescription = "", tint = Color(0xFFCF06F0))
                            }
                        )
                        Text(text = mensagemErroState.value, color = Color.Red)
                    }

                    Button(onClick = {

                        var (usuarioEncontrado, dadosUsuario) = ur.buscarUsuarioPeloEmailSenha(email.value,senha.value)

                        if(usuarioEncontrado){
                            if (navigationController != null) {
                                navigationController.navigate("home")
                            }
                        } else {
                            isErrorState.value = true
                            mensagemErroState.value = "Usuário ou senha inválidos!"
                        }
                    },
                        colors = ButtonDefaults.buttonColors(Color(0xffCF06F0)),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(16.dp)

                    ) {
                        Text(text = "SIGN IN", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
                        Spacer(modifier = Modifier.width(10.dp))
                        Image(
                            modifier = Modifier
                                .height(16.dp)
                                .width(16.dp)
                            ,
                            painter = painterResource(id = R.drawable.arrow),
                            contentDescription = "Seta para a direita"
                        )
                    }
                    Row (modifier = Modifier
                        .align(Alignment.End)
                        .padding(16.dp)
                    ){
                        Text(text = "Don't have an account? ", color = Color(0xFFA09C9C))
                        Text(modifier = Modifier.clickable {
                            if (navigationController != null) {
                                navigationController.navigate("signin")
                            }
                        }, text = "Sign up", color = Color(0xFFCF06F0), fontWeight = FontWeight.ExtraBold)
                    }
                }

                Row (
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .fillMaxSize()
                ){
                    Box (
                        modifier = Modifier
                            .height(40.dp)
                            .width(120.dp)
                            .background(
                                color = Color(0xFFCF06F0),
                                shape = RoundedCornerShape(topEnd = 16.dp)
                            ))
                }
            }

        }
    }

}
@Preview
@Composable
fun telaLoginPreview(){
    TripRoomTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF673AB7)
        ){
            TelaLogin(navigationController = null)
        }
    }
}