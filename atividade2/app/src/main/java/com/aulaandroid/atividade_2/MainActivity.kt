package com.aulaandroid.atividade_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsEndWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulaandroid.atividade_2.ui.theme.Atividade2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Atividade2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   // BasicComponentScrem(modifier = Modifier.padding(innerPadding))
                    TelaGameOuver(modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
}



@Composable
fun TelaGameOuver(modifier: Modifier = Modifier) {

        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
            contentAlignment = Alignment.Center

        ) {

            Box(){
                Row() {
                    imgInimigo(
                        modifier = Modifier.size(100.dp),
                    )
                    imgInimigo(
                        modifier = Modifier.size(100.dp),
                    )
                    imgInimigo(
                        modifier = Modifier.size(100.dp),
                    )
                    imgInimigo(
                        modifier = Modifier.size(100.dp),
                    )
                }

            }

            Text(
                text = "GAME OVER",
                fontSize = 60.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                //fontFamily = FontFamily,

                //modifier = Modifier.align(Alignment.Center)
            )
        }

}


@Composable
fun BasicComponentScrem( modifier: Modifier = Modifier) {

    Column(
        modifier= modifier
            .fillMaxSize()
            .background(Color(0, 0, 0))
        ,
        verticalArrangement = Arrangement.spacedBy(30.dp)


    ) {

        //LINHA REPSOPNSAVEL PELO SCORE
        Row(
            modifier = Modifier
                .fillMaxWidth()
                //.background(Color.Green)
            ,
            horizontalArrangement = Arrangement.SpaceBetween,

        ) {
            Text(
                text = "SCORE: 0000 ",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontFamily = FontFamily.Serif,
                modifier = Modifier
                    //.background(Color.Magenta)
                ,
                textAlign = TextAlign.Start,
                letterSpacing = 4.sp
                //modifier = modifier.fillMaxWidth()
                // .background(Color(0xFFE8AF55))
            )


            Row(
                modifier = Modifier
                //.background(Color.Yellow)
                        ,
                //alinha horizontalmente os itens dentro da roww
                verticalAlignment = Alignment.CenterVertically


                ) {
                Text(
                    text = "LIVES : ",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier
                       //.background(Color.Red)
                    ,
                    // .align(Alignment.End),
                    //.align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.End,
                    letterSpacing = 4.sp
                    //modifier = modifier.fillMaxWidth()
                    // .background(Color(0xFFE8AF55))
                )

                imgCoracao(
                    modifier = Modifier.size(15.dp),
                    color = Color.Red,
                )
                imgCoracao(
                    modifier = Modifier.size(15.dp),
                    color = Color.Red,
                )
                imgCoracao(
                    modifier = Modifier.size(15.dp),
                    color = Color.Red,
                )

            }



        }
        //LINHA COM OS INIMIGOS
        Row(
            modifier = Modifier
                //.background(Color.Blue)
                .fillMaxWidth(),


        ) {

            imgInimigo(
                modifier = Modifier.size(80.dp)
                //color = Color.Green,
            )
            imgInimigo(
                modifier = Modifier.size(80.dp)
                //color = Color.Green,
            )
            imgInimigo(
                modifier = Modifier.size(80.dp)
                //color = Color.Green,
            )
            imgInimigo(
                    modifier = Modifier.size(80.dp)
                    //color = Color.Green,
                    )
            imgInimigo(
                modifier = Modifier.size(80.dp)
                //color = Color.Green,
            )



        }


        //REPONSAVEL PELA PARTE DE BAIXO
        Column(
            modifier =  modifier

                .fillMaxWidth()
                .weight(1f)

                //.clip(RoundedCornerShape(40.dp))
                //.background(Color.Yellow)
                //.weight(0.1f)
                //.fillMaxWidth()
                //.align(Alignment.End)
            ,

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom

            //verticalArrangement = Arrangement.SpaceBetween
        ) {

            imgPlayer(
                modifier = Modifier.size(80.dp)
                //color = Color.Green,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "PRESS START",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }

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
            contentDescription = "Adroid enem" ,

        )

    }


@Composable
fun imgCoracao(
    modifier: Modifier = Modifier,
    color: Color
){

    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.coracao),
        colorFilter = ColorFilter.tint(color),
        contentDescription = "Adroid enem" ,

        )

}

@Composable
fun imgInimigo(
    modifier: Modifier = Modifier,
    //color: Color
){

    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.inimigo),
        //colorFilter = ColorFilter.tint(color),
        contentDescription = "Adroid enem" ,

        )

}

@Composable
fun imgPlayer(
    modifier: Modifier = Modifier,
    //color: Color
){

    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.player),
        //colorFilter = ColorFilter.tint(color),
        contentDescription = "Adroid enem" ,

        )

}