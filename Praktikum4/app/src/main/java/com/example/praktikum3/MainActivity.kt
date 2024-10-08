package com.example.praktikum3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.example.praktikum3.ui.theme.Praktikum3Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Praktikum3Theme {
                MainScreen()
            }
        }
    }
}

//@Composable
//fun NameTextField (){
//    var text by remember {
//        mutableStateOf(TextFieldValue(""))}
//    return OutlinedTextField(
//        value = text ,
//        leadingIcon = { Icon(imageVector = Icons.Default.Person,
//            contentDescription = "PersonIcon" )},
//        onValueChange = {
//            text = it
//        },
//        label = { Text(text = "Name")},
//        placeholder = { Text(text = "Input Your Full Name")},
//        )
//}
//
//@Composable
//fun NIMTextField (){
//    var text by remember {
//        mutableStateOf(TextFieldValue(""))}
//    return OutlinedTextField(
//        value = text ,
//        leadingIcon = { Icon(imageVector = Icons.Default.Star,
//            contentDescription = "PersonIcon" )},
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//        onValueChange = {
//            text = it
//        },
//        label = { Text(text = "Name")},
//        placeholder = { Text(text = "Input Your Full Name")},
//    )
//}
//
//@Composable
//fun EnterButton(){
//    Button(onClick = {
//
//    }, elevation = ButtonDefaults.buttonElevation(
//        defaultElevation = 10.dp,
//        pressedElevation = 15.dp,
//        disabledElevation = 0.dp
//    )) {
//        Text(text = "Show Input")
//    }
//}
//
//
//@Composable
//fun MainScreen() {
//    var name by remember { mutableStateOf(TextFieldValue("")) }
//    var nim by remember { mutableStateOf(TextFieldValue("")) }
//    var showInput by remember { mutableStateOf("") }
//
//    Scaffold(
//        content = {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(16.dp),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                NameTextField(
//                    Text = name,
//                    onValueChange = { name = it }
//                )
//                Spacer(modifier = Modifier.height(16.dp))
//                NIMTextField(
//                    text = nim,
//                    onValueChange = { nim = it }
//                )
//                Spacer(modifier = Modifier.height(16.dp))
//                EnterButton(
//                    name = name.text,
//                    nim = nim.text,
//                    onShowInput = {
//                        showInput = "Name: ${name.text}, NIM: ${nim.text}"
//                    }
//                )
//                Spacer(modifier = Modifier.height(16.dp))
//                Text(
//                    text = showInput,
//                    fontSize = 18.sp
//                )
//            }
//        }
//    )
//}

@Composable
fun MainScreen() {
    var nama by remember { mutableStateOf("") }
    var NIM by remember { mutableStateOf("") }
    var showInput by remember { mutableStateOf("") }
    val buttonColor = if (nama.isNotEmpty() && NIM.isNotEmpty() && NIM.isDigitsOnly()) Color.Blue else Color.Gray
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = showInput, modifier = Modifier.padding(bottom = 16.dp))
        OutlinedTextField(
            value = nama,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "PersonIcon"
                )
            },
            onValueChange = { nama = it },
            label = { Text("Input Your Name") },
            placeholder = { Text(text = "Enter Your Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            shape = RoundedCornerShape(8.dp),
        )

        OutlinedTextField(
            value = NIM,
            leadingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = "NIMIcon") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { NIM = it },
            label = { Text("Input Your NIM") },
            placeholder = { Text(text = "Enter Your NIM") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            shape = RoundedCornerShape(8.dp),
        )

        Button(
            onClick = {
                if (nama.isNotEmpty() && NIM.isNotEmpty() && NIM.isDigitsOnly()) {
                    showInput = "Name : $nama\nNIM    : $NIM"
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
            shape = RoundedCornerShape(20.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 15.dp,
                disabledElevation = 0.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text("Show Name and NIM", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Praktikum3Theme {
        MainScreen()
    }
}
