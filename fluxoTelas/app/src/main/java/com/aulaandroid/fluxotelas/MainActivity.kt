package com.aulaandroid.fluxotelas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                        startDestination = "Login",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(1000)
                            )+ fadeOut(animationSpec = tween(1000))
                        },
                        enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                                animationSpec = tween(1000)
                            )
                        }
                    ) {
                        composable(route = "Login") {LoginTela(modifier = Modifier.padding(innerPadding),navControler)  }

                        composable(route = "Menu") { MenuTela(modifier = Modifier.padding(innerPadding), navControler)  }

                        composable(route = "Perfil/{nome}/{idade}",
                            arguments = listOf(
                                navArgument(name = "nome"){
                                    type= NavType.StringType
                                },
                                navArgument(name = "idade"){
                                    type= NavType.IntType
                                }
                            )
                        ) {
                            val nome = it.arguments?.getString("nome")
                            val idade = it.arguments?.getInt("idade")



                            PerfilTela(modifier = Modifier.padding(innerPadding)
                                ,navControler
                                , nome = nome!!
                                , idade = idade!!)
                        }

                        composable(
                            route = "Pedidos?numeroPedidos={numeropedido}"
                            , arguments = listOf(
                                navArgument(name = "numeroPedido"){
                                    defaultValue="sem pedidos"
                                }
                            )
                        ) {
                            val numeroPedido = it.arguments?.getString("numeroPedido")
                            PedidosTela(modifier = Modifier.padding(innerPadding)
                            , navControler, pedidos = numeroPedido!!)
                        }
                    }



                }
            }
        }
    }
}


