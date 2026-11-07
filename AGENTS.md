# Instrucciones del proyecto Android Somos Uno

Estas instrucciones se aplican a este repositorio Android y sus subdirectorios. Respetar las instrucciones de mayor prioridad y los cambios locales del usuario. Trabajar desde la raiz Git de este proyecto; no modificar otros proyectos del espacio de trabajo.

## Contexto y convenciones

- Aplicacion Android nativa en Kotlin con Jetpack Compose y Material 3; modulo actual `:app`, paquete `com.somosuno`.
- Codigo en `app/src/main/java/com/somosuno`; componentes y tema en `core/designsystem`; funcionalidad actual en `feature/assistant`.
- La interfaz actual utiliza datos simulados. Inspeccionar el codigo antes de afirmar que existen backend, autenticacion, persistencia o cobertura funcional.
- Arquitectura en `architecture/`, incluido el modelo `New Model.gaphor`. Referencias de identidad visual en `assets/img_empresa/`.
- Preferir PowerShell y el wrapper `gradlew.bat`. Consultar las versiones en los archivos Gradle y el catalogo, sin asumir versiones instaladas o compatibilidad.
- Conservar la terminologia y los textos de producto en espanol. Favorecer cambios pequenos, contratos explicitos y la estructura mas sencilla que resuelva el requisito.
- No imprimir ni versionar secretos, credenciales, keystores, `local.properties` o rutas personales. No trasladar credenciales de otros proyectos a esta aplicacion.

## Orquestacion

El agente principal actua como orquestador y es responsable de integrar y verificar el resultado completo. Utilizar subagentes para trabajo especializado que se pueda delimitar o para una revision independiente; resolver directamente las tareas pequenas que no se beneficien de delegacion. No lanzar todos los especialistas por defecto.

Los perfiles se definen en `.codex/agents/`:

| Nombre | Especialidad | Archivo |
| --- | --- | --- |
| `android_architect` | Arquitectura, contratos, dependencias y diagramas | `.codex/agents/android_architect.toml` |
| `kotlin_android` | Logica, modelos, estado, corrutinas y ciclo de vida | `.codex/agents/kotlin_android.toml` |
| `compose_ux` | Pantallas, componentes, accesibilidad y diseno adaptable | `.codex/agents/compose_ux.toml` |
| `android_qa` | Pruebas, regresiones y revision de calidad | `.codex/agents/android_qa.toml` |
| `mobile_security` | Seguridad movil y proteccion de datos | `.codex/agents/mobile_security.toml` |
| `gradle_cicd` | Compilacion, dependencias, pipelines y versiones | `.codex/agents/gradle_cicd.toml` |

Los seis perfiles forman un catalogo; el limite configurado es de tres subagentes concurrentes, sujeto al limite efectivo del cliente. Heredar el modelo, esfuerzo de razonamiento y permisos de la sesion. Ningun perfil establece permisos independientes.

### Asignacion y coordinacion

1. Leer el requisito, `git status`, las instrucciones aplicables y los archivos afectados. Distinguir cambios existentes de los realizados para la tarea.
2. Precisar objetivo, alcance y criterios de aceptacion. Cuando haya cambios entre capas, acordar contratos con `android_architect` antes de implementar sus consumidores.
3. Seleccionar solo los especialistas necesarios. Cada encargo debe indicar objetivo, contexto suficiente, archivos que puede editar, archivos compartidos que debe preservar, contratos acordados y validacion esperada. Indicar si el encargo es analisis, revision o implementacion.
4. Para cada especialista, usar su nombre cuando el cliente admita perfiles personalizados. Si la herramienta de delegacion solo admite agentes genericos, leer el TOML del perfil y pasar sus `developer_instructions` como instrucciones del encargo, junto con el contexto del proyecto. Informar si se uso esta alternativa; no afirmar que el cliente descubrio un perfil sin haberlo comprobado.
5. Paralelizar solo tareas independientes. Asignar un unico editor por archivo; serializar cambios en modelos compartidos, puntos de entrada, manifiesto, catalogo de versiones y scripts Gradle. Coordinar tambien los archivos de prueba. Los subagentes devuelven necesidades al principal y no crean mas subagentes.
6. Integrar los resultados y revisar el diff completo. Una revision realizada sobre un estado anterior debe comprobarse contra el resultado integrado si este afecta a sus conclusiones. El principal resuelve conflictos preservando cambios ajenos y ejecuta la validacion correspondiente.
7. Comunicar que cambio, por que, como se verifico y que sigue sin comprobarse. Distinguir evidencia observada, inferencias y propuestas.

### Seleccion de especialistas

- Limites entre capas, nuevos modulos o decisiones estructurales: `android_architect`.
- Logica y estado: `kotlin_android`; interfaz y experiencia: `compose_ux`. Acordar el contrato antes de trabajar en paralelo.
- Logica nueva, correcciones y cambios de interaccion con riesgo de regresion: `android_qa` para casos relevantes o revision independiente.
- Autenticacion, datos sensibles, permisos, componentes expuestos o red: `mobile_security` para el alcance afectado.
- Scripts Gradle, versiones, toolchains, pipelines o entregas: `gradle_cicd`; sumar seguridad si se modifica firma o manejo de secretos.

## Validacion

Elegir comprobaciones proporcionales al cambio. Estos comandos se ejecutan desde la raiz del proyecto cuando correspondan:

```powershell
.\gradlew.bat :app:assembleDebug
.\gradlew.bat :app:testDebugUnitTest
.\gradlew.bat :app:lintDebug
```

Para pruebas instrumentadas, comprobar primero que haya dispositivo o emulador disponible y ejecutar `:app:connectedDebugAndroidTest` cuando sea pertinente. Revisar los informes generados; una compilacion exitosa no demuestra comportamiento correcto ni validacion visual.

Los cambios exclusivos de instrucciones o perfiles requieren validar sintaxis TOML, campos requeridos, nombres y rutas. No requieren una compilacion Android. No crear pruebas triviales para estos cambios.

Cada subagente debe entregar: resultado o hallazgos concretos, archivos modificados o evidencia localizada, comprobaciones realmente ejecutadas con sus resultados, y supuestos o limitaciones. Nunca presentar una comprobacion pendiente como exitosa.

## Uso de la configuracion

Abrir este repositorio como proyecto o iniciar la sesion desde su raiz para cargar su configuracion e instrucciones. Si el cliente no recoge archivos recien creados, iniciar una nueva sesion en este repositorio. La disponibilidad de perfiles depende del cliente y de la configuracion de confianza efectiva.

Ejemplo de encargo: "Implementa la funcionalidad indicada usando kotlin_android para el estado y compose_ux para la interfaz; acuerda primero el contrato y utiliza android_qa para revisar el resultado."

Configuracion basada en la documentacion oficial de OpenAI:
- https://learn.chatgpt.com/docs/agent-configuration/subagents
- https://learn.chatgpt.com/docs/agent-configuration/agents-md
