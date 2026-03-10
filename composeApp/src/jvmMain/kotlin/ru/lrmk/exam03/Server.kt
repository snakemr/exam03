package ru.lrmk.exam03

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.calllogging.CallLogging
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.receive
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.lrmk.exam03.database.Database
import ru.lrmk.exam03.database.User
import java.util.UUID


fun server() = embeddedServer(Netty, port = 80, host = "0.0.0.0", module = {

    install(CallLogging)            // Логирование запросов в консоль

    install(ContentNegotiation) {   // Подсистема обмена данными в формате json
        gson {
            setPrettyPrinting()
        }
    }

    val database by lazy {          // Локальная база данных SQLite в папке проекта
        Database(JdbcSqliteDriver("jdbc:sqlite:data.s3db", schema = Database.Schema))
    }

    routing {
        database  // Заглушка на время работы с sq-файлом. Уберите эту строку при создании API сервера
        // Ваши функции серверного API будут находиться здесь:

    }
})