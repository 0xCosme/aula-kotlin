package com.aulaAndroid.hello

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aulaAndroid.hello.ui.theme.HelloTheme
import org.intellij.lang.annotations.JdkConstants

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LayoutScrem(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun LayoutScrem(modifier: Modifier = Modifier) {
    Column(

        modifier= modifier.background(Color.Green)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Column(
            modifier =  modifier
                .clip(RoundedCornerShape(40.dp))
                .background(Color.Yellow)
                .weight(1f)
                .fillMaxWidth()
                ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Column(
                modifier =  modifier
                .clip(RoundedCornerShape(40.dp))
                .background(Color.Blue)
                .weight(1f)

            ) {
                Text("tetando")
            }
            Text("texto1")
            Text("texto2")
            Text("texto3")
        }
        // um na frente do outro
        Row(
            modifier =  modifier
                .clip(RoundedCornerShape(40.dp))
                .background(Color.Gray)
                .weight(1f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween


        ) {
            Text("texto4")
            Text("texto5")
            Text("texto6")
        }
    }
}
