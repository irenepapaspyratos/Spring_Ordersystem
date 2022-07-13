package me.myself.i.spring_ordersystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getOneProduct() throws Exception {
        mockMvc.perform(get("/shop/api/products/3"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                        					"id": 3,
                        					"name": "Zitrone"
                        				}
                        """));
    }

    @Test
    void getAllProducts() throws Exception {
        mockMvc.perform(get("/shop/api/products"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [{"id":1,"name":"Apfel"},{"id":4,"name":"Mandarine"},{"id":3,"name":"Zitrone"},{"id":2,"name":"Banane"}]
                        """));
    }


}

