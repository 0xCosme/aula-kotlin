package com.aulaandroid.component

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Outline
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
    var textoInputRefatorado by remember { mutableStateOf("")  }
    val quantidade = remember{ mutableStateOf("") }




    //VARIAVEI DE ESTADO

    var email by remember { mutableStateOf("") }

    var kotlin by remember { mutableStateOf(false) }
    var teste by remember { mutableStateOf(false) }
    var dois by remember { mutableStateOf(false) }
    var sistemaSelecionado by remember { mutableStateOf(0) }



    var corDoFundo by remember { mutableStateOf(Color(239, 247, 207)) }


    var favoritado by remember { mutableStateOf(false) }


    Column(
        modifier= modifier
            .fillMaxSize()
            .background(corDoFundo)
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

            value= textoInputRefatorado ,
            onValueChange = {novoValor ->
                Log.i("Teste", novoValor)
                textoInputRefatorado = novoValor
            },
            singleLine = true,// limita a ter uma linha apenas
            /*
            value= textoInput.value ,
            onValueChange = {novoValor ->
                Log.i("Teste", novoValor)
                textoInput.value = novoValor
            },

             */
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words
            ),
            //nomeia o compo e quando o usuario comeca a digitar o titulo sobe
            label = {
                Text("Nome e sobrenome")
            },
            /*
            trailingIcon = {

                Icon(
                    imageVector = Icons.Default
                    contentDescripion
                    tint= color.Blsc
                )
            }
            */
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
            },
            singleLine = true,// limita a ter uma linha apenas

            //MUDA a cor do texto
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Blue,
                unfocusedTextColor  = Color.Red,
                unfocusedPlaceholderColor  = Color.Magenta,
            )

        )


        //adiciona o espaco entre campos
        Spacer(modifier = Modifier.height(16.dp))


        //campo de texto cresce infinitamente
        OutlinedTextField(
            value = email,
            onValueChange = { email = it},
            singleLine = true,// limita a ter uma linha apenas
            placeholder = {
                Text("EMAIL")
            },

            modifier= Modifier.fillMaxWidth(),
            label = {
                Text("Digite seu emial")
            },
            //arredonda as bordas
            shape = RoundedCornerShape(
                topStart = 32.dp,
                bottomEnd = 32.dp
            ),
            //muda a cor do campo das bordas se ta selecionado fica de umna cor se nao ta fica de outra
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Red
            ),


        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = kotlin,
                onCheckedChange = { kotlin = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red

                )
            )
            Text("kotlin")

        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = teste,
                onCheckedChange = {teste = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red

                )
            )
            Text("teste")

        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = dois,
                onCheckedChange = {dois = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red

                )
            )
            Text("dois")

        }

        Row(verticalAlignment = Alignment.CenterVertically) {

            RadioButton(
                selected = sistemaSelecionado==0,
                onClick = {sistemaSelecionado=0}
            )

            Text("Mac")

        }

        Row(verticalAlignment = Alignment.CenterVertically) {

            RadioButton(
                selected = sistemaSelecionado ==1,
                onClick = {sistemaSelecionado = 1}
            )

            Text("win")

        }
        Row(verticalAlignment = Alignment.CenterVertically) {

            RadioButton(
                //poderia ser string no lugar de numero
                selected = sistemaSelecionado ==2,
                onClick = {sistemaSelecionado =2}
            )

            Text("linux")

        }

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        )
        {
            Button(
                onClick = {
                    corDoFundo = Color.Cyan
                },

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green,
                    contentColor = Color.Black
                ),

                //espessura da borda
                border = BorderStroke(4.dp,Color.Red),
                //modifica a forma do botrao
                shape = RoundedCornerShape(topEnd = 11.dp, bottomStart = 12.dp)
            ) {
                //adicao de icone
                Icon(imageVector = Icons.Default.Star, contentDescription = "estrela")
                Text("crica")
            }

            //botao redondo
            OutlinedButton(
                onClick = {corDoFundo = Color.Transparent},

            ) {
                Text("Redonfo buton")
            }

        }
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {


            if (favoritado){
                Icon(
                    modifier = Modifier
                        .size(40.dp)
                        .clickable{favoritado = false} ,
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "favorite"
            )
            }else{
                Icon(
                    modifier = Modifier
                        .size(40.dp)
                        .clickable{favoritado = true},
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "favorite"
                )
            }
        }




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