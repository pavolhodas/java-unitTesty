package com.example.demo.widget.repository;


import com.example.demo.widget.model.Widget;
import com.github.database.rider.core.api.connection.ConnectionHolder;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.DBUnitExtension;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ExtendWith(DBUnitExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class WidgetRepositoryTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private WidgetRepository repository;

    public ConnectionHolder getConnectionHolder() {
        return () -> dataSource.getConnection();
    }

    @Test
    @DataSet("widgets.yml")
    void find_all() {
        ArrayList<Widget> widgets = Lists.newArrayList(repository.findAll());
        // call findAll method

        // assert that correct number of widgets was returned based on the DataSet
        Assertions.assertEquals(2, widgets.size(), "Expected 2 widgets in the database");
    }

    @Test
    @DataSet("widgets.yml")
    void findByIdSuccess() {
        List<Widget> widgets = repository.findById(1L).stream().collect(Collectors.toList());
        // call findById method

        // use assert equals on all Widget properties
        Assertions.assertEquals(1L, widgets.get(0).getId(), "Expected id to be 1");
        //Assertions.assertEquals(2L, widgets.get(1).getId(), "Expected id to be 2");

    }

    @Test
    @DataSet("widgets.yml")
    void testFindByIdNotFound() {
        List<Widget> widgets = repository.findById(3L).stream().collect(Collectors.toList());

        // test findById for ID that is not present in widgets.yml dataset and assert that it is not found
        Assertions.assertEquals(0, widgets.size(), "Expected widget was not found");
    }

    @Test
    @DataSet("widgets.yml")
    void find_widgets_with_name_like() {
        List<Widget> widgets = new ArrayList<>(repository.findWidgetsWithNameLike("Widget 1"));

        // test method findWidgetsWithNameLike that it returns correct number of widgets
        Assertions.assertEquals(1, widgets.size(), "Expected 1 widget with name like Widget 1");
    }
}
