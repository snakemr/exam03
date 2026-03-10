package ru.lrmk.exam03

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.gson.gson
import ru.lrmk.exam03.database.User

class Client {

    private val client = HttpClient {
        install(ContentNegotiation) {   // Подсистема обмена данными в формате json
            gson()
        }
        defaultRequest {                // Задан путь доступа к серверу по умолчанию
            url("http://localhost")
        }
    }

    // Ваши клиентские функции доступа к API будут находиться здесь:

}