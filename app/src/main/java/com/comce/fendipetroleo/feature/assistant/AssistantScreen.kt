package com.comce.fendipetroleo.feature.assistant

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.comce.fendipetroleo.core.designsystem.component.ComceInputBar
import com.comce.fendipetroleo.core.designsystem.component.ComceInsightCard
import com.comce.fendipetroleo.core.designsystem.component.ComceMessageBubble
import com.comce.fendipetroleo.core.designsystem.component.ComceSuggestionChips
import com.comce.fendipetroleo.core.designsystem.component.ComceTopBar
import com.comce.fendipetroleo.core.designsystem.theme.ComceFendipetroleoMobileAppTheme
import com.comce.fendipetroleo.core.designsystem.theme.ComceGray
import com.comce.fendipetroleo.core.designsystem.theme.ComceInk
import com.comce.fendipetroleo.core.designsystem.theme.ComceSurface

@Composable
fun AssistantScreen(
    messages: List<AssistantMessage> = assistantPreviewMessages,
    suggestions: List<AssistantSuggestion> = assistantSuggestions
) {
    var draft by remember { mutableStateOf("") }

    Scaffold(
        topBar = { ComceTopBar() },
        bottomBar = {
            ComceInputBar(
                value = draft,
                onValueChange = { draft = it },
                modifier = Modifier
                    .navigationBarsPadding()
                    .imePadding()
            )
        },
        containerColor = ComceSurface
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(ComceSurface)
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 18.dp, vertical = 18.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            AssistantIntro()
            ComceInsightCard()
            Text(
                text = "Preguntas sugeridas",
                style = MaterialTheme.typography.titleMedium,
                color = ComceInk
            )
            ComceSuggestionChips(suggestions = suggestions)
            Spacer(modifier = Modifier.height(2.dp))
            messages.forEach { message ->
                ComceMessageBubble(message = message)
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
private fun AssistantIntro() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Text(
            text = "Consulta sectorial en lenguaje natural",
            style = MaterialTheme.typography.headlineSmall,
            color = ComceInk,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "Explora informes, tendencias regionales y lectura ejecutiva del mercado de combustibles.",
            style = MaterialTheme.typography.bodyLarge,
            color = ComceGray
        )
    }
}

@Preview(showBackground = true, widthDp = 390, heightDp = 844)
@Composable
private fun AssistantScreenPreview() {
    ComceFendipetroleoMobileAppTheme(darkTheme = false) {
        AssistantScreen()
    }
}
