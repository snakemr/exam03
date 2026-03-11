package ru.lrmk.exam03

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import exam03.composeapp.generated.resources.Res
import exam03.composeapp.generated.resources.icon
import org.jetbrains.compose.resources.painterResource
import ru.lrmk.exam03.tests.Tests

// Пожалуйста, не вносите изменения в этот файл. Интерфейс пользователя описывайте в файле Application.kt.

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        state = rememberWindowState(size = DpSize(480.dp, 960.dp)),
        icon = painterResource(Res.drawable.icon),
        title = "Демоэкзамен по модулю № 3",
    ) {
        DisposableEffect(Unit) {
            val server = server().start(wait = false)
            onDispose {
                server.stop()
            }
        }
        MaterialTheme {
            Column {
                Surface(Modifier.fillMaxWidth().weight(1f), color = Color.White) {
                    Application()
                }
                Tests { Client() }
            }
        }
    }
}