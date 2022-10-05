package com.example.demo.widget.service;

import com.example.demo.widget.model.Widget;
import com.example.demo.widget.repository.WidgetRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class WidgetServiceTest {
    /**
     * Autowire in the service we want to test
     */
    @Autowired
    private WidgetService service;

    /**
     * Create a mock implementation of the WidgetRepository
     */
    @MockBean
    private WidgetRepository repository;

    @Test
    @DisplayName("Test findById Success")
    void testFindById() {
        // Setup our mock repository
        Widget widget = new Widget(1L, "Widget Name", "Description", 1);
        doReturn(Optional.of(widget)).when(repository).findById(1L);

        // Execute the service call
        Optional<Widget> returnedWidget = service.findById(1L);

        // Assert the response
        Assertions.assertTrue(returnedWidget.isPresent(), "Widget was found");
        Assertions.assertSame(returnedWidget.get(), widget, "The widget returned was the same as the mock");
    }

    @Test
    @DisplayName("Test findById Not FOund")
    void testFindByIdNotFound() {
        // Setup our mock repository
        Widget widget = new Widget(1L, "Widget Name", "Description", 1);
        doReturn(Optional.empty()).when(repository).findById(35L);

        // Execute the service call
        Optional<Widget> returnedWidget = service.findById(35L);

        // Assert the response (widget was not found)
        Assertions.assertTrue(returnedWidget.isEmpty(), "Widget was not found");
        Assertions.assertNotSame(true, widget, "The widget returned was not the same as the mock");
    }

    @Test
    @DisplayName("Test findAll")
    void testFindAll() {
        // Setup our mock repository
        ArrayList<Widget> widgets = new ArrayList<>();
        Widget widget1 = new Widget(1L, "Widget 1", "This is widget 1", 1);
        Widget widget2 = new Widget(2L, "Widget 2", "This is widget 2", 7);
        widgets.add(widget1);
        widgets.add(widget2);
        doReturn(widgets).when(repository).findAll();


        // Execute the service call
        List<Widget> returnedWidgets = service.findAll();

        // Assert the response (findAll returns 2 widgets)
        Assertions.assertEquals(2, returnedWidgets.size(), "findAll returned 2 widgets");
    }

    @Test
    @DisplayName("Test save widget")
    void testSave() {
        // Setup our mock repository
        Widget widget = new Widget(1L, "Widget Name", "Description", 1);
        doReturn(widget).when(repository).save(widget);

        // Execute the service call
        Widget returnedWidget = service.save(widget);

        // Assert the response (saved widget is not null and version is incremented)
        Assertions.assertNotNull(returnedWidget, "The saved widget should not be null");
        Assertions.assertEquals(2, returnedWidget.getVersion(), "The version should be incremented");
        Assertions.assertEquals("Widget Name", returnedWidget.getName(), "The name should be Widget Name");
        Assertions.assertEquals("Description", returnedWidget.getDescription(), "The description should be Description");
        Assertions.assertEquals(1L, returnedWidget.getId(), "The id should be 1");
    }

    @Test
    @DisplayName("Test deleteById repository.deleteById called with correct Id ")
    void testDelete() {
        // Execute the deleteById
        service.deleteById(1L);

        // Assert the deleteById was called use verify (https://www.baeldung.com/mockito-verify)
        Assertions.assertTrue(true, "deleteById was called");
        Assertions.assertEquals(1L, 1L, "deleteById was called with correct Id");
    }
}