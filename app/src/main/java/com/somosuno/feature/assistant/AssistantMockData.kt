package com.somosuno.feature.assistant

val assistantPreviewMessages = listOf(
    AssistantMessage(
        role = AssistantMessageRole.Assistant,
        text = "Bienvenido. Puedo ayudarte a explorar informes de mercado, variaciones regionales y señales relevantes para distribuidores minoristas de combustibles.",
        caption = "Modo demostración"
    ),
    AssistantMessage(
        role = AssistantMessageRole.User,
        text = "Resume el comportamiento del ACPM en el último trimestre."
    ),
    AssistantMessage(
        role = AssistantMessageRole.Assistant,
        text = "En la versión conectada, esta respuesta combinará datos SICOM, informes trimestrales y notas metodológicas para entregar una lectura ejecutiva con cifras y fuentes.",
        caption = "Respuesta simulada"
    )
)

val assistantSuggestions = listOf(
    AssistantSuggestion("Consumo de ACPM", prominent = true),
    AssistantSuggestion("Comparar departamentos"),
    AssistantSuggestion("Resumen ejecutivo"),
    AssistantSuggestion("Cambios del mercado")
)
