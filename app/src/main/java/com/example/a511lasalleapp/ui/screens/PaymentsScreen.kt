package com.example.a511lasalleapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PaymentsScreen() {
    val payments = listOf(
        "Enero - Pagado",
        "Febrero - Pendiente",
        "Marzo - Pagado",
        "Abril - Pendiente"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        payments.forEach { payment ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp), // Mejora el espaciado
                verticalAlignment = Alignment.CenterVertically
            ) {
                val icon = if (payment.contains("Pagado")) Icons.Default.Check else Icons.Default.Warning
                Icon(
                    icon,
                    contentDescription = if (payment.contains("Pagado")) "Pagado" else "Pendiente", // Mejora la accesibilidad
                    modifier = Modifier.size(24.dp) // Ajusta el tamaño del ícono
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(payment)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentsScreenPreview() {
    PaymentsScreen()
}

