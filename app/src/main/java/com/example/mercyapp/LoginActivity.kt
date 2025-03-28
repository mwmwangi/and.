package com.example.mercyapp

import android.content.Intent
import android.os.Bundle
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import com.example.mercyapp.ui.theme.MercyappTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MercyappTheme {
                LoginScreen()

                }
            }
        }
    }


@Composable
fun LoginScreen(){
    var email by remember { mutableStateOf(value = "") }
    var password by remember { mutableStateOf(value = "") }
    val context = LocalContext.current
    Column (modifier = Modifier.fillMaxHeight().fillMaxWidth(), verticalArrangement = Arrangement.Center){
        Text(
            text = "Login Here!!",
            color = androidx.compose.ui.graphics.Color.Magenta,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            modifier = Modifier.background(Color.Cyan)
                .padding(20.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier.wrapContentHeight()
                .fillMaxWidth()
                .height(120.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { newEmail -> email = newEmail },
            label = { Text(text = "Enter email") },
            placeholder = { Text(text = "Please enter email") },
            modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally)
        )
        OutlinedTextField(
            value = password,
            onValueChange = { newPassword -> password = newPassword },
            label = { Text(text = "Enter password") },
            placeholder = { Text(text = "Please enter password") },
            modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally)
        )
        Button(
            onClick = {},
            modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                Color.Cyan
            )
        ) {
            Text(text = "Log In")
        }


        Text(text = buildAnnotatedString { append(" haven't registered yet?, Register here, ") }, modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally).clickable {
            val intent = Intent(context,MainActivity::class.java)
            context.startActivity(intent)
        })
        Text(
            text = "Forgot Password?",
            color = Color.Blue,
            modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally).clickable {
                // Navigate to password reset screen
            }
        )





    }

}
@Preview
@Composable
fun LoginActivityPreview(){
    LoginActivity()
}