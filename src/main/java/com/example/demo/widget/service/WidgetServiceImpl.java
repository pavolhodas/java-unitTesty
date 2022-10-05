package com.example.demo.widget.service;


import com.example.demo.widget.model.Widget;
import com.example.demo.widget.repository.WidgetRepository;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WidgetServiceImpl implements WidgetService {

    private WidgetRepository repository;

    public WidgetServiceImpl(WidgetRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Widget> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Widget> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public Widget save(Widget widget) {
        // Increment the version number
        widget.setVersion(widget.getVersion()+1);

        // Save the widget to the repository
        return repository.save(widget);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
