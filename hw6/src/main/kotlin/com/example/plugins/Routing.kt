package com.example.plugins

import com.example.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.html.*
import io.ktor.response.*
import io.ktor.serialization.*
import kotlinx.coroutines.delay
import kotlinx.html.HTML

fun Application.configureRouting() {
    install(ContentNegotiation){
        json()
    }

    routing {
        get("/") {
            delay(1000)
            val firstName = call.request.queryParameters["firstName"]?: "Default"
            val lastName = call.request.queryParameters["lastName"]?: "Default"
            val age = call.request.queryParameters["age"]?.toInt() ?: 0
            val city = when(call.request.queryParameters["city"]) {
                "kazan" -> Cities.KAZAN
                else -> Cities.NONE
            }


            call.respond(UserProfile(firstName, lastName , age, city))
        }

        get("/reflection") {
            call.respondHtml(status = HttpStatusCode.OK, HTML::userProfileForm)
        }
        get("/reflection2") {
            call.respondHtml(status = HttpStatusCode.OK, HTML::userProfileForm2)
        }


    }

}

fun HTML.userProfileForm() = form(UserProfile("Kirill", "Ivanov", 19, Cities.NIZHNEKAMSK))
fun HTML.userProfileForm2() = form(Car("9","Lada", Countries.RUSSIA))