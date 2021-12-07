package com.example

import io.ktor.http.*
import io.ktor.application.*
import kotlin.test.*
import io.ktor.server.testing.*
import com.example.plugins.*

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication(Application::configureRouting) {
            val uri = "/?firstName=Kirill&lastName=Ivanov&age=19&city=kazan"
            val expected = "{\"firstName\":\"Kirill\",\"lastName\":\"Ivanov\",\"age\":19,\"city\":\"KAZAN\"}"
            handleRequest(HttpMethod.Get, uri).apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(expected, response.content)
            }
        }
    }

    @Test
    fun testRootReflection() {
        withTestApplication(Application::configureRouting) {
            val uri = "/reflection"
            val expected = "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "  <body>\n" +
                    "    <div>\n" +
                    "      <div>age (kotlin.Int) 1<input type=\"text\" value=\"19\" disabled=\"disabled\"></div>\n" +
                    "      <div>city (com.example.Cities) 1<select><option>KAZAN</option><option>MOSCOW</option><option>CHELNY</option><option selected=\"selected\">NIZHNEKAMSK</option><option>NONE</option></select></div>\n" +
                    "      <div>firstName (kotlin.String) 1<input type=\"text\" value=\"Kirill\" disabled=\"disabled\"></div>\n" +
                    "      <div>lastName (kotlin.String) 1<input type=\"text\" value=\"Ivanov\" disabled=\"disabled\"></div>\n" +
                    "    </div>\n" +
                    "  </body>\n" +
                    "</html>\n"
            handleRequest(HttpMethod.Get, uri).apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(expected, response.content)
            }
        }
    }

    @Test
    fun testRootReflection2() {
        withTestApplication(Application::configureRouting) {
            val uri = "/reflection2"
            val expected = "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "  <body>\n" +
                    "    <div>\n" +
                    "      <div>countries (com.example.Countries) 1<select><option selected=\"selected\">RUSSIA</option><option>GERMANY</option><option>ITALY</option><option>USA</option><option>JAPAN</option><option>NONE</option></select></div>\n" +
                    "      <div>model (kotlin.String) 1<input type=\"text\" value=\"Lada\" disabled=\"disabled\"></div>\n" +
                    "      <div>name (kotlin.String) 1<input type=\"text\" value=\"9\" disabled=\"disabled\"></div>\n" +
                    "    </div>\n" +
                    "  </body>\n" +
                    "</html>\n"
            handleRequest(HttpMethod.Get, uri).apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(expected, response.content)
            }
        }
    }
}