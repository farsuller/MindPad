package com.solodev.mindpad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.solodev.mindpad.ui.theme.MindPadTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MindPadTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "RENZ",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {

        Text(
            text = "Hello $name!",
            fontFamily = MaterialTheme.typography.displayLarge.fontFamily,
            fontSize = MaterialTheme.typography.displayLarge.fontSize,
            fontWeight = MaterialTheme.typography.displayLarge.fontWeight,
            modifier = modifier
        )
        Text(
            text = "Hello $name!",
            fontFamily = MaterialTheme.typography.displayMedium.fontFamily,
            fontSize = MaterialTheme.typography.displayMedium.fontSize,
            fontWeight = MaterialTheme.typography.displayMedium.fontWeight,
            modifier = modifier
        )

        Text(
            text = "Hello $name!",
            fontFamily = MaterialTheme.typography.displaySmall.fontFamily,
            fontSize = MaterialTheme.typography.displaySmall.fontSize,
            fontWeight = MaterialTheme.typography.displaySmall.fontWeight,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MindPadTheme {
        Greeting("RENZ")
    }
}