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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
            /*//Used with Message data class defined below
            MessageCard(msg = Message("Android", "JetPackCompose"))
*/
            //using provided theme to style the message
            ComposeTutorialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MessageCard(msg = Message("Fixed Income",
                        "a type of investment that pays the investor a fixed amount on a fixed schedule"))
                }
            }


        }
    }
}


//func passed in name and configs text elmnt
/*@Composable
fun MessageCard(name: String){
    Text(text = "Hello, $name!")
}*/

/*@Preview
@Composable
fun PreviewMessageCard(){
    MessageCard(Message("Android", "JetPackCompose"))
}*/

//create a class that holds author and body to be displayed
data class Message(val author: String, val body: String)


//Display without column
/*@Composable
fun MessageCard(msg: Message){
    Column {
        Text(text = msg.author)
        Text(text = msg.body)
    }
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

    Column {
        Row {
            Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = "Profile Picture"
            )
            Column {
                Text(text = msg.author)
                Text(text = msg.body)
            }
        }

        Row {
            Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = "Profile Picture"
            )
            Column {
                Text(text = msg.author)
                Text(text = msg.body)
            }
        }
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
/*@Preview(name = "Light Mode", heightDp = 100)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode",
    heightDp = 100
)
@Composable
fun PreviewMessageCard() {
    *//*MessageCard(name = "Android")*//*
    *//*
    //Used with Message data class defined above
    MessageCard(
        msg = Message("Android", "JetPackCompose")
    )*//*

    //using provided theme to style the message
    ComposeTutorialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            MessageCard(msg = Message("Android", "JetPackCompose"))
        }
    }
}*/
@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    ComposeTutorialTheme {
        Conversation(SampleData.conversationSample)
    }
}

/**
 * SampleData for Jetpack Compose Tutorial
 */

object SampleData {
    // Sample conversation data
    val conversationSample = listOf(
        Message(
            "Fixed Income",
            "a type of investment that pays the investor a fixed amount on a fixed schedule".trim()
        ),
        Message(
            "Bond",
            """In finance, a bond is a type of security under which the issuer owes the holder a debt, and is obliged – depending on the terms – to provide cash flow to the creditor.""".trim()
        ),
        Message(
            "Roth IRA",
            """A Roth IRA is an individual retirement account under United States law that is generally not taxed upon distribution, provided certain conditions are met.""".trim()
        ),
        Message(
            "Vehicles",
            "a financial account or product used to create returns. In other words, it generally refers to any container investors use to grow their money. This includes individual securities such as stocks and bonds or pooled investments like mutual funds and ETFS.".trim()
        ),
        Message(
            "Mutual Fund",
            """A mutual fund is a type of investment vehicle consisting of a portfolio of stocks, bonds, or other securities. It gives small or individual investors access to diversified, professionally managed portfolios. Instead of investing in a single stock or bond, by purchasing shares of a mutual fund, the investor can reap the benefits of a diversified portfolio.""".trim()
        ),
        Message(
            "ETF (Exchange-Traded Fund)",
            "a type of pooled investment security that operates much like a mutual fund, but unlike mutual funds, ETFs can be purchased or sold on a stock exchange the same way that a regular stock can. This means that ETF share prices fluctuate all day as the ETF is bought and sold; this is different from mutual funds, which only trade once a day after the market closes.  ETFs generally also have less fees associated with it than mutual funds.".trim()
        ),
        Message(
            "Bond",
            "A bond is a debt security, which means borrowers issue bonds to raise money from investors willing to lend them money for a certain amount of time. When you buy a bond, you are lending to the issuer, which may be a government, municipality, or corporation. In return, the issuer promises to pay you a specified rate of interest during the life of the bond and to repay the principal, also known as face value or par value of the bond, when it \"matures,\" or comes due after a set period of time.".trim()
        ),
        Message(
            "Coupon Payment",
            "A coupon or coupon payment is the annual interest rate paid on a bond.".trim()
        ),
        Message(
            "Principal",
            "The principal refers to the face value of the bond, that is, the money the investor lent to the bond issuer, which the issuer promises to pay back at the maturity date.".trim()
        ),
        Message(
            "Maturity Date",
            "the date on which the final payment is due on the bond, at which point the principal (and all remaining interest) is due to be paid.".trim()
        ),
        Message(
            "Credit Risk",
            "Credit risk refers to the risk that a lender may not receive the owed principal and interest. This is an unsystematic risk, which means this risk is often specific to an individual company or market, and thus can be mitigated by diversifying one’s portfolio.".trim()
        ),
        Message(
            "Lexi",
            "Previews are also interactive after enabling the experimental setting"
        ),
        Message(
            "Lexi",
            "Have you tried writing build.gradle with KTS?"
        ),
    )
}


