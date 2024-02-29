package com.example.miuipetswidgets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.miuipetswidgets.ui.theme.MIUIPetsWidgetsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MIUIPetsWidgetsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppInterface()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppInterface(modifier: Modifier = Modifier) {
    Column {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = MaterialTheme.colorScheme.primaryContainer)
        ) {
            Text(
                text = "MIUI Pet Widget",
                textAlign = TextAlign.Center
            )
        }
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ImageAndButton(
                widgetName = stringResource(id = R.string.kitty_widget),
                imageId = R.drawable.kitty,
                modifier = modifier
                    .weight(1f)
                    .padding(5.dp)
            )

            ImageAndButton(
                widgetName = stringResource(id = R.string.doggy_widget),
                imageId = R.drawable.doggy,
                modifier = modifier
                    .weight(1f)
                    .padding(5.dp)
            )
        }
        About()
    }
}

@Composable
fun ImageAndButton(widgetName: String, imageId: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null
        )
        Button(onClick = { /*TODO */ }) {
            Row {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = stringResource(id = R.string.add))
                Text(text = widgetName)
            }
        }
    }
}

@Composable
fun About(modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        StringAndIcon(text = "Barahoyev Artyom", iconId = R.drawable.person)
        StringAndIcon(text = "https://github.com/minus72/MIUI_Pets_Widgets", iconId = R.drawable.github_mark)
        StringAndIcon(text = "2024", iconId = null)
    }
}

@Composable
fun StringAndIcon(text: String, iconId: Int?) {
    Row (
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        if (iconId != null){
            Icon(
                painter = painterResource(iconId),
                contentDescription = "Github",
                modifier = Modifier
                    .size(25.dp)
                    .padding(end = 5.dp)
            )
        }
        Text(text = text)
    }
}
