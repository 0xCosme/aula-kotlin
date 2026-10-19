package com.aulaandroid.atividade_05_quiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulaandroid.atividade_05_quiz.ui.theme.Atividade05quizTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Atividade05quizTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    telaFazendoQuiz(

                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun telaInicioQuiz(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(red = 94, green = 205, blue = 246)),
        horizontalAlignment = Alignment.CenterHorizontally, // Centraliza horizontalmente
        verticalArrangement = Arrangement.Center // Centraliza verticalmente

    ) {
        Image(
            painter = painterResource(R.drawable.quiz),
            contentDescription = "Logo app",
            modifier = Modifier

                .size(180.dp)
                .padding(vertical = 16.dp)

        )


        Spacer(modifier = Modifier.height(56.dp)) // Espaço vertical de 16.dp


        Text(
            text = "QUIZATRON 3000",
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(26.dp)) // Espaço vertical de 16.dp

        //BOTAO
        Button(
            onClick = {  },
            modifier = Modifier
                .width(260.dp)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(249,223,48),
                contentColor = Color.Black
            ),

            border = BorderStroke(2.dp, Color.Black), // Define a espessura e a cor da borda

            //modifica a forma do botrao
            shape = RoundedCornerShape(
                topStart = 30.dp ,
                topEnd = 30.dp,
                bottomStart = 30.dp,
                bottomEnd = 30.dp)

        ) {
            //adicao de icone

            Text("COMECAR!",fontSize = 30.sp)
        }
    }



}

@Composable
fun telaFazendoQuiz(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(red = 239, green = 153, blue = 208)),
        horizontalAlignment = Alignment.CenterHorizontally, // Centraliza horizontalmente
       // verticalArrangement = Arrangement.Center // Centraliza verticalmente

    ) {
        Spacer(modifier = Modifier.height(56.dp))
        Image(
            painter = painterResource(R.drawable.quiz),
            contentDescription = "Logo app",
            modifier = Modifier
                .size(120.dp)
                .padding(vertical = 16.dp)
        )
        Spacer(modifier = Modifier.height(56.dp))




        if (false) {

            //Card de progresso
            Card(
                modifier = Modifier
                    .width(200.dp)
                    .height(60.dp)
                //    .offset(y= (10).dp)
                ,
                colors = CardDefaults.cardColors(containerColor = Color.Green),
                elevation = CardDefaults.cardElevation(4.dp)

            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),

                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text("Pergunta 1 de 5", fontSize = 20.sp)
                }

            }
            Spacer(modifier = Modifier.height(20.dp))

            //CArd de questoes

            Card(
                modifier = Modifier
                    .width(350.dp)
                    .height(350.dp),
                elevation = CardDefaults.cardElevation(6.dp) // Aumentado um pouco para dar mais destaque
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp), // Espaçamento  nas bordas do Card
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {


                    Text(
                        text = "O que é uma MMU?",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                        //  .padding(vertical = 16.dp)
                    )


                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.spacedBy(12.dp) // Cria um espaçamento fixo de 12dp entre cada botão
                    ) {

                        Spacer(modifier = Modifier.height(20.dp))
                        // Opção A
                        Button(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(),// Botão estica para ocupar toda a largura disponível


                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.Black // Ajuste para a cor que preferir
                            ),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, Color.Gray)


                        ) {
                            Text(
                                text = "Componente que traduz endereços virtuais para físicos",
                                modifier = Modifier.fillMaxWidth(), // Faz o texto ocupar o botão inteiro
                                textAlign = TextAlign.Start // Alinha o texto à esquerda internamente
                            )
                        }

                        // Opção B
                        Button(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.Black // Ajuste para a cor que preferir
                            ),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, Color.Gray)

                        ) {
                            Text(
                                text = "É um vírus que ficou famoso em 2003",
                                modifier = Modifier.fillMaxWidth(), // Faz o texto ocupar o botão inteiro
                                textAlign = TextAlign.Start // Alinha o texto à esquerda internamente

                            )
                        }

                        // Opção C
                        Button(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.Black // Ajuste para a cor que preferir
                            ),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, Color.Gray)


                        ) {
                            Text(
                                text = "É a capital do Ceará",
                                modifier = Modifier.fillMaxWidth(), // Faz o texto ocupar o botão inteiro
                                textAlign = TextAlign.Start // Alinha o texto à esquerda internamente

                            )
                        }

                        // Opção D
                        Button(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.Black // Ajuste para a cor que preferir
                            ),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, Color.Gray)

                        ) {
                            Text(
                                text = "É o rio que atravessa a Geórgia",

                                modifier = Modifier.fillMaxWidth(), // Faz o texto ocupar o botão inteiro
                                textAlign = TextAlign.Start // Alinha o texto à esquerda internamente
                            )
                        }
                    }
                }
            }


        }




        if (true) {

            //Card de progresso
            Card(
                modifier = Modifier
                    .width(200.dp)
                    .height(60.dp)
                //    .offset(y= (10).dp)
                ,
                colors = CardDefaults.cardColors(containerColor = Color.Green),
                elevation = CardDefaults.cardElevation(4.dp)

            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),

                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text("Pergunta 2 de 5", fontSize = 20.sp)
                }

            }
            Spacer(modifier = Modifier.height(20.dp))

            //CArd de questoes

            Card(
                modifier = Modifier
                    .width(350.dp)
                    .height(350.dp),
                elevation = CardDefaults.cardElevation(6.dp) // Aumentado um pouco para dar mais destaque
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp), // Espaçamento  nas bordas do Card
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {


                    Text(
                        text = "O que é uma MMU?",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                        //  .padding(vertical = 16.dp)
                    )


                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.spacedBy(12.dp) // Cria um espaçamento fixo de 12dp entre cada botão
                    ) {

                        Spacer(modifier = Modifier.height(20.dp))
                        // Opção A
                        Button(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(),// Botão estica para ocupar toda a largura disponível


                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.Black // Ajuste para a cor que preferir
                            ),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, Color.Gray)


                        ) {
                            Text(
                                text = "Componente que traduz endereços virtuais para físicos",
                                modifier = Modifier.fillMaxWidth(), // Faz o texto ocupar o botão inteiro
                                textAlign = TextAlign.Start // Alinha o texto à esquerda internamente
                            )
                        }

                        // Opção B
                        Button(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.Black // Ajuste para a cor que preferir
                            ),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, Color.Gray)

                        ) {
                            Text(
                                text = "É um vírus que ficou famoso em 2003",
                                modifier = Modifier.fillMaxWidth(), // Faz o texto ocupar o botão inteiro
                                textAlign = TextAlign.Start // Alinha o texto à esquerda internamente

                            )
                        }

                        // Opção C
                        Button(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.Black // Ajuste para a cor que preferir
                            ),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, Color.Gray)


                        ) {
                            Text(
                                text = "É a capital do Ceará",
                                modifier = Modifier.fillMaxWidth(), // Faz o texto ocupar o botão inteiro
                                textAlign = TextAlign.Start // Alinha o texto à esquerda internamente

                            )
                        }

                        // Opção D
                        Button(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.Black // Ajuste para a cor que preferir
                            ),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, Color.Gray)

                        ) {
                            Text(
                                text = "É o rio que atravessa a Geórgia",

                                modifier = Modifier.fillMaxWidth(), // Faz o texto ocupar o botão inteiro
                                textAlign = TextAlign.Start // Alinha o texto à esquerda internamente
                            )
                        }
                    }
                }
            }


        }






    }
}