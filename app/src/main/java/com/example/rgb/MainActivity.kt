package com.example.rgb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.rgb.ui.theme.RGBTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RGBTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    colorChnager()
                }
            }
        }
    }
}


@Composable
fun colorChnager(){

    var minRange by remember { mutableStateOf(0) }
    var maxRange by remember { mutableStateOf(255) }
    var sliderValue1 by remember { mutableStateOf(255) }
    var sliderValue2 by remember { mutableStateOf(255) }
    var sliderValue3 by remember { mutableStateOf(255) }

    var red by remember { mutableStateOf(255) }
    var green by remember { mutableStateOf(255) }
    var blue  by remember { mutableStateOf(255) }

    var backgroundColor by remember { mutableStateOf( Color (sliderValue1.toInt(), sliderValue2.toInt(), sliderValue3.toInt() ))}


    Card(
        modifier = Modifier
            .fillMaxSize()
//            .padding(16.dp)
            .background(backgroundColor)

    ) {
        Column(
            modifier = Modifier.fillMaxSize().background(backgroundColor),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text("RGB Changer", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Adjust RGB values to change the background color")
            Spacer(modifier = Modifier.height(16.dp))
            Slider(
                value = sliderValue1.toFloat(),
                onValueChange = { newValue -> sliderValue1 = newValue.toInt()
                                  backgroundColor = Color(sliderValue1.toInt(), sliderValue2.toInt(), sliderValue3.toInt())},
                valueRange = minRange.toFloat()..maxRange.toFloat()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Slider(
                value = sliderValue2.toFloat(),
                onValueChange = { newValue -> sliderValue2 = newValue.toInt()
                                  backgroundColor = Color(sliderValue1.toInt(), sliderValue2.toInt(), sliderValue3.toInt())},
                valueRange = minRange.toFloat()..maxRange.toFloat()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Slider(
                value = sliderValue3.toFloat(),
                onValueChange = { newValue -> sliderValue3 = newValue.toInt()
                        backgroundColor =
                        Color(sliderValue1.toInt(), sliderValue2.toInt(), sliderValue3.toInt())
                                },
                valueRange = minRange.toFloat()..maxRange.toFloat(),


                )

            Button(
                onClick = {
                    sliderValue1 = 255
                    sliderValue2 = 255
                    sliderValue3 = 255
                    backgroundColor = Color(sliderValue1.toInt(), sliderValue2.toInt(), sliderValue3.toInt())

                },
                modifier = Modifier.padding(8.dp)

            ) { Text("Reset") }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RGBTheme {
        colorChnager()
    }
}