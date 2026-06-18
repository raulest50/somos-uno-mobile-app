package com.comce.fendipetroleo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.comce.fendipetroleo.core.designsystem.theme.ComceFendipetroleoMobileAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComceFendipetroleoMobileAppTheme {
                ComceApp()
            }
        }
    }
}
