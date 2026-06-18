package com.comce.fendipetroleo.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.comce.fendipetroleo.core.designsystem.theme.ComceGreen
import com.comce.fendipetroleo.core.designsystem.theme.ComceInk
import com.comce.fendipetroleo.core.designsystem.theme.ComceWhite

@Composable
fun ComceTopBar(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = ComceInk,
        contentColor = ComceWhite
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 18.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ComceMark()
            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(
                    text = "Asistente COMCE",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Mercado de combustibles y energía",
                    style = MaterialTheme.typography.bodyMedium,
                    color = ComceWhite.copy(alpha = 0.78f)
                )
            }
        }
    }
}

@Composable
private fun ComceMark() {
    Box(
        modifier = Modifier
            .size(44.dp)
            .clip(CircleShape)
            .background(ComceGreen),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "C",
            style = MaterialTheme.typography.titleLarge,
            color = ComceInk,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp)
                .fillMaxWidth(0.34f)
                .height(3.dp)
                .clip(CircleShape)
                .background(ComceWhite.copy(alpha = 0.85f))
        )
    }
}
