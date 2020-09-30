package com.fierastudio.linktracker.controller;

import com.fierastudio.linktracker.repository.LinkRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(LinkController.class)
public class LinkControllerTest {
    @MockBean
    private LinkRepository linkRepository;

    @Autowired
    LinkController linkController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenCreateLinkWithNoData_thenInvalidResponse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/create")
                .contentType(MediaType.ALL))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void whenCreateLinkWithValidData_thenValidResponse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/create")
                .param("url", "http://www.google.com")
                .param("password", "ThisIsMyPassword")
                .contentType(MediaType.ALL))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /*
    @Test
    public void whenRedirectLinkWithValidData_thenValidResponse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/l/aBGdfDs")
                .contentType(MediaType.ALL))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void whenRemoveLinkWithInvalidData_thenInvalidResponse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/l/aBGdfDs")
                .contentType(MediaType.ALL))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void whenRemoveLinkWithValidData_thenValidResponse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/l/aBGdfDs")
                .contentType(MediaType.ALL))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    */

}
