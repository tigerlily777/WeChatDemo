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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeChatDemoTheme {
                Column {
                    WeChatBottomBar(0)
                }
            }
        }
    }
}

@Composable
private fun WeChatBottomBar(selectId: Int) {
    Row(modifier = Modifier.background(WeChatDemoTheme.colors.bottomBar)) {
        TabItem(
            iconId = if (selectId == 0) R.drawable.ic_chat_filled else R.drawable.ic_chat_outlined,
            title = "Chat",
            modifier = Modifier.weight(1f),
            tint = if (selectId == 0) WeChatDemoTheme.colors.iconCurrent else WeChatDemoTheme.colors.icon
        )
        TabItem(
            if (selectId == 1) R.drawable.ic_contacts_filled else R.drawable.ic_contacts_outlined,
            "Contacts",
            modifier = Modifier.weight(1f),
            tint = if (selectId == 1) WeChatDemoTheme.colors.iconCurrent else WeChatDemoTheme.colors.icon
        )
        TabItem(
            if (selectId == 2) R.drawable.ic_discovery_filled else R.drawable.ic_discovery_outlined,
            "Discover",
            modifier = Modifier.weight(1f),
            tint = if (selectId == 2) WeChatDemoTheme.colors.iconCurrent else WeChatDemoTheme.colors.icon
        )
        TabItem(
            iconId = if (selectId == 3) R.drawable.ic_me_filled else R.drawable.ic_me_outlined,
            title = "Me",
            modifier = Modifier.weight(1f),
            tint = if (selectId == 3) WeChatDemoTheme.colors.iconCurrent else WeChatDemoTheme.colors.icon
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
        Text(
            text = title,
            fontSize = 11.sp,
            color = tint
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TabItemPreview() {
    TabItem(
        iconId = R.drawable.ic_chat_outlined,
        title = "Chat",
        modifier = Modifier,
        tint = WeChatDemoTheme.colors.icon
    )
}

@Preview(showBackground = true)
@Composable
fun WeChatBottomBarPreviewLight() {
    WeChatDemoTheme(theme = WeChatDemoTheme.Theme.Light) {
        WeChatBottomBar(selectId = 0)
    }
}

@Preview(showBackground = true)
@Composable
fun WeChatBottomBarPreview() {
    WeChatDemoTheme(theme = WeChatDemoTheme.Theme.Dark) {
        WeChatBottomBar(selectId = 0)
    }
}

@Preview(showBackground = true)
@Composable
fun WeChatBottomBarPreviewNewYear() {
    WeChatDemoTheme(theme = WeChatDemoTheme.Theme.NewYear) {
        WeChatBottomBar(selectId = 0)
    }
}