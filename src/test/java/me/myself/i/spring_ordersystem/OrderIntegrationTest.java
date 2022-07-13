package me.myself.i.spring_ordersystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    @DirtiesContext
    @Test
    void getOneOrder() throws Exception {

        mockMvc.perform(
                        post("/shop/api/orders/123")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                        [1, 2]
                                        """)
                )
                .andExpect(status().isOk())
                .andExpect(content().string(""));


        mockMvc.perform(

                        get("/shop/api/orders/123"))
                        .andExpect(status().isOk())
                        .andExpect(content().

                        json("""
                                {"id":123,"products":[{"id":1,"name":"Apfel"},{"id":2,"name":"Banane"}]}
                                """));
    }

    @DirtiesContext
    @Test
    void getAllOrders() throws Exception {
        getOneOrder();
        mockMvc.perform(get("/shop/api/orders"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                                [{"id":123,"products":[{"id":1,"name":"Apfel"},{"id":2,"name":"Banane"}]}]
                        """));
    }


}

