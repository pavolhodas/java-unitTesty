package com.example.demo.widget.repository;

import com.example.demo.widget.model.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WidgetRepository extends CrudRepository<Widget, Long> {

    @Query(value = "SELECT w FROM Widget w WHERE w.name LIKE ?1")
    List<Widget> findWidgetsWithNameLike(String name);
}
