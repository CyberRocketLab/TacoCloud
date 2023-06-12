package com.example.tacocloud;

import com.example.tacocloud.taco.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.hamcrest.Matchers.containsString;
@WebMvcTest(HomeController.class) // Web test for HomeController
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc; // Injects MockMvc

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/")) //Performs GET /
                .andExpect(status().isOk()) // Expects HTTP 200
                .andExpect(view().name("home")) // Expects home view
                .andExpect(content().string(
                        containsString("Welcome to Taco"))); // Expects Welcome to Taco
    }
}
