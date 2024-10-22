package com.example.a511lasalleapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SettingsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Ícono circular del alumno
        Icon(
            imageVector = Icons.Default.Person, // Icono de persona
            contentDescription = "Ícono de perfil",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
            tint = MaterialTheme.colorScheme.primary // Ajusta el color según el tema
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Información del alumno
        Text(
            text = "Alejandro Paolo Escamilla Trujillo",
            style = MaterialTheme.typography.headlineSmall // Material 3 tipografía
        )
        Text(
            text = "Fecha de nacimiento: 15/03/2000",
            style = MaterialTheme.typography.bodyLarge // Texto normal
        )
        Text(
            text = "Correo: alejandro.escamilla@universidad.edu",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botón para cambiar contraseña
        Button(
            onClick = { navController.navigate("change_password") },
            modifier = Modifier.fillMaxWidth() // Para hacer el botón más grande y visualmente consistente
        ) {
            Text("Cambiar Contraseña")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para cambiar el tema
        Button(
            onClick = { navController.navigate("change_theme") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cambiar Tema")
        }
    }
}
