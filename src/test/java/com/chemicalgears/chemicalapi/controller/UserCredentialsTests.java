package com.chemicalgears.chemicalapi.controller;

import com.chemicalgears.chemicalapi.entity.UserCredentials;
import com.chemicalgears.chemicalapi.security.SecurityConstants;
import com.chemicalgears.chemicalapi.utils.IntegrationTests;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserCredentialsTests extends IntegrationTests {

    @Test
    @DisplayName("Try to add a user")
    public void testSignUpUserCredentials() throws Exception {
        var body = mapper.writeValueAsString(new UserCredentials("test", "test10"));
        mockMvc.perform(MockMvcRequestBuilders
                .post(SecurityConstants.SIGNUP_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(body)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
