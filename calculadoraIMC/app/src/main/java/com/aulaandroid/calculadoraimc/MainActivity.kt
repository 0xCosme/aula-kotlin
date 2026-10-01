package com.aulaandroid.calculadoraimc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulaandroid.calculadoraimc.ui.theme.CalculadoraIMCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraIMCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    IMCTela(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun IMCTela(modifier: Modifier = Modifier) {

    //var azul by remember { mutableStateOf(Color(239,156,213)) }
    var azul = colorResource(id = R.color.cor_app)
    var altura by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var cardColor by remember { mutableStateOf(Color.White) }


    var imcText by remember { mutableStateOf("") }
    var classificacao by remember { mutableStateOf("") }

    var isVisible by remember { mutableStateOf(false) }





    Column(
        modifier =  modifier
            .fillMaxSize()

    ) {

        //HEADER
        Column(
            modifier =  Modifier
                .fillMaxWidth()
                .height(160.dp)
                .background(color = azul),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painter = painterResource(R.drawable.bmi),
                contentDescription = "Logo app",
                modifier = Modifier

                    .size(80.dp)
                    .padding(vertical = 16.dp)

            )

            Text(
                text = "Calculadora IMC",
                fontSize = 24.sp,

                fontWeight = FontWeight.Bold,
                color = Color.White
            )



        }

        //FORMULARIO
        Column(
            modifier =  Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp) ,

            ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .offset(y= (-30).dp) ,
                colors = CardDefaults.cardColors(containerColor = Color(0xfff9f6f6)),
                elevation = CardDefaults.cardElevation(4.dp)


            ) {

                Column(

                    modifier = Modifier
                         .fillMaxSize()
                        .padding(horizontal = 30.dp, vertical = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                    //verticalArrangement = Arrangement.Center
                ) {

                    Text("Seus dados")

                    //campo de texto cresce infinitamente
                    OutlinedTextField(
                        value = altura,
                        onValueChange = { novoValor ->altura = novoValor },
                        singleLine = true,// limita a ter uma linha apenas
                        placeholder = {
                            Text("digite sua altura Ex:160")
                        },

                        modifier= Modifier.fillMaxWidth(),
                        label = {

                            Text("altura")
                        },

                        shape = RoundedCornerShape(
                            topStart = 10.dp,
                            topEnd = 10.dp,
                            bottomEnd = 10.dp,
                            bottomStart = 10.dp
                        ),
                        //muda a cor do campo das bordas se ta selecionado fica de umna cor se nao ta fica de outra
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = azul,
                            unfocusedBorderColor = azul
                        ),

                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),




                        )


                    //CAPO PESO
                    OutlinedTextField(
                        value = peso,
                        onValueChange = {novoValor ->peso = novoValor  },

                        singleLine = true,// limita a ter uma linha apenas
                        placeholder = {
                            Text("digite o seu Peso Ex:50kg")
                        },

                        modifier= Modifier
                            .fillMaxWidth()
                            //.height(40.dp)
                        ,
                        label = {

                            Text("Peso")
                        },

                        shape = RoundedCornerShape(
                            topStart = 10.dp,
                            topEnd = 10.dp,
                            bottomEnd = 10.dp,
                            bottomStart = 10.dp
                        ),
                        //muda a cor do campo das bordas se ta selecionado fica de umna cor se nao ta fica de outra
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = azul,
                            unfocusedBorderColor = azul
                        ),

                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        ),




                        )


                    //BOTAO
                    Button(
                        onClick = {

                            val imc =calculoIMc(peso,altura)

                            imcText =  imc.toString().take(4)


                            cardColor = corCardFunc(imc)

                            classificacao =classificarImc(imc)
                            isVisible= true



                        },
                        modifier = Modifier.fillMaxWidth(),

                        colors = ButtonDefaults.buttonColors(
                            containerColor = azul,
                            contentColor = Color.White
                        ),


                        //modifica a forma do botrao
                        shape = RoundedCornerShape(topStart = 20.dp ,
                            topEnd = 20.dp,
                            bottomStart = 20.dp,
                            bottomEnd = 20.dp)

                    ) {
                        //adicao de icone

                        Text("CALCULAR")
                    }


                }




            }

            if (isVisible){
                //CARD RESUT
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                    //    .offset(y= (10).dp)
                    ,
                    colors = CardDefaults.cardColors(containerColor = cardColor),
                    elevation = CardDefaults.cardElevation(4.dp)

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                        ,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Text("${imcText}   ${classificacao}")

                    }


                }
            }

        }

    }
}

fun calculoIMc(peso: String,altura: String): Double{

    // 1. Converta os textos para Float com segurança (evita crash se o campo estiver vazio)
    var alturaFloat = altura.toDouble()
    alturaFloat = (alturaFloat/100)
    val pesoFloat = peso.toDouble()


    val resultadoImc = (pesoFloat) / (alturaFloat * alturaFloat) // Formula correta: Peso / (Altura * Altura)

    return resultadoImc
}

fun corCardFunc(imc: Double): Color{


    return when {
        imc in 18.5..24.9 ->  Color.Green
        imc in 25.0..29.9 -> Color.Yellow
        else -> Color.Red
    }
}

fun classificarImc(imc: Double): String {
    return when {
        imc < 18.5 -> "Abaixo do peso"
        imc in 18.5..24.9 -> "Peso ideal"
        imc in 25.0..29.9 -> "levemente acima do peso"
        imc in 30.0..34.9 -> "Obesidade Grau 1"
        imc in 35.0..39.9 -> "Obesidade Grau 2"
        imc >= 40.0 -> "Obesidade Grau 3"
        else -> "Valor inválido"
    }
}




