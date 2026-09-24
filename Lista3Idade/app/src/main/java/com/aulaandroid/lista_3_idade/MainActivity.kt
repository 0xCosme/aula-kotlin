package com.aulaandroid.lista_3_idade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
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

    var idade by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center


    ) { //comeco dabox


        Column(
        ) {//comeco da colum

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center, // Centraliza horizontalmente
                //verticalAlignment = Alignment.CenterVertically // centraliza verticalmente
            ) {// linha com titulo
                Text("Quala sua idade ?")
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
                Text(""+idade)

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) { //linhas com os botoes
                Button(
                    onClick = { idade =idade-1},
                    shape = RectangleShape //  quadrado
                ) {
                    Text("-")
                }

                Button(
                    onClick = { idade =idade+1},
                    shape = RectangleShape //  quadrado
                ) {
                    Text("+")
                }

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {//linha com o resultado
                if (idade>=18){
                    Text("Voce e MAIOR de iddade")
                }else{Text("Voce e MENOR de idade")}
            }

        }//fim da collum


    }//fim da box
}

