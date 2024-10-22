package com.example.a511lasalleapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SubjectDetailsScreen(subjectName: String, partials: List<Double>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        // Título con el nombre de la asignatura
        Text(
            text = "Detalles de $subjectName",
            style = MaterialTheme.typography.headlineMedium // Material 3 tipografía
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Mostramos los detalles de los parciales
        partials.forEachIndexed { index, grade ->
            Text(
                text = "Parcial ${index + 1}: $grade",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SubjectDetailsScreenPreview() {
    SubjectDetailsScreen(
        subjectName = "Matemáticas",
        partials = listOf(9.0, 8.5, 9.2) // Previsualización con datos de ejemplo
    )
}

