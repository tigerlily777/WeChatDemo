package com.example.wechatdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wechatdemo.ui.theme.WeChatDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeChatDemoTheme {
                Column {
                    //WeChatBottomBar()
                }
            }
        }
    }
}

@Composable
private fun WeChatBottomBar(selected: Int) {
    Row {
        TabItem(
            if (selected == 0) R.drawable.ic_chat_filled else R.drawable.ic_chat_outlined,
            "Chat",
            Modifier.weight(1f)
        )
        TabItem(
            if (selected == 1) R.drawable.ic_contacts_filled else R.drawable.ic_contacts_outlined,
            "Contacts",
            Modifier.weight(1f)
        )
        TabItem(
            if (selected == 2) R.drawable.ic_discovery_filled else R.drawable.ic_discovery_outlined,
            "Discover",
            Modifier.weight(1f)
        )
        TabItem(
            if (selected == 3) R.drawable.ic_me_filled else R.drawable.ic_me_outlined,
            "Me",
            Modifier.weight(1f)
        )
    }
}

@Composable
private fun TabItem(@DrawableRes iconId: Int, title: String, modifier: Modifier) {
    Column(
        modifier = Modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(iconId),
            contentDescription = title,
            modifier = Modifier.size(24.dp),
        )
        Text(text = title, fontSize = 11.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun TabItemPreview() {
    TabItem(iconId = R.drawable.ic_chat_outlined, title = "Chat", modifier = Modifier)
}

@Preview(showBackground = true)
@Composable
fun WeChatBottomBarPreview() {
    WeChatBottomBar(selected = 0)
}