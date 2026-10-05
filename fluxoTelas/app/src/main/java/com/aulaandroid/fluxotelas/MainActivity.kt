package com.aulaandroid.fluxotelas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aulaandroid.fluxotelas.telas.LoginTela
import com.aulaandroid.fluxotelas.telas.MenuTela
import com.aulaandroid.fluxotelas.telas.PedidosTela
import com.aulaandroid.fluxotelas.telas.PerfilTela
import com.aulaandroid.fluxotelas.ui.theme.FluxoTelasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FluxoTelasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navControler = rememberNavController()

                    NavHost(
                        navController = navControler,
                        startDestination = "Login"
                    ) {
                        composable(route = "Login") {LoginTela(modifier = Modifier.padding(innerPadding))  }

                        composable(route = "Menu") { MenuTela(modifier = Modifier.padding(innerPadding))  }

                        composable(route = "Perfil") {PerfilTela(modifier = Modifier.padding(innerPadding))  }

                        composable(route = "Pedidos") { PedidosTela(modifier = Modifier.padding(innerPadding))  }
                    }



                }
            }
        }
    }
}


