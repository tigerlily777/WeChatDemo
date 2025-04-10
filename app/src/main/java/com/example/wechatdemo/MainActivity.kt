package com.example.wechatdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wechatdemo.ui.theme.WeChatDemoTheme
import com.example.wechatdemo.ui.theme.black
import com.example.wechatdemo.ui.theme.green3
import com.example.wechatdemo.ui.theme.white1

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
private fun WeChatBottomBar(selectId: Int) {
    Row (modifier = Modifier.background(white1)){
        TabItem(
            iconId = if (selectId == 0) R.drawable.ic_chat_filled else R.drawable.ic_chat_outlined,
            title = "Chat",
            modifier = Modifier.weight(1f),
            tint = if (selectId == 0)  green3 else black
        )
        TabItem(
            if (selectId == 1) R.drawable.ic_contacts_filled else R.drawable.ic_contacts_outlined,
            "Contacts",
            modifier = Modifier.weight(1f),
            tint = if (selectId == 1) green3 else black
        )
        TabItem(
            if (selectId == 2) R.drawable.ic_discovery_filled else R.drawable.ic_discovery_outlined,
            "Discover",
            modifier = Modifier.weight(1f),
            tint = if (selectId == 2) green3 else black
        )
        TabItem(
            iconId =  if (selectId == 3) R.drawable.ic_me_filled else R.drawable.ic_me_outlined,
            title = "Me",
            modifier = Modifier.weight(1f),
            tint = if (selectId == 3) green3 else black
        )
    }
}

@Composable
private fun TabItem(@DrawableRes iconId: Int, title: String, tint: Color, modifier: Modifier) {
    Column(
        modifier = modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(iconId),
            contentDescription = title,
            modifier = Modifier.size(24.dp),
            tint = tint
        )
        Text(text = title,
            fontSize = 11.sp,
            color = tint)
    }
}

@Preview(showBackground = true)
@Composable
fun TabItemPreview() {
    TabItem(iconId = R.drawable.ic_chat_outlined, title = "Chat", modifier = Modifier, tint = black)
}

@Preview(showBackground = true)
@Composable
fun WeChatBottomBarPreview() {
    WeChatBottomBar(selectId = 0)
}