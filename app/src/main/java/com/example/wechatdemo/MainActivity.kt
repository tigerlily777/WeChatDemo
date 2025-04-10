package com.example.wechatdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wechatdemo.ui.theme.WeChatDemoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeChatDemoTheme {
                Column {
                    val viewModel: WeViewModel = viewModel()
                    //WeChatBottomBar(onSelectedChange = )
                }
            }
        }
    }
}

