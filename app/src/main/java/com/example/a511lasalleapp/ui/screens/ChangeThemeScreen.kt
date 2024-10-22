package com.example.a511lasalleapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.a511lasalleapp.ui.theme._511LaSalleAppTheme

@Composable
fun ChangeThemeScreen(isDarkTheme: MutableState<Boolean>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título
        Text(
            text = "Cambiar Tema",
            style = MaterialTheme.typography.headlineSmall // Material 3 tipografía
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Descripción para seleccionar el tema
        Text(text = "Selecciona el tema:")

        Spacer(modifier = Modifier.height(16.dp))

        // Switch para cambiar entre tema claro y oscuro
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Claro")
            Spacer(modifier = Modifier.width(8.dp))
            Switch(
                checked = isDarkTheme.value,
                onCheckedChange = { isChecked ->
                    isDarkTheme.value = isChecked
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Oscuro")
        }
    }
}

@Composable
fun ThemeSwitcherContent() {
    // Estado que controla si el tema es oscuro o no
    val isDarkTheme = remember { mutableStateOf(false) }

    // Aplicar el tema dinámicamente
    _511LaSalleAppTheme(darkTheme = isDarkTheme.value) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ChangeThemeScreen(isDarkTheme = isDarkTheme)
        }
    }
}
