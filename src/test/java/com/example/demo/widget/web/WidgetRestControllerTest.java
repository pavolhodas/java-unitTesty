package com.example.demo.widget.web;

import com.example.demo.widget.service.WidgetService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class WidgetRestControllerTest {

    @MockBean
    private WidgetService service;

    @Autowired
    private MockMvc mockMvc;

    // reading materials
    // (https://spring.io/guides/gs/testing-web/)
    // (https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/)

    @Test
    @DisplayName("GET /widgets success")
    void testGetWidgetsSuccess() throws Exception {
        // Setup our mocked service

        // Execute the GET request
    }

    @Test
    @DisplayName("GET /rest/widget/1")
    void testGetWidgetById() throws Exception {
        // Setup our mocked service (https://spring.io/guides/gs/testing-web/) or (https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/)

        // Execute the GET request

        // Validate the returned fields

    }

    @Test
    @DisplayName("GET /rest/widget/1 - Not Found")
    void testGetWidgetByIdNotFound() throws Exception {
        // Setup our mocked service (return empty for findbyid)

        // Execute the GET request

        // Validate the response code (isNotFound)

    }

    @Test
    @DisplayName("POST /rest/widget")
    void testCreateWidget() throws Exception {
        // Setup our mocked service

        // Execute the POST request (using asJsonString method)

    }

    @Test
    @DisplayName("PUT /rest/widget/1")
    void testUpdateWidget() throws Exception {
        // Setup our mocked service

        // Execute the PUT request

    }

    @Test
    @DisplayName("PUT /rest/widget/1 - Conflict")
    void testUpdateWidgetConflict() throws Exception {
        // Setup our mocked service (different versions)

        // Execute the POST request

    }

    @Test
    @DisplayName("PUT /rest/widget/1 - Not Found")
    void testUpdateWidgetNotFound() throws Exception {
        // Setup our mocked service

        // Execute the POST request

    }

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
