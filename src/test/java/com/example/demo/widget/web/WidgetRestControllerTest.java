package com.example.demo.widget.web;

import com.example.demo.widget.model.Widget;
import com.example.demo.widget.service.WidgetService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        Widget widget1 = new Widget(1l, "Widget Name", "Description", 1);
        Widget widget2 = new Widget(2l, "Widget 2 Name", "Description 2", 4);
        doReturn(Lists.newArrayList(widget1, widget2)).when(service).findAll();

        // Execute the GET request
        mockMvc.perform(get("/rest/widgets"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Widget Name")))
                .andExpect(jsonPath("$[0].description", is("Description")))
                .andExpect(jsonPath("$[0].version", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("Widget 2 Name")))
                .andExpect(jsonPath("$[1].description", is("Description 2")))
                .andExpect(jsonPath("$[1].version", is(4)));
    }

    @Test
    @DisplayName("GET /rest/widget/1")
    void testGetWidgetById() throws Exception {
        // Setup our mocked service (https://spring.io/guides/gs/testing-web/) or (https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/)
        Widget widget = new Widget(1L, "Widget Name", "Description", 1);
        // Execute the GET request
        mockMvc.perform( MockMvcRequestBuilders
                        .get("/rest/widget/{id}", 1))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Widget Name")))
                .andExpect(jsonPath("$.description", is("Description")))
                .andExpect(jsonPath("$.version", is(1)));
        // Validate the returned fields

    }

    @Test
    @DisplayName("GET /rest/widget/1 - Not Found")
    void testGetWidgetByIdNotFound() throws Exception {
        // Setup our mocked service (return empty for findbyid)
        doReturn(null).when(service).findById(1L);
        // Execute the GET request
        mockMvc.perform( MockMvcRequestBuilders
                        .get("/rest/widget/{id}", 1))
                .andExpect(status().isNotFound());
        // Validate the response code (isNotFound)

    }

    @Test
    @DisplayName("POST /rest/widget")
    void testCreateWidget() throws Exception {
        // Setup our mocked service
        Widget postWidget = new Widget(1L, "Widget Name", "Description", 1);

        // Execute the POST request (using asJsonString method)
        mockMvc.perform( MockMvcRequestBuilders
                        .post("/rest/widget")
                        .content(asJsonString(postWidget))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Widget Name")))
                .andExpect(jsonPath("$.description", is("Description")))
                .andExpect(jsonPath("$.version", is(1)));
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
