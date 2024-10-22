package com.example.a511lasalleapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class Subject(
    val name: String,
    val average: Double
)

@Composable
fun GradesScreen(innerPadding: PaddingValues, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp), // Agregar padding adicional si es necesario
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        // Contenido de la pantalla
        Text("Alejandro Paolo Escamilla Trujillo", style = MaterialTheme.typography.headlineSmall)
        Text("Ingeniería en Sistemas, 5to semestre")
        Text("Promedio acumulado: 9.2")

        Spacer(modifier = Modifier.height(24.dp))

        // Lista de materias y sus promedios
        val subjects = listOf(
            "Matemáticas - Promedio: 9.0",
            "Programación - Promedio: 9.5",
            "Bases de datos - Promedio: 8.8"
        )

        subjects.forEach { subject ->
            Text(
                text = subject,
                modifier = Modifier.clickable {
                    navController.navigate("subject_details/${subject.split(" ")[0]}") // Navegar a los detalles de la materia
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

