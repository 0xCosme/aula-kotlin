package com.aulaandroid.component

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulaandroid.component.ui.theme.ComponentTheme
import com.aulaandroid.component.ui.theme.space_grotesk_variable_fontwght
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BasicComponentScrem(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}





@Composable
fun BasicComponentScrem( modifier: Modifier = Modifier) {

    val textoInput = remember{ mutableStateOf("") }
    val quantidade = remember{ mutableStateOf("") }
    Column(
        modifier= modifier
            .fillMaxSize()
            .background(Color(239,247,207))
    ) {

        Text(
            text = "Aulas Android",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF30DC84),
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                //.background(Color.Magenta)
                .fillMaxWidth(),
            textAlign = TextAlign.End,
            letterSpacing = 4.sp
            //modifier = modifier.fillMaxWidth()
               // .background(Color(0xFFE8AF55))
        )
        Text(
            text = "Com Jetpack Compose",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0, 60, 220, 255),
            fontFamily = space_grotesk_variable_fontwght,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        TextField(
            modifier= Modifier.fillMaxWidth(),
            value= textoInput.value ,
            onValueChange = {novoValor ->
                Log.i("Teste", novoValor)
                textoInput.value = novoValor
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words
            ),
            //nomeia o compo e quando o usuario comeca a digitar o titulo sobe
            label = {
                Text("Nome e sobrenome")
            }

        )

        TextField(
            modifier= Modifier.fillMaxWidth(),
            value= quantidade.value ,
            onValueChange = {novoValor ->
                Log.i("Teste", novoValor)
                quantidade.value = novoValor
            },
            //abre teclado numerico
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            //texto que some ao digitar
            placeholder = {
                Text("Quantidade")
            }

        )

    AdroidEnem(
        modifier = Modifier.size(100.dp),
        color = Color.Black,
    )

    }

}



@Composable
fun AdroidEnem(
    modifier: Modifier = Modifier,
    color: Color
){

    Image(
            modifier = modifier,
            painter = painterResource(R.drawable.ic_launcher_foreground),
            colorFilter = ColorFilter.tint(color),
            contentDescription = "Adroid enem"
        )

}