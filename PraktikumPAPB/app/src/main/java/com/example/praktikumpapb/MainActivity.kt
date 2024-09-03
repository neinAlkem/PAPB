package com.example.praktikumpapb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.praktikumpapb.ui.theme.PraktikumPAPBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PraktikumPAPBTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        color =  Color.Black
    )
}

@Composable
fun TombolMasuk(onClick: () -> Unit) {
    FilledTonalButton(onClick = { onClick() }) {
        Text("Beli Saham")
    }
}

@Composable
fun ElevatedTombol(onClick: () -> Unit){
    ElevatedButton(onClick = { onClick() }) {
        Text("Elevated")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PraktikumPAPBTheme {
        Greeting("User")
    }
}

@Preview(showBackground = false)
@Composable
fun ButtonPreview() {
    PraktikumPAPBTheme {
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        )
        TombolMasuk(onClick = {})
    }
}

@Preview(showBackground = false)
@Composable
fun ElevatedTombolPreview() {
    PraktikumPAPBTheme {
        ElevatedTombol(onClick = {})
    }
}

@Preview(showBackground = false)
@Composable
fun ElevatedTombolPreview() {
    PraktikumPAPBTheme {
        ElevatedTombol(onClick = {})
    }
}