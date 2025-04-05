package com.example.mercyapp

import android.net.Uri
import android.os.Bundle
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.mercyapp.ui.theme.MercyappTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class AddProductActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MercyappTheme {
                AddProductScreen()
            }
        }
    }
}

@Composable
fun AddProductScreen(){
    val imageUri = rememberSaveable() { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {uri:Uri?  ->uri?.let{imageUri.value=it}  }
    var productname by remember { mutableStateOf(value = "") }
    var productquantity by remember { mutableStateOf(value = "") }
    var productunitprice by remember { mutableStateOf(value = "") }
    var description by remember { mutableStateOf(value = "") }

    Column (modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment =  Alignment.CenterHorizontally){
        Text(
            text = "Add New Product",
            fontSize = 40.sp,
            color = androidx.compose.ui.graphics.Color.Magenta,

            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(androidx.compose.ui.graphics.Color.Cyan)
                .padding(20.dp)
                .fillMaxWidth()


        )
        Spacer(modifier = Modifier.height(10.dp))
        Card (shape = CircleShape,
              modifier = Modifier
              .padding(10.dp)
              .size(200.dp)){

            AsyncImage(model = imageUri.value ?:R.drawable.ic_person,
                       contentDescription = null,
                       contentScale = ContentScale.Crop,
                       modifier = Modifier.size(200.dp)
                       .clickable { launcher.launch("image/*")} )
        }
        Text(text = "Attach Product Image")
        OutlinedTextField(
            value = productname,
            onValueChange = { newProductname -> productname = newProductname },
            label = { Text(text = "Enter productname") },
            placeholder = { Text(text = "Please enter productname") },
            modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally))
        OutlinedTextField(
            value = productquantity,
            onValueChange = { newProductquantity -> productquantity = newProductquantity },
            label = { Text(text = "Enter productquantity") },
            placeholder = { Text(text = "Please enter productquantity") },
            modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally))
        OutlinedTextField(
            value = productunitprice,
            onValueChange = { newProductunitprice -> productunitprice = newProductunitprice },
            label = { Text(text = "Enter productunitprice") },
            placeholder = { Text(text = "Please enter productunitprice") },
            modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally))
        OutlinedTextField(
            value = description,
            onValueChange = { newDescription -> description = newDescription },
            label = { Text(text = "Brief Description") },
            placeholder = { Text(text = "Please enter Product Description") },
            modifier = Modifier.wrapContentWidth().align(Alignment.CenterHorizontally).height(150.dp),
            singleLine = false)
        Row (modifier = Modifier.fillMaxWidth(),
             horizontalArrangement = Arrangement.SpaceBetween       ){
            Button (onClick = {},
                colors = ButtonDefaults.buttonColors(Color.Black)) { Text(text = "Home") }
            Button(onClick = {},
                colors = ButtonDefaults.buttonColors(Color.Green)) { Text(text = "Save")}
        }



    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddProductScreenPreview() {
    AddProductScreen()
}
