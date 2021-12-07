package com.example.calcdemo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class CalcDemoApplicationTests {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
    @Test
    public void givenWac_whenServletContext_thenItProvidesGreetController() {
        ServletContext servletContext = webApplicationContext.getServletContext();

        Assertions.assertNotNull(servletContext);
        Assertions.assertTrue(servletContext instanceof MockServletContext);
        Assertions.assertNotNull(webApplicationContext.getBean("calculator"));
    }
    @Test
    public void sumTest() throws Exception {
        this.mockMvc.perform(get("/sum?a=5&b=5")).andDo(print())
                .andExpect(status().isOk()).andExpect(content().string("10"));
    }
    @Test
    public void differTest() throws Exception {
        this.mockMvc.perform(get("/differ?a=5&b=5")).andDo(print())
                .andExpect(status().isOk()).andExpect(content().string("0"));
    }

    @Test
    public void multiplyTest() throws Exception {
        this.mockMvc.perform(get("/multiply?a=5&b=5")).andDo(print())
                .andExpect(status().isOk()).andExpect(content().string("25"));
    }

    @Test
    public void divTest() throws Exception {
        this.mockMvc.perform(get("/div?a=5&b=5")).andDo(print())
                .andExpect(status().isOk()).andExpect(content().string("1"));
    }

    @Test
    public void incorrectNumberTest() throws Exception {
        this.mockMvc.perform(get("/div?a=s&b=5")).andDo(print())
                .andExpect(status().isOk()).andExpect(content().string("Incorrect number"));
    }

    @Test
    public void numberIsNullTest() throws Exception {
        this.mockMvc.perform(get("/div?a=5")).andDo(print())
                .andExpect(status().isOk()).andExpect(content().string("Some number is null"));
    }


}
