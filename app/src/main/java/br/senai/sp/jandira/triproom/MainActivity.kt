package br.senai.sp.jandira.triproom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripRoomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    telaLogin()
                    telaSignIn()
                }
            }
        }
    }
}

@Composable
fun telaLogin() {
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
                    value = "teste@email.com",
                    onValueChange = {},
                    shape = RoundedCornerShape(16.dp),
                    label={ Text(text = "E-mail")},
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                        .padding(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xFFCF06F0),
                        focusedBorderColor = Color(0xFFCF06F0)
                    ),
                leadingIcon = {Icon(imageVector = Icons.Filled.Email, contentDescription = "", tint = Color(0xFFCF06F0)) }
                )
                OutlinedTextField(
                    value = "************",
                    shape = RoundedCornerShape(16.dp),
                    onValueChange = {},
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
            }

            Button(onClick = { /*TODO*/ },
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
                Text(text = "Sign up", color = Color(0xFFCF06F0), fontWeight = FontWeight.ExtraBold)
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

@Composable
fun telaSignIn(){
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
            Row (
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            )
            {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    Text(
                        text = "Sign Up", fontSize = 40.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFFCF06F0))
                    Text(text = "Create a new account", color = Color(0xFFA09C9C))
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            Box (
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()
            ){
                Box (
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .height(90.dp)
                        .width(90.dp)
                        .background(Color(0xFFF6F6F6), shape = RoundedCornerShape(360.dp))
                        .border(
                            BorderStroke(
                                2.dp, Brush.horizontalGradient(
                                    0.4f to Color(0xFFCF06F0),
                                    0.6f to Color.White,
                                    startX = 0.0f,
                                    endX = 300.0f
                                )
                            ),
                            shape = RoundedCornerShape(360.dp)
                        )
                ){
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "",
                        tint = Color(0xFFCF06F0),
                        modifier = Modifier
                            .height(60.dp)
                            .width(60.dp)
                        )
                }
                Image(
                    painter = painterResource(id = R.drawable.photo_add), contentDescription = "",
                    modifier = Modifier
                        .offset(30.dp,30.dp)
                        .height(30.dp)
                        .width(30.dp)
                )
            }
            Column {
                OutlinedTextField(
                    value = "Suzanna Hoffs",
                    onValueChange = {},
                    shape = RoundedCornerShape(16.dp),
                    label={ Text(text = "Username")},
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                        .padding(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xFFCF06F0),
                        focusedBorderColor = Color(0xFFCF06F0)
                    ),
                    leadingIcon = {Icon(imageVector = Icons.Filled.Person, contentDescription = "", tint = Color(0xFFCF06F0)) }
                )
                OutlinedTextField(
                    value = "99999-0987",
                    onValueChange = {},
                    shape = RoundedCornerShape(16.dp),
                    label={ Text(text = "Phone")},
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                        .padding(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xFFCF06F0),
                        focusedBorderColor = Color(0xFFCF06F0)
                    ),
                    leadingIcon = {Icon(imageVector = Icons.Filled.Phone, contentDescription = "", tint = Color(0xFFCF06F0)) }
                )

                OutlinedTextField(
                    value = "teste@email.com",
                    onValueChange = {},
                    shape = RoundedCornerShape(16.dp),
                    label={ Text(text = "E-mail")},
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                        .padding(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xFFCF06F0),
                        focusedBorderColor = Color(0xFFCF06F0)
                    ),
                leadingIcon = {Icon(imageVector = Icons.Filled.Email, contentDescription = "", tint = Color(0xFFCF06F0)) }
                )
                OutlinedTextField(
                    value = "************",
                    shape = RoundedCornerShape(16.dp),
                    onValueChange = {},
                    label = {Text(text = "Password")},
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                        .padding(16.dp)
                    ,colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = Color(0xFFCF06F0),
                        focusedBorderColor = Color(0xFFCF06F0)
                    ),
                    leadingIcon = {Icon(imageVector = Icons.Filled.Lock, contentDescription = "", tint = Color(0xFFCF06F0)) }
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                ){
                    Checkbox(checked = false, onCheckedChange = {}, colors = CheckboxDefaults.colors(
                        uncheckedColor = Color(0xFFCF06F0),
                        checkedColor = Color(0xFFCF06F0)

                    )
                    )
                    Text(text = "Over 18?")
                }
            }

            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color(0xffCF06F0)),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .padding(start = 50.dp, end=50.dp)
            ) {
                Text(
                    text = "CREATE ACCOUNT",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Row (modifier = Modifier
                .align(Alignment.End)
                .padding(16.dp)
            ){
                Text(text = "Already have an account? ", color = Color(0xFFA09C9C))
                Text(text = "Sign in", color = Color(0xFFCF06F0), fontWeight = FontWeight.ExtraBold)
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


//

//
//            Row (
//                modifier = Modifier
//                    .height(50.dp)
//                    .width(170.dp)
//                    .background(
//                        color = Color(0xFFCF06F0),
//                        shape = RoundedCornerShape(topEnd = 16.dp)
//                    )
//                    .align(Alignment.Start)
//            ){}
//        }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun telaLoginPreview() {
    TripRoomTheme {
        telaLogin()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun telaSignInPreview() {
    TripRoomTheme {
        telaSignIn()
    }
}