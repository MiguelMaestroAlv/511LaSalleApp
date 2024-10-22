package com.example.a511lasalleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.a511lasalleapp.models.BottomNavigationItem
import com.example.a511lasalleapp.ui.screens.*
import com.example.a511lasalleapp.ui.theme._511LaSalleAppTheme
import com.example.a511lasalleapp.utils.Screens
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            var selectedItem by rememberSaveable { mutableIntStateOf(0) }
            val isDarkTheme = rememberSaveable { mutableStateOf(false) } // Estado del tema

            _511LaSalleAppTheme(darkTheme = isDarkTheme.value) {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        AnimatedNavigationBar(
                            selectedIndex = selectedItem,
                            modifier = Modifier.height(90.dp),
                            barColor = MaterialTheme.colorScheme.primary,
                            cornerRadius = shapeCornerRadius(cornerRadius = 34.dp)
                        ) {
                            BottomNavigationItem.items.forEachIndexed { index, bottomNavigationItem ->
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .clickable {
                                            selectedItem = index
                                            navController.navigate(bottomNavigationItem.route)
                                        },
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Icon(
                                        imageVector = bottomNavigationItem.icon,
                                        contentDescription = bottomNavigationItem.title,
                                        tint = if (selectedItem == index) MaterialTheme.colorScheme.onPrimary
                                        else MaterialTheme.colorScheme.onPrimary.copy(
                                            alpha = 0.5f
                                        ),
                                        modifier = Modifier.size(26.dp)
                                    )
                                    Text(
                                        bottomNavigationItem.title,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = if (selectedItem == index) MaterialTheme.colorScheme.onPrimary
                                        else MaterialTheme.colorScheme.onPrimary.copy(
                                            alpha = 0.5f
                                        ),
                                    )
                                }
                            }

                        }
                    }
                ) { innerPadding ->

                    NavHost(navController = navController, startDestination = Screens.Home.route) {
                        // Pantallas actuales
                        composable(route = Screens.Home.route) {
                            HomeScreen(innerPadding = innerPadding, navController = navController)
                        }
                        composable(route = Screens.Grades.route) {
                            GradesScreen(innerPadding = innerPadding, navController = navController)
                        }
                        composable(route = Screens.Calendar.route) {
                            CalendarScreen(innerPadding = innerPadding)
                        }
                        composable(route = Screens.Settings.route) {
                            SettingsScreen(navController = navController)
                        }
                        composable(
                            route = Screens.NewsDetail.route + "/{newsId}",
                            arguments = listOf(navArgument("newsId") { type = NavType.IntType })
                        ) {
                            val newsId = it.arguments?.getInt("newsId") ?: 0
                            NewsDetailScreen(innerPadding = innerPadding, newsId = newsId)
                        }

                        // Nuevas pantallas añadidas
                        composable(route = "change_password") {
                            ChangePasswordScreen()
                        }
                        composable(route = "change_theme") {
                            ChangeThemeScreen(isDarkTheme = isDarkTheme)
                        }
                        composable(route = "subject_details/{subjectName}",
                            arguments = listOf(navArgument("subjectName") { type = NavType.StringType })
                        ) { backStackEntry ->
                            val subjectName = backStackEntry.arguments?.getString("subjectName") ?: ""
                            val subjects = listOf(9.0, 8.5, 9.2) // Ejemplo de parciales
                            SubjectDetailsScreen(subjectName = subjectName, partials = subjects)
                        }
                        composable(route = "payments") {
                            PaymentsScreen()
                        }
                    }
                }
            }
        }
    }
}

