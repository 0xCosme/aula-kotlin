package com.aulaandroid.lista_3_idade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulaandroid.lista_3_idade.ui.theme.Lista3IdadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lista3IdadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    telaInicial()
                }
            }
        }
    }
}

@Composable
fun telaInicial() {

    var idade by remember { mutableStateOf(1) }

    var botaoMais by remember { mutableStateOf(true) }
    var botaoMenos by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center


    ) { //comeco dabox


        Column(

            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {//comeco da colum

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center, // Centraliza horizontalmente

                //verticalAlignment = Alignment.CenterVertically // centraliza verticalmente
            ) {// linha com titulo
                Text("Quala sua idade ?", color = Color.Blue, fontSize = 30.sp)
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {// linha coma descricao
                Text("Aperte os Botoes para informar a sua idade ")
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,

            ) {// linha com a idade
                Text("${idade}",fontSize = 25.sp)

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center


            ) { //linhas com os botoes
                Button(
                    onClick = { idade =idade-1},
                    shape = RectangleShape, //  quadrado
                    enabled = botaoMenos,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue, //
                        //contentColor = Color.White
                        )

                    ) {
                    Text("-", fontSize = 20.sp)
                }

                Spacer(modifier = Modifier.width(15.dp))


                Button(
                    onClick = { idade =idade+1},
                    shape = RectangleShape, //  quadrado
                    enabled = botaoMais,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue, //
                        //contentColor = Color.White
                    )

                ) {
                    Text("+", fontSize = 20.sp)
                }

                if (idade >= 180){
                    botaoMais = false
                }else{ botaoMais = true}

                if (idade < 1){
                    botaoMenos = false
                }else{ botaoMenos = true}

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {//linha com o resultado
                if (idade>=18){
                    Text("Voce e MAIOR de iddade", color = Color.Blue, fontSize = 30.sp)
                }else{Text("Voce e MENOR de idade", color = Color.Blue, fontSize = 30.sp)}
            }

        }//fim da collum


    }//fim da box
}

