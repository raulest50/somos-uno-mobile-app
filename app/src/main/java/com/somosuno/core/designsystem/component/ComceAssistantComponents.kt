package com.somosuno.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.somosuno.core.designsystem.theme.ComceBlue
import com.somosuno.core.designsystem.theme.ComceBlueSoft
import com.somosuno.core.designsystem.theme.ComceGray
import com.somosuno.core.designsystem.theme.ComceGreen
import com.somosuno.core.designsystem.theme.ComceGreenSoft
import com.somosuno.core.designsystem.theme.ComceInk
import com.somosuno.core.designsystem.theme.ComceOutline
import com.somosuno.core.designsystem.theme.ComceSurfaceVariant
import com.somosuno.core.designsystem.theme.ComceWhite
import com.somosuno.feature.assistant.AssistantMessage
import com.somosuno.feature.assistant.AssistantMessageRole
import com.somosuno.feature.assistant.AssistantSuggestion

@Composable
fun ComceMessageBubble(
    message: AssistantMessage,
    modifier: Modifier = Modifier
) {
    val isUser = message.role == AssistantMessageRole.User
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = if (isUser) Arrangement.End else Arrangement.Start
    ) {
        Column(
            modifier = Modifier
                .widthIn(max = 328.dp)
                .background(
                    color = if (isUser) ComceBlue else ComceWhite,
                    shape = RoundedCornerShape(
                        topStart = 18.dp,
                        topEnd = 18.dp,
                        bottomStart = if (isUser) 18.dp else 4.dp,
                        bottomEnd = if (isUser) 4.dp else 18.dp
                    )
                )
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = if (isUser) "Consulta" else "COMCE",
                style = MaterialTheme.typography.labelLarge,
                color = if (isUser) ComceWhite.copy(alpha = 0.82f) else ComceGreen,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = message.text,
                style = MaterialTheme.typography.bodyMedium,
                color = if (isUser) ComceWhite else ComceInk
            )
            message.caption?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (isUser) ComceWhite.copy(alpha = 0.72f) else ComceGray
                )
            }
        }
    }
}

@Composable
fun ComceSuggestionChips(
    suggestions: List<AssistantSuggestion>,
    modifier: Modifier = Modifier
) {
    FlowRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        suggestions.forEach { suggestion ->
            TextButton(
                onClick = {},
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.textButtonColors(
                    containerColor = if (suggestion.prominent) ComceGreenSoft else ComceBlueSoft,
                    contentColor = if (suggestion.prominent) ComceInk else ComceBlue
                )
            ) {
                Text(
                    text = suggestion.label,
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}

@Composable
fun ComceInputBar(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = ComceWhite,
        shadowElevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = value,
                onValueChange = onValueChange,
                placeholder = {
                    Text(
                        text = "Pregunta sobre el mercado...",
                        color = ComceGray
                    )
                },
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send)
            )
            Button(
                onClick = {},
                enabled = value.isNotBlank(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ComceBlue,
                    contentColor = ComceWhite,
                    disabledContainerColor = ComceSurfaceVariant,
                    disabledContentColor = ComceGray
                )
            ) {
                Text(text = "Enviar")
            }
        }
    }
}

@Composable
fun ComceInsightCard(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        color = ComceWhite,
        tonalElevation = 1.dp,
        shadowElevation = 1.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "Pulso del informe",
                style = MaterialTheme.typography.titleMedium,
                color = ComceInk
            )
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                MarketSignal("ACPM", "+2,8%", ComceGreenSoft)
                MarketSignal("Corriente", "-0,6%", ComceBlueSoft)
            }
            Text(
                text = "Vista preliminar con datos simulados. Las cifras reales se conectarán en la siguiente fase.",
                style = MaterialTheme.typography.bodyMedium,
                color = ComceGray
            )
        }
    }
}

@Composable
private fun MarketSignal(
    label: String,
    value: String,
    color: androidx.compose.ui.graphics.Color
) {
    Box(
        modifier = Modifier
            .background(color, RoundedCornerShape(8.dp))
            .padding(horizontal = 12.dp, vertical = 10.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                color = ComceGray
            )
            Text(
                text = value,
                style = MaterialTheme.typography.titleMedium,
                color = ComceInk
            )
        }
    }
}
