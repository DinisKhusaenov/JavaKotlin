package com.example

import com.example.plugins.configureRouting
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.html.*
import kotlinx.serialization.Serializable
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.jvmErasure

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        configureRouting()
    }.start(wait = true)
}


inline fun <reified T : Any> HTML.form(obj: T) {

    body {
        div {
            T::class
                .memberProperties
                .map {
                    div {
                        +"${it.name} (${it.returnType}) ${it.parameters.count()}"

                        val v = if (it.parameters.count() == 1) it.call(obj) else ""

                        val enumClass = it.returnType.jvmErasure.java
                        if (enumClass.isEnum) {
                            select {
                                enumClass.enumConstants.forEach {
                                    option {
                                        selected = it.toString() == v.toString()
                                        text(it.toString())
                                    }
                                }
                            }
                        } else {
                            textInput {
                                value = v.toString()
                                disabled = true
                            }
                        }


                    }
                }
        }
    }
}


@Serializable
class UserProfile(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val city: Cities
)

@Serializable
class Car(
    val name: String,
    val model: String,
    val countries: Countries
)

enum class Countries {
    RUSSIA,
    GERMANY,
    ITALY,
    USA,
    JAPAN,
    NONE
}

enum class Cities {
    KAZAN,
    MOSCOW,
    CHELNY,
    NIZHNEKAMSK,
    NONE
}



