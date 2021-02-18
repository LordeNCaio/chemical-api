package com.chemicalgears.chemicalapi.controller;

import com.chemicalgears.chemicalapi.utils.IntegrationTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class SystemControllerTests extends IntegrationTests {

    @WithMockUser("spring")
    @Test
    @DisplayName("Should return system information to match our system information")
    public void testGetSystemInformation() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/system/info")
                .accept(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value("1"));
    }

}
