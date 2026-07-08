package com.somosuno.feature.assistant

data class AssistantMessage(
    val role: AssistantMessageRole,
    val text: String,
    val caption: String? = null
)

enum class AssistantMessageRole {
    Assistant,
    User
}

data class AssistantSuggestion(
    val label: String,
    val prominent: Boolean = false
)
