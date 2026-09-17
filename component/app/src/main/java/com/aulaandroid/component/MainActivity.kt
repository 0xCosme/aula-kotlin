package com.aulaandroid.component

import android.os.Bundle
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulaandroid.component.ui.theme.ComponentTheme
import com.aulaandroid.component.ui.theme.space_grotesk_variable_fontwght

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