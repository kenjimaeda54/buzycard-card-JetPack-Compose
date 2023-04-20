package com.example.buzzycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buzzycard.ui.theme.BuzzyCardTheme
import com.example.buzzycard.ui.theme.Shapes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuzzyCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    //surface seria tipo o canvas, um container
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
           Card(modifier = Modifier
               .width(200.dp)
               .height(390.dp)
               .padding(12.dp),
                elevation = 4.dp,
                shape = RoundedCornerShape(10.dp)
               ) {
               //preciso determinar o verticalArraganment e o horizontal se não vai bugar column
               //pre um column pra ocupar CreateProfileImg e dividereciso d
               Column(modifier = Modifier.size(300.dp),
                      verticalArrangement = Arrangement.Top,
                      horizontalAlignment = Alignment.CenterHorizontally
                   ) {
                   CreateProfileImg()
                   Divider()
                   CreateTextDescriptionProfile()
               }

           }
    }
}

@Composable
private fun CreateTextDescriptionProfile() {
    //criei essa coluna pra possuir um alinhamento diferente de cima
    //acima esta alinhando no topo e centro, aqui sera alinhamento padrão esquerda
    Column(modifier = Modifier.padding(3.dp)) {
        Text(
            text = "Miles P",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primaryVariant
        )
        Text(
            text = "Android Compose Programer",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(3.dp)
        )
        Text(
            text = "@themilesCompose",
            style = MaterialTheme.typography.subtitle2
        )
    }
}

@Composable
private fun CreateProfileImg(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .padding(4.dp)
            .size(150.dp),
        border = BorderStroke(0.5.dp, color = Color.LightGray),
        shape = CircleShape,
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile image",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BuzzyCardTheme {
        CreateBizCard()
    }
}