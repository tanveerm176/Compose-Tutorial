package com.example.composetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme


//Tutorial from https://developer.android.com/jetpack/compose/tutorial
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*MessageCard("Android")*/
            /*
            //Used with Message data class defined below
            MessageCard(msg = Message("Android", "JetPackCompose"))
            */

            //using provided theme to style the message
            ComposeTutorialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MessageCard(msg = Message("Muhammad Tanveer", "Capstone Project"))
                }
            }


        }
    }
}


/*//func passed in name and configs text elmnt
@Composable
fun MessageCard(name: String){
    Text(text = "Hello, $name!")
}*/

//create a class that holds author and body to be displayed
data class Message(val author: String, val body: String)


/*
//Display without column
@Composable
fun MessageCard(msg: Message){
    Text(text = msg.author)
    Text(text = msg.body)
}*/

/*//Display with Column
@Composable
fun MessageCard(msg: Message){
    Column {
        Text(text = msg.author)
        Text(text = msg.body)
    }
}*/

/*//Display with Row Img and Column text with no layout config
@Composable
fun MessageCard(msg: Message){
    Row{
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Profile Picture"
        )
    }

    Column {
        Text(text = msg.author)
        Text(text = msg.body)
    }
}*/

/*//Display with Row Img and Column text with layout padding and config
@Composable
fun MessageCard(msg: Message) {

    //add vertical and horizontal padding around message (img and column text)
    Row(modifier = Modifier.padding(all = 8.dp)) {

        //Pass in modifier obj to modify img
        Image(
            painter = painterResource(id = R.drawable.mo_img),
            contentDescription = "Profile Picture",
            modifier = Modifier
                // Set image size to 40 dp
                .size(80.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
        )

        //In this row add horizontal space between img and text column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = msg.author)
            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.body)
        }
    }

}*/

//Display img, and text with color, typography, and shape modifications
@Composable
fun MessageCard(msg: Message) {

    Row(modifier = Modifier.padding(all = 8.dp)) {

        Image(
            painter = painterResource(id = R.drawable.mo_img),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                //display a border around image
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = msg.author,
                //add color to text
                color = MaterialTheme.colorScheme.secondary,
                //change size of text
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 5.dp) {
                Text(
                    text = msg.body,
                    //change size of text
                    style = MaterialTheme.typography.bodyMedium,
                    //add padding to body text
                    modifier = Modifier.padding(all = 4.dp)
                )
            }

        }
    }

}

//The Preview Component is separate
// from the component displayed on the screen
/*@Preview*/
@Preview(name = "Light Mode", heightDp = 100)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode",
    heightDp = 100
)
@Composable
fun PreviewMessageCard() {
    /*MessageCard(name = "Android")*/
    /*
    //Used with Message data class defined above
    MessageCard(
        msg = Message("Android", "JetPackCompose")
    )*/

    //using provided theme to style the message
    ComposeTutorialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            MessageCard(msg = Message("Android", "JetPackCompose"))
        }
    }
}


